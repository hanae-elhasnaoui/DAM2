package procesos;

import java.io.IOException;

public class RuntimeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(" vamos a lancar el notpad");
		String[] infoProceso = {"notepad","src/testproces.txt"};
		
		try {
			
			Process processo =Runtime.getRuntime().exec(infoProceso);
		
			System.out.println("EL ID del processo es "+processo.pid());
			int codigoRetorno=processo.waitFor();
			System.out.println("fin del processo con el codigo "+codigoRetorno);
			
		}catch(IOException | InterruptedException e) {
			
			e.printStackTrace();
			
		}
	}

}
