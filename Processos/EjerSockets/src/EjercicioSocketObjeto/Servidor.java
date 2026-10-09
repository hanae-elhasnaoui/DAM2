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
	
	public static void main(String[] args) {
		int puerto = 6000;
		ObjectOutputStream salida;

		try {

			ServerSocket servidor = new ServerSocket(puerto);

			System.out.println("SERVIDOR INICIADO");


				Socket cliente = servidor.accept();
				//entrada=new ObjectInputStream(cliente.getInputStream());
				salida=new ObjectOutputStream(cliente.getOutputStream());
				
				
				Persona p=new Persona();
				p.setApellido("el");
				p.setNombre("hanae");
				p.setGenero('F');
				p.setFechaNacimiento(new Date(1999,06,11));
				p.setNif("1608087");;
				
				salida.writeObject(p);
				System.out.println("Objeto enviado con éxito.");
				
				//entrada.close();
				salida.close();
				cliente.close();

			
			servidor.close();


		} catch (IOException e) {
			System.out.println("Error en el servidor: " + e.getMessage());
		}
	}


}
