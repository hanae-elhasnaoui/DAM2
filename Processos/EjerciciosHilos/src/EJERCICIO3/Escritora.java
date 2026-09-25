package EJERCICIO3;

public class Escritora implements Runnable {
    private boolean b;
    
	Escritora(boolean b){
		this.b=b;
	}
	
	@Override
	public void run() {
	
	while(true) {
		if(b) {
			for (int i = 0; i < 30; i++) {
				System.out.println(i+1);
				
			}

		}else {
			
			for (int i = 97; i <= 122; i++) {
				System.out.println((char)i);
				
			}
			
		}
	}
	}
}
