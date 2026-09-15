package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Pojo.Mensaje;
import vista.Anadir;

public class GestionDeMensajes {

	private static ArrayList<Mensaje> messages = new ArrayList<Mensaje>();
	

	private static Mensaje messag = new Mensaje();


	public static void leerFechero() {
		
		messages.clear();

		File fichero = new File("src/Fichero/mensajes.txt");
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			String line;
			
			while ((line = br.readLine()) != null) {
				MessageStructure(line);
				// System.out.println(line);

				if (line.contains("***")) {
					
					messages.add(messag);
					messag=new Mensaje();
					
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException e1) {
			System.out.println("Error de E/S");
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void WriteFechero() {

		File fichero = new File("src/Fichero/mensajes.txt");
		BufferedWriter bW = null;
		FileWriter fW = null;
		try {
			fW = new FileWriter(fichero);
			bW = new BufferedWriter(fW);

			Iterator<Mensaje> it = messages.iterator();
			while (it.hasNext()) {
			    Mensaje m = it.next();
				System.out.println(m.toString());
				bW.write(m.toString());
				bW.write("*********************\n");

			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException e1) {
			System.out.println("Error de E/S");
		} finally {
			try {
				bW.close();
				fW.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static int CuantasMensajes() {
		int i = messages.size();
		return i;
	}

	public static void MessageStructure(String line) {


		if (line.startsWith("Fecha:")) {
			messag.setFecha(line);
		}else if (line.startsWith("Hora:")) {
			messag.setHora(line);
		} else if (line.startsWith("Para:")) {
			messag.setPara(line);
		} else if (line.startsWith("De:")) {
			messag.setDe(line);
		} else if (line.startsWith("Asunto:")) {
			messag.setAsunto(line);
		} else if (line.startsWith("Contenido:")  ) {
			messag.setContenido(line);
		}

	}
	
	public static void AddMessag (String fecha,String hora,String de,String para,String asunto,String contenido) {
		
		 Mensaje m = new Mensaje();
		 
		 m.setAsunto("Asunto:"+asunto);
		 m.setContenido("Contenido:"+contenido);
		 m.setDe("De:"+de);
		 m.setPara("Para:"+para);
		 m.setHora("Hora:"+hora);
		 m.setFecha("Fecha:"+fecha);
		 
		 
		 messages.add(m);
		 
		 WriteFechero();
	}
	public static ArrayList<Mensaje> getMessages() {
		return messages;
	}
}
