package EjercicioSocketString;

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
	            
	            String personaString=entrada.readUTF();
	            String[] partes=personaString.split(";");
	            
	            Persona p = new Persona();
	            p.setNif(partes[0]);
                p.setApellido(partes[2]);
                p.setGenero(partes[4].charAt(0));
                p.setNombre("Carmen");
                // modificar
                p.setFechaNacimiento(new Date(1983 - 1900, 1 - 1, 1));
                System.out.println("[CLIENTE] Datos modificados localmente a: " + p.getNombre());
                
                String personaModificadaString = p.getNif() + ";" + 
                        p.getNombre() + ";" + 
                        p.getApellido() + ";" + 
                        p.getFechaNacimiento().getTime() + ";" + 
                        p.getGenero();
                
                salida.writeUTF(personaModificadaString);
                System.out.println("[CLIENTE] String modificado enviado de vuelta.");
	            
                salida.close();
	            entrada.close();       
	            socket.close();
	            
	        } catch (IOException e) {
	    		System.out.println("Demasiados clientes por hoy");
	        }
	    }
}
