package FileTextoPlano;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class ModeSecuen {

	public static void main(String[] args) {
		Escribir();
		leerfichero();
	}

	public static void leerfichero() {
		

		Reader fichero = null;
		BufferedReader fic = null;
		try {

			File file = new File("Texto.txt");
			fichero = new FileReader(file);
			fic = new BufferedReader(fichero);

			String linea;
			while ((linea = fic.readLine()) != null) {

				System.out.println(linea);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e2) {
			e2.printStackTrace();

		} finally {
			try {
				fic.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void Escribir() {

		BufferedWriter fic=null ;

		try {
			fic = new BufferedWriter(new FileWriter("Texto.txt"));
			for (int i = 0; i < 11; i++) {
				fic.write("fila numeor");
				fic.newLine();
			}
		} catch (FileNotFoundException F) {
			System.out.println("no se encuentra ficher0");
		
		} catch (IOException e) {
			System.out.println("ERROE A e/s");
		} finally {
			try {
				fic.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
