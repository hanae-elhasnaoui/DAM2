package modelo;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Pojo.Partido;

public class GestionPartidos {

	private static ArrayList<Partido> partidos = new ArrayList<>();
	
	static {
	    partidos.add(new Partido("Athletic", "Barcelona", "2", "1", "SanMames", "20/09/26"));
	    partidos.add(new Partido("RealMadrid", "Sevilla", "3", "0", "Bernabeu", "21/09/26"));
	    partidos.add(new Partido("Valencia", "Betis", "1", "1", "Mestalla", "22/09/26"));
	    partidos.add(new Partido("Osasuna", "Girona", "0", "2", "ElSadar", "23/09/26"));
	    partidos.add(new Partido("Getafe", "Celta", "2", "2", "Coliseum", "24/09/26"));
	}
	public static ArrayList<Partido> cargarPartidos() {

		ObjectInputStream dataIS = null;

		try {
			File fichero = new File("Fechero/Resultados.dat");

			FileInputStream fi = new FileInputStream(fichero);

			dataIS = new ObjectInputStream(fi);
			

			while (fi.getChannel().position() < fi.getChannel().size()) {

				Partido p= (Partido) dataIS.readObject();
				partidos.add(p);

			}
			 System.out.println("Partidos cargados correctamente desde el fichero.");

		} catch (FileNotFoundException e) {
			System.err.println("ERROR: El archivo 'Resultados.dat' no existe en la ruta especificada.");
            
		} catch (IOException e) {
			System.err.println(" ERROR: Hubo un fallo general de lectura o entrada/salida (I/O) en el fichero.");
            
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: No se encontró la clase 'Partido' en el proyecto para poder reconstruir el objeto.");

		} finally {
			try {
				if (dataIS != null) {
					dataIS.close();
				}
			} catch (IOException e) {
				System.err.println("ERROR: No se pudo cerrar el flujo del fichero correctamente.");
				e.printStackTrace();
			}
		}

		return partidos;

	}
	
	
	public static boolean guardarPartidos() {
	    
		boolean corr=false;
			    
	    File fichero = new File("Fechero", "Resultados.dat");

	    try {
	    	FileOutputStream fo = new FileOutputStream(fichero);
	    
	        ObjectOutputStream oos = new ObjectOutputStream(fo) ;

	        for (Partido p : partidos) {
	            oos.writeObject(p);
	        }

	        System.out.println("Los partidos se han guardado correctamente.");
	        corr=true; 

	    } catch (IOException e) {
	        System.err.println("ERROR: No se pudieron guardar los partidos en el fichero.");
	        e.printStackTrace();
	        corr= false;
	    }
	    
	    return corr;
	    
	}


	public static ArrayList<Partido> getPartidos() {
		return partidos;
	}


	public static void setPartidos(ArrayList<Partido> partidos) {
		GestionPartidos.partidos = partidos;
	}

	
	

}
