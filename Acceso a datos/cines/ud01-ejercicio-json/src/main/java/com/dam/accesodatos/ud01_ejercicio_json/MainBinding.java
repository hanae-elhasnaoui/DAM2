package com.dam.accesodatos.ud01_ejercicio_json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;

import com.google.gson.Gson;

public class MainBinding {

	static String ruta = "src/main/resources/cines.json";

	public static void main(String[] args) {

		try {

			Gson gson = new Gson();
			FileReader fr = new FileReader(ruta);
			Cines datos = gson.fromJson(fr, Cines.class);
			System.out.println("Cines disponibles: \n--------------------- ");
			for (Cine c : datos.getCines()) {

				System.out.println(c.getNombre());

			}

			System.out.println("\nlas películas disponibles en el Cines Golem: \n------------------------------- ");

			for (Cine cine : datos.getCines()) {

				if (cine.getNombre().equals("Cines Golem")) {
					for (Pelicula pelicula : cine.getPeliculas()) {
						System.out.println(pelicula.getTitulo());
					}
				}
			}

			for (Cine cine : datos.getCines()) {
				for (Pelicula pelicula : cine.getPeliculas()) {

					if (pelicula.getTitulo().equals("Avatar")) {

						System.out.println("Película: " + pelicula.getTitulo());
						System.out.println("-------------------------");

						for (Sesion sesion : pelicula.getSesiones()) {
							System.out.printf("Hora: %s | Sala: %d | Precio: %.2f €%n", sesion.getHora(),
									sesion.getSala(), sesion.getPrecio());
						}
					}
				}
			}

			System.out.println("\nPelículas de ciencia ficción");
			System.out.println("----------------------------");

			for (Cine cine : datos.getCines()) {
				for (Pelicula pelicula : cine.getPeliculas()) {

					if (pelicula.getGenero().equals("Ciencia ficción")) {
						System.out.println(cine.getNombre() + " -> " + pelicula.getTitulo());
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.printf("Archivo no encontrado", e.getMessage());
		}
	}

}
