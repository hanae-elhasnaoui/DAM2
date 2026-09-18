package ejercicio7;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
			//pb.directory(new File(".")); 
			Process procesoHijo = pb.start();

			
			PrintWriter es=new PrintWriter(procesoHijo.getOutputStream(),true);
			es.println(txt);
			es.close();
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
			String linea;
			
			System.out.println("\n--- Salida recibida del hijo ---");
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
			procesoHijo.waitFor();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
