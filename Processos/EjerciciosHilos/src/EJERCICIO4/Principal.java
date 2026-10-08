package EJERCICIO4;


public class Principal {

	public static void main(String[] args) {
		
		DetonadorConRetardo h1 = new DetonadorConRetardo("hilo 1",4);
		DetonadorConRetardo h2 = new DetonadorConRetardo("hilo 2",3);
		DetonadorConRetardo h3 = new DetonadorConRetardo("hilo 3",6);
		DetonadorConRetardo h4 = new DetonadorConRetardo("hilo 4",7);

		h1.start();
		h2.start();
		h3.start();
		h4.start();
		
		try {
			
			h1.join();
			h2.join();
			h3.join();
			h4.join();
		}catch(InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
		}
		
        System.out.println("Fin del programa principal (Todos los hilos han terminado)");
	}

}
