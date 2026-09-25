package ejercicios_1;

public class Ej3 extends Thread {

	public Ej3() {
		super();
	}

	public static void main(String[] args) {

		Ej3 ht1 = new Ej3();
		ht1.setName("Thread 1");

		Ej3 ht2 = new Ej3();
		ht2.setName("Thread 2");

		ht1.start();
		ht2.start();

		try {

			ht1.join();
			ht2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ht1.getName() + " ha terminado");

		System.out.println(ht2.getName() + " ha terminado");

	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " - Operacion : " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
