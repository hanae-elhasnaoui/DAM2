package com.dam.accesodatos.ud01_ejercicio_json;

import java.util.List;

public class Cine {
	private String nombre;
	private String ciudad;
	private String direccion;
	private List<Pelicula> peliculas;
	
	 public Cine() {
	    }

	 public String getNombre() {
		 return nombre;
	 }

	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }

	 public String getCiudad() {
		 return ciudad;
	 }

	 public void setCiudad(String ciudad) {
		 this.ciudad = ciudad;
	 }

	 public String getDireccion() {
		 return direccion;
	 }

	 public void setDireccion(String direccion) {
		 this.direccion = direccion;
	 }

	 public List<Pelicula> getPeliculas() {
		 return peliculas;
	 }

	 public void setPeliculas(List<Pelicula> peliculas) {
		 this.peliculas = peliculas;
	 }

	 
}
