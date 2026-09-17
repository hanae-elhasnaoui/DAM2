package ejercicio1;

import java.io.File;
import java.io.IOException;

public class Ejer6 {

    public static void main(String[] args) {

        try {

            ProcessBuilder pb = new ProcessBuilder("ejemplo.bat");

            pb.redirectOutput(new File("salida.txt"));
            pb.redirectError(new File("errores.txt"));

            Process processo = pb.start();

            processo.waitFor();

        } catch (IOException e) {

            System.out.println("Error al intentar ejecutar la aplicacion "
                    + e.getMessage());

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}