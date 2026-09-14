package ejercicio1;

import java.io.IOException;
import java.util.Map;

public class ProcessBuilderNotpad {

	public static void main(String[] args) {
	

				
				System.out.println(" vamos a lancar el notpad");
				String infoProceso = "notepad.exe";
				
				try {
					
					ProcessBuilder processo =new ProcessBuilder(infoProceso);
					Map<String,String> environment=processo.environment();
					
					System.out.println("Numero de procesadores "+environment.get("NUMBER_OF_PROCESSORS"));
				
					Process p =processo.start();
					int codigoRetorno=p.waitFor();
					
					System.out.println("fin del processo con el codigo "+codigoRetorno);

					
				}catch(IOException | InterruptedException e) {
					
					e.printStackTrace();
					
				}
	}
	}

