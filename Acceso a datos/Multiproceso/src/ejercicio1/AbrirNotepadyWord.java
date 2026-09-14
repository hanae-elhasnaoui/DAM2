package ejercicio1;

import java.io.IOException;

public class AbrirNotepadyWord {

	public static void main(String[] args) {
		
		
		String [] infoProc1= {"notepad"};
		String [] infoProc2= {"cmd.exe","/c","winword"};
		
		
try {
			
			Process p1 =Runtime.getRuntime().exec(infoProc1);
			Process p21 =Runtime.getRuntime().exec(infoProc2);
			System.out.println("EL PID del processo es "+p1.pid());
			int codigoRetorno=p1.waitFor();
			System.out.println("fin del processo con el codigo "+codigoRetorno);
			
		}catch(IOException | InterruptedException e) {
			
			e.printStackTrace();
			
		}
	}	

	}


