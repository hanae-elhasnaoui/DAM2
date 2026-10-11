package com.dam.accesodatos.ud01_ejercicio_json;

import java.util.List;

public class Pelicula {
	  private String titulo;
	    private String genero;
	    private int duracion;
	    private List<Sesion> sesiones;
	    
	    
	    public Pelicula() {
	    }


		public String getTitulo() {
			return titulo;
		}


		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}


		public String getGenero() {
			return genero;
		}


		public void setGenero(String genero) {
			this.genero = genero;
		}


		public int getDuracion() {
			return duracion;
		}


		public void setDuracion(int duracion) {
			this.duracion = duracion;
		}


		public List<Sesion> getSesiones() {
			return sesiones;
		}


		public void setSesiones(List<Sesion> sesiones) {
			this.sesiones = sesiones;
		}
	    
	    
}
