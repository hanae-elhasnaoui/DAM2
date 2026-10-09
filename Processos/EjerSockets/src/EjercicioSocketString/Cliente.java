package EjercicioSocketString;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
	 public static void main(String[] args) {
	        String host = "localhost";
	        int puerto = 6000;
	        
	        try {
	        	
	            Socket socket = new Socket(host, puerto);
	            
	            System.out.println("Conexión realizada con el servidor");
	            
	            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
	            DataInputStream entrada = new DataInputStream(socket.getInputStream());
	            
	            salida.writeUTF("Hola servidor, soy un cliente");
	            
	            String respuestaServidor = entrada.readUTF();
	            System.out.println(respuestaServidor);
	            
	            salida.close();
	            entrada.close();
	            
	            socket.close();
	            
	        } catch (IOException e) {
	    		System.out.println("Demasiados clientes por hoy");
	        }
	    }
}
