package Pojo;

import java.io.Serializable;

public class Partido implements Serializable {

	private String equipoLocal;
	private String equipoVisitante ;
	private String GolesLocal ;
	private String GolesVisitante; 
	private String lugar;
	private String fecha;
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public String getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public String getGolesLocal() {
		return GolesLocal;
	}
	public void setGolesLocal(String golesLocal) {
		GolesLocal = golesLocal;
	}
	public String getGolesVisitante() {
		return GolesVisitante;
	}
	public void setGolesVisitante(String golesVisitante) {
		GolesVisitante = golesVisitante;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Partido(String equipoLocal, String equipoVisitante, String golesLocal, String golesVisitante, String lugar,
			String fecha) {
		super();
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		GolesLocal = golesLocal;
		GolesVisitante = golesVisitante;
		this.lugar = lugar;
		this.fecha = fecha;
	}
	public Partido() {
		
	}

	
	
}
