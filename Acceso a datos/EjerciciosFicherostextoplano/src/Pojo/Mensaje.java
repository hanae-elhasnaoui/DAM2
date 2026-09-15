package Pojo;

import java.time.LocalDate;
import java.time.LocalTime;


public class Mensaje {

	private String fecha;	
	private String hora ;
	private String para ;
	private String de ;
	private String asunto;
	private String contenido;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	@Override
	public String toString() {
		
		
		String mensaje=fecha+"\n" +  hora +"\n" + para +"\n"  + de +"\n" + asunto
				+"\n" + contenido + "\n";
		
		return mensaje;
	}
	
	
}
