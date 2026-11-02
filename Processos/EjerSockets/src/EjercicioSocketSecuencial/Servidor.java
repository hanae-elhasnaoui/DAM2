package EjercicioSocketSecuencial;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

import EjercicioSocketObjeto.Persona;

public class Servidor {

	public static void main(String[] args) {
		int puerto = 6000;
		DataOutputStream salida;
		DataInputStream entrada;

		try {

			System.out.println("Servidor a la espera de un cliente...");

			ServerSocket servidor = new ServerSocket(puerto);
			Socket cliente = servidor.accept();
			System.out.println("Cliente conectado.");

			salida = new DataOutputStream(cliente.getOutputStream());
			entrada = new DataInputStream(cliente.getInputStream());

			 // 1. Enviamos los atributos uno a uno en un orden estricto
            salida.writeUTF("16078123X");               // NIF
            salida.writeUTF("Pepito");                  // Nombre
            salida.writeUTF("Grillo");                  // Apellido
            salida.writeLong(632112000000L);            // Fecha en milisegundos (12/12/1990)
            salida.writeChar('M');                      // Género
            salida.flush();

            // 2. Recibimos las modificaciones en el mismo orden exacto
            String nif = entrada.readUTF();
            String nombreModificado = entrada.readUTF(); // El cliente cambiará esto a "Carmen"
            String apellido = entrada.readUTF();
            long fechaModificada = entrada.readLong();   // El cliente cambiará esto a 1983
            char genero = entrada.readChar();

            // 3. Mostramos el resultado reconstruido
            System.out.println("\n[SERVIDOR] Resultado final recibido secuencialmente:");
            System.out.println("Persona: " + nif + ", " + nombreModificado + ", " + apellido + ", " + fechaModificada + ", " + genero);

            entrada.close();
			salida.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
