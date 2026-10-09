package EJERCICIO6;

public class Consumidor extends Thread {
	
	
	private Buffer b ;

	public Consumidor(Buffer b) {
		this.b = b;
	}


	@Override
	public void run() {

		try {
			for (int i = 0; i < 10; i++) {

				char letra = b.recoger();

				System.out.println("Consumidor: " + letra);
				
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
