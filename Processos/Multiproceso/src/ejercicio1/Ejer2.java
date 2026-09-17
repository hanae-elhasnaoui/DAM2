package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejer2 {

	public static void main(String[] args) {
		 BufferedReader lector = null;
	      String linea;
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");

			Process processo = pb.start();
			
			InputStream is=processo.getInputStream();
			InputStreamReader ir=new InputStreamReader(is);
			lector=new BufferedReader(ir);
			
			linea=lector.readLine();
			
			while(linea!=null) {
				System.out.println(linea);
				linea=lector.readLine();
			}
			
			
		processo.waitFor();
			

			
		} catch (IOException e) {
			System.out.println("Error al intentar ejecutar la aplicacion" + e.getMessage());
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {

                if (lector != null) {
                    lector.close();
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
		}
	}
}
