package ejercicios_1;

public class HiloThread extends Thread {

	public HiloThread() {
		super();
	}

	public static void main(String[] args) {

		HiloThread ht1 = new HiloThread();
		ht1.setName("Thread 1");

		HiloThread ht2 = new HiloThread();
		ht2.setName("Thread 2");

		ht1.start();
		ht2.start();

		try {

			if (ht1.isAlive()) {

				System.out.println(ht1.getName() + " en processo ");
			}
			if (ht2.isAlive()) {
				System.out.println(ht2.getName() + " en processo");

			}
			ht1.join();
			ht2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ht1.getName() + " ha terminado");

		System.out.println(ht2.getName() + " ha terminado");

	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " - Count : " + i);
		}

	}
}
