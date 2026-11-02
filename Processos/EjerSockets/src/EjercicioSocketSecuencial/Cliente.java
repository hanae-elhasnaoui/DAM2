package EjercicioSocketSecuencial;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Date;

public class Cliente {
	 public static void main(String[] args) {
	        String host = "localhost";
	        int puerto = 6000;
	        
	        try {
	        	
	            Socket socket = new Socket(host, puerto);
	            
	            System.out.println("Conexión realizada con el servidor");
	            
	            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
	            DataInputStream entrada = new DataInputStream(socket.getInputStream());
	            
	            // 1. Leer en el mismísimo orden en el que el servidor escribió
	            String nif = entrada.readUTF();
	            String nombre = entrada.readUTF();
	            String apellido = entrada.readUTF();
	            long fecha = entrada.readLong();
	            char genero = entrada.readChar();

	            // 2. Modificar los dos datos requeridos
	            nombre = "Carmen";
	            fecha = 410223600000L; // Milisegundos para 01/01/1983

	            // 3. Devolver todos los campos uno a uno de vuelta al servidor
	            salida.writeUTF(nif);
	            salida.writeUTF(nombre);
	            salida.writeUTF(apellido);
	            salida.writeLong(fecha);
	            salida.writeChar(genero);
	            salida.flush();
	            
	        } catch (IOException e) {
	    		System.out.println("Demasiados clientes por hoy");
	        }
	    }
}
