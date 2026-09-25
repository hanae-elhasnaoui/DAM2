package EJERCICIO3;


public class Principal {

	public static void main(String[] args) {
		Escritora h1 = new Escritora(true);
		Escritora h2 = new Escritora(false);
		
		Thread th1 = new Thread(h1);
		Thread th2 = new Thread(h2);

		th1.setName("Escritora 1");
		th2.setName("Escritora2");
		

		th1.start();
		th2.start();
		
		
	}

}
