package EjercicioSocketObjeto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

public class Servidor {

	public static void main(String[] args) throws ClassNotFoundException {
		int puerto = 6000;
		ObjectOutputStream salida;
		ObjectInputStream entrada;

		try {
			System.out.println("Servidor a la espera de un cliente...");

			ServerSocket servidor = new ServerSocket(puerto);

			Socket cliente = servidor.accept();
			System.out.println("Cliente conectado.");
			
			salida = new ObjectOutputStream(cliente.getOutputStream());
			entrada=new ObjectInputStream(cliente.getInputStream());

			Persona p = new Persona();
			p.setApellido("el");
			p.setNombre("hanae");
			p.setGenero('F');
			p.setFechaNacimiento(new Date(1999, 06, 11));
			p.setNif("1608087");
			
			salida.writeObject(p);
			salida.flush();
			System.out.println("Objeto enviado con éxito.");
			
			
			Persona personaModificada = (Persona) entrada.readObject();
			System.out.println("[SERVIDOR] Objeto devuelto por el cliente recibido.");
			System.out.println(personaModificada);
			
			entrada.close();
			salida.close();
			cliente.close();

		} catch (IOException e) {
			System.out.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();

		}
	}

}
