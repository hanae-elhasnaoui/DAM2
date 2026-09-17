package modelo;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Pojo.Partido;

public class GestionPartidos {

	private ArrayList<Partido> partidos = new ArrayList<>();

	public static ArrayList<Partido> cargarPartidos() {

		DataInputStream dataIS = null;

		try {
			File fichero = new File("Fechero/Resultados.dat");

			FileInputStream fi = new FileInputStream(fichero);

			dataIS = new DataInputStream(fi);
			Partido p = new Partido();
			while (fi.getChannel().position() < fi.getChannel().size()) {
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dataIS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;

	}

}
