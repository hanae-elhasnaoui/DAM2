package Ejercicios;

public class Hilo implements Runnable {
	
	private boolean terminar=false;
	private int i =1;
	private String name ;
		


	
	public Hilo(String name) {
		super();
		this.name=name;
	}
	

	public boolean isTerminar() {
		return terminar;
	}


	public void setTerminar(boolean terminar) {
		this.terminar = terminar;
	}


	public static void main(String[] args) {
		
		Hilo c1=new Hilo("Hilo1");
		Hilo c2=new Hilo("Hilo2");
		
		Thread th1= new Thread(c1);
		Thread th2= new Thread(c2);
		
		th1.start();
		th2.start();
		
		
	}

	@Override
	public void run() {

		
        System.out.println(name + " ha empezado a contar hasta 1000");
		while (!terminar && i<=1000) {
			if(i==1000) {
				setTerminar(true);
			}
			i++;
		}
        System.out.println(name + " ha terminado de contar.");

	}

}
