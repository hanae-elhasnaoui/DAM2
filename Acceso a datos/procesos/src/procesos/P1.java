package procesos;

import java.io.File;
import java.nio.file.DirectoryIteratorException;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" Processo principal ");

		int valorRetorno;
		try {

			ProcessBuilder build;
			build = new ProcessBuilder("java", "procesos.P2");
			build.directory(new File("bin"));
			Process process = build.start();

			valorRetorno = process.waitFor();

			if (valorRetorno == 0) {
				System.out.println("processo 2 finilizado con exito");

			} else {
				System.out.println("el processor 2 ha fallado");
				System.out.println("el codigo de erro:" + valorRetorno);
			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}

}
