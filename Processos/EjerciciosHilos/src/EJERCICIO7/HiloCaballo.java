package EJERCICIO7;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HiloCaballo extends Thread {

    private JProgressBar barra;
    private String nombreCaballo;
    private JLabel lblGanador;
    private static volatile boolean carreraTerminada = false;

    public HiloCaballo(JProgressBar barra, String caballo, JLabel ganador) {
        this.barra = barra;
        this.nombreCaballo = caballo;
        this.lblGanador = ganador;
    }

    public static void iniciarCarrera() {
        carreraTerminada = false;
    }

    @Override
    public void run() {
        while (barra.getValue() < 100 && !carreraTerminada) {
        	
            int avance = (int) (Math.random() * 5) + 1;
            
            int valorActualizado = Math.min(barra.getValue() + avance, 100);
            
            barra.setValue(valorActualizado);

            if (valorActualizado >= 100 && !carreraTerminada) {
                terminar();
            }

            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public synchronized void terminar() {
        if (!carreraTerminada) {
            carreraTerminada = true;
            lblGanador.setText("¡El ganador es: " + nombreCaballo + "!");
        }
    }
}
