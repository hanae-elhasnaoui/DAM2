package ejercicio7;

import java.util.Scanner;

public class EjemploLectura {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		if (teclado.hasNextLine()) {

			String txtInput = teclado.nextLine();

			System.out.println(txtInput);

		}

		teclado.close();
	}
}
