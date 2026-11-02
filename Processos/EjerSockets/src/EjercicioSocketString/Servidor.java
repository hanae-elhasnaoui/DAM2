package EjercicioSocketString;

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

			Persona p = new Persona();
			p.setApellido("el");
			p.setNombre("hanae");
			p.setGenero('F');
			p.setFechaNacimiento(new Date(1999, 06, 11));
			p.setNif("1608087");

			String personaString = p.getNif() + ";" + p.getNombre() + ";" + p.getApellido() + ";"
					+ p.getFechaNacimiento().getTime() + ";" + p.getGenero();

			salida.writeUTF(personaString);
			System.out.println("\n[SERVIDOR] Enviando datos en formato String: ");

			String respuestaCliente = entrada.readUTF();
			System.out.println("[SERVIDOR] String modificado recibido.");

			// Reconstruir el objeto Persona a partir del String recibido

			String datos[] = respuestaCliente.split(";");
			Persona personaFinal = new Persona();
			personaFinal.setNif(datos[0]);
			personaFinal.setNombre(datos[1]);
			personaFinal.setApellido(datos[2]);
			personaFinal.setFechaNacimiento(new Date(Long.parseLong(datos[3])));
			personaFinal.setGenero(datos[4].charAt(0));
			System.out.println("\n[SERVIDOR] RESULTADO FINAL (Objeto reconstruido):");
            System.out.println(personaFinal);
            

            entrada.close();
			salida.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
