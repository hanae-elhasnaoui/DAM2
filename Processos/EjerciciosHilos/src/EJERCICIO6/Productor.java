package EJERCICIO6;

public class Productor extends Thread {

	private Buffer buff;

	public Productor() {

	}

	public Productor(Buffer b) {
		this.buff=b;
	}

	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			
			
			 try {
				 
				 char letra = (char) ('a' + Math.random() * 26);
					buff.poner(letra);
					System.out.println(letra); 
				 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
