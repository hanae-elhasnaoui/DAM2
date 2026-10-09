package EjercicioSocketObjeto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.Date;

public class Cliente {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6000;
		ObjectInputStream entrada;

		try {

			Socket socket = new Socket(host, puerto);

			System.out.println("Conexión realizada con el servidor");
			entrada=new ObjectInputStream(socket.getInputStream());
			Persona p=(Persona) entrada.readObject();
			p.setNombre("carmen");
			p.setFechaNacimiento(new Date(1983,1,11));

			
			System.out.println(p.toString());
			socket.close();
			

		} catch (IOException e) {
			System.out.println("Demasiados clientes por hoy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
