package ejercicio7;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejer7 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce el texto :  ");
		String txt = teclado.nextLine();

		teclado.close();

		ProcesoEjemploLectura(txt);
	}

	private static void ProcesoEjemploLectura(String txt) {

		try {
			ProcessBuilder pb = new ProcessBuilder("java", "ejercicio7.EjemploLectura");
			pb.redirectOutput(ProcessBuilder.Redirect.INHERIT); 
			Process procesoHijo = pb.start();

			
			PrintWriter es=new PrintWriter(procesoHijo.getOutputStream(),true);
			es.println(txt);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
