package EJERCICIO4;


public class Principal {

	public static void main(String[] args) {
		
		DetonadorConRetardo h1 = new DetonadorConRetardo("hilo 1",20);
		DetonadorConRetardo h2 = new DetonadorConRetardo("hilo 1",20);
		DetonadorConRetardo h3 = new DetonadorConRetardo("hilo 1",20);

		Thread th1 = new Thread();

		th1.setName("Escritora 1");
	  	

		th1.start();
		
		
	}

}
