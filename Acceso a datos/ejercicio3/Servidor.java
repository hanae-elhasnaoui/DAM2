package ejercicio3;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args){
		File foto = new File("src/ejercicio3/fotoNormal.jpg");
		System.out.println("esperando conexion....");
		try (ServerSocket servidor = new ServerSocket(7000)) {
			Socket cliente = servidor.accept();

			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
			try (FileInputStream archivo = new FileInputStream(foto)) {
				salida.writeLong(foto.length());
				 byte[] buffer = new byte[4096];
				 int leidos;
				 while ((leidos = archivo.read(buffer))!=-1) {
					salida.write(buffer,0,leidos);
				}
			}
			salida.flush();
		} catch (IOException e) {
			System.out.println("puede ser una problema con el puerto ");
		}
	}

}
