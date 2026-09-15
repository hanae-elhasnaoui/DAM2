package ejercicio1;

import java.io.IOException;

public class Ejer2 {

	public static void main(String[] args) {

		try {
			ProcessBuilder pb = new ProcessBuilder("cmd.exe");

			Process processo = pb.start();

			
		} catch (IOException e) {
			System.out.println("Error al intentar ejecutar la aplicacion" + e.getMessage());
		}
	}
}
