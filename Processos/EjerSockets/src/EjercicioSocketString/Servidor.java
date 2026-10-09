package EjercicioSocketString;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int maxClient = 3;
		int puerto = 6000;

		try {

			ServerSocket servidor = new ServerSocket(puerto);

			System.out.println("SERVIDOR INICIADO");

			for (int i = 0; i < maxClient; i++) {

				Socket cliente = servidor.accept();

				DataInputStream entrada = new DataInputStream(cliente.getInputStream());
				DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

				String mensajeCliente = entrada.readUTF();
				System.out.println("Recibido " + mensajeCliente);

				salida.writeUTF("Saludos desde el servidor al cliente Nº " + (i + 1));

				cliente.close();

			}
			servidor.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
