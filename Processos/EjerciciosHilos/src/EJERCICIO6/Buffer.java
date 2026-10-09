package EJERCICIO6;

public class Buffer {
	
	
	private char contenido;
	private boolean bufferLleno;
	
	public Buffer() {
		
	}
	
	public Buffer(char contenido, boolean bufferLleno) {
		super();
		this.contenido = contenido;
		this.bufferLleno = bufferLleno;
	}
	
	public void poner(char c) {
		
		this.contenido=c;
		this.bufferLleno=true;
	}
	
	public char recoger() {
		
		
		if(bufferLleno) {
			this.bufferLleno=false;
			return this.contenido;
		}else {
			return ' ';
		}
		

	}

}
