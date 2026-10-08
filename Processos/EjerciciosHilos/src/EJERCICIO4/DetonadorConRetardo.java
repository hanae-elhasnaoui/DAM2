package EJERCICIO4;

public class DetonadorConRetardo extends Thread{
	
	private int contador;
	private String nombre;

	public DetonadorConRetardo(String nombre, int cont) {
		this.nombre=nombre;
		this.contador=cont;
		}
	
	@Override
    public void run() {
		
		
		while (contador > 0) {
            System.out.println( getName() + " : " + contador);
            contador--;   
		}
        System.out.println( getName() + " ha FINALIZADO.");

	}
	
	
	}


