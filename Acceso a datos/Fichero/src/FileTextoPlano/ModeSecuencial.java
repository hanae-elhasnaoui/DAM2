package FileTextoPlano;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModeSecuencial {

	public static void main(String[] args) throws IOException {
	
		 Escribir();
		leerfichero();
	}
	
	public static void leerfichero(){
		int i;
		FileReader fic=null;
		try {
			File fichero=new File("Texto.txt");

			 fic=new FileReader(fichero);
			
			try {
				while((i=fic.read())!=-1) {
					
					System.out.println((char)i+" = "+i);
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fic.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
	}
	
	public static void Escribir() {
		FileWriter fic=null;
		try {
			
			File fichero = new File("Texto.txt"); // declara fichero
			 fic = new FileWriter(fichero); // crear el flujo de salida
			
			String cadena = "Esto es una prueba con FileWriter";
			
			char[] cad = cadena.toCharArray(); // convierte un String en array de caracteres

			for(int i=0; i<cad.length; i++)
				fic.write(cad[i] ); // se va escribiendo un carácter
			
			fic.append('*'); // añado al final un *
			
			fic.flush(); // se esfuersa a hacer cambio al fichero
			
			
			fic.write(cad); // escribir un array de caracteres
			
			String c = "\n*Inesto es lo ultimo*";
			fic.write(c);
			
			// escribir un String
			
			/*String prov[] = {"Albacete","Avila","Badajoz", "Cáceres","Huelva","Jaén",
			"Madrid","Segovia","Soria","Toledo",
			"Valladolid","Zamora"};

			fic.write("\n");
			
			for(int i=0; i<prov.length; i++) {
				
				fic.write(prov[i]);
				fic.write("\n");
			} 
	*/
			 
			
		} catch (IOException e) {
			// TODO: handle exception
			
			
		}finally {
			try {
				fic.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
