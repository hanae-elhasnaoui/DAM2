package ejercicio1;

import java.io.IOException;

public class EJER1 {

	public static void main(String[] args) {

		try {
			ProcessBuilder pb = new ProcessBuilder("notepad.exe");

			Process processo = pb.start();

			long pid = processo.pid();

			System.out.println("EL ID asignado al processo es:" + pid);
		} catch (IOException e) {
			System.out.println("Error al intentar ejecutar la aplicacion" + e.getMessage());
		}
	}

}
