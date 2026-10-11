package com.dam.accesodatos.ud01_ejercicio_json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MainTree {
	static String ruta = "src/main/resources/cines.json";

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader(ruta);

			// Parsea el fichero JSON y crea el arbol
			JsonElement raiz = JsonParser.parseReader(fr);

			JsonObject objetoRaiz = raiz.getAsJsonObject();

			JsonArray cines = objetoRaiz.getAsJsonArray("cines");

			System.out.println("Cines disponibles: \n--------------------- ");

			for (JsonElement elemento : cines) {
				JsonObject cine = elemento.getAsJsonObject();
				System.out.println(cine.get("nombre").getAsString());
			}

			System.out.println("\nlas películas disponibles en el Cines Golem: \n------------------------------- ");

			for (JsonElement elemento : cines) {
				JsonObject cine = elemento.getAsJsonObject();
				if (cine.get("nombre").getAsString().equals("Cines Golem")) {
					JsonArray peliculas = cine.getAsJsonArray("peliculas");
					for (JsonElement peli : peliculas) {
						JsonObject pelicula = peli.getAsJsonObject();
						System.out.println(pelicula.get("titulo").getAsString());
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.printf("Archivo no encontrado", e.getMessage());
		}
	}

}
