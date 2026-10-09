package EJERCICIO6;

public class Ejecutable {

	public static void main(String[] args) {
		Buffer bf = new Buffer();
		Productor pr = new Productor(bf);
		Consumidor c = new Consumidor(bf);
		
		pr.start();
		c.start();

	}

}
