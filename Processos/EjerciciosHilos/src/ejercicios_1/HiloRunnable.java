package ejercicios_1;

public class HiloRunnable implements Runnable {

	public static void main(String[] args) {

		HiloRunnable h1 = new HiloRunnable();
		HiloRunnable h2 = new HiloRunnable();

		Thread th1 = new Thread(h1);
		Thread th2 = new Thread(h2);

		th1.setName("Theard 1");
		th2.setName("Theard 2");

		th1.start();
		th2.start();

		try {
			th1.join();
			th2.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!th1.isAlive()) {
			System.out.println(th1.getName() + " ha terminado");
		}
		if (!th2.isAlive()) {
			System.out.println(th2.getName() + " ha terminado");
		}

	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - Count : " + i);
		}

	}

}
