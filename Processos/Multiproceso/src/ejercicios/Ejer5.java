package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejer5 {

	public static void main(String[] args) {

		BufferedReader lector = null;
		String linea;
		boolean encontrado = false;

		try {

			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "tasklist");
			Process processo = pb.start();

			InputStream is = processo.getInputStream();

			InputStreamReader ir = new InputStreamReader(is);

			lector = new BufferedReader(ir);

			linea = lector.readLine();

			while (linea != null) {

				if (linea.toLowerCase().contains("notepad")) {
					encontrado = true;
				}

				linea = lector.readLine();
			}

			processo.waitFor();

			if (encontrado) {
				Process proceso2 = new ProcessBuilder("taskkill", "/IM", "notepad.exe", "/F").start();
				System.out.println("Proceso del Bloc de notas terminado.");
			} else {
				System.out.println("El Bloc de notas no está ejecutándose.");
			}

		} catch (IOException e) {

			System.out.println("Error al intentar ejecutar la aplicacion " + e.getMessage());

		} catch (InterruptedException e) {

			e.printStackTrace();

		} finally {

			try {

				if (lector != null) {
					lector.close();
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}