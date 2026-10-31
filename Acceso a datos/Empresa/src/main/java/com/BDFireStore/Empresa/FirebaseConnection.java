package com.BDFireStore.Empresa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Identity;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class FirebaseConnection {

	private static Firestore db;
	private static String ruta = "firebase-key.json";

	public static void conectar() {
		if (db == null) {
			try {
				FileInputStream serviceAccount = new FileInputStream(ruta);
				// FirebaseOptions options = FirebaseOptions.builder()
				// .setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

				FirebaseOptions options = new FirebaseOptions.Builder()
						.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

				FirebaseApp.initializeApp(options);
				db = FirestoreClient.getFirestore();
				System.out.println("¡Conexión establecida con Firestore de forma exitosa!");

			} catch (IOException e) {
				System.err.println("Error crítico: No se pudo leer el archivo JSON de credenciales.");

				e.printStackTrace();
			}

		}
	}

	// Método público para obtener la base de datos desde cualquier otra clase
	public static Firestore getDatabase() {
		if (db == null) {
			conectar(); // Si no se ha conectado, lo intenta automáticamente
		}
		return db;
	}

}
