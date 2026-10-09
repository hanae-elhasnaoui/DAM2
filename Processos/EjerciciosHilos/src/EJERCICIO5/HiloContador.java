package EJERCICIO5;

import javax.swing.*;

public class HiloContador implements Runnable {
    private int contador = 0;
    private final JLabel lblContador;
    private final String nombre;

    public HiloContador(String nombre, JLabel lblContador) {
        this.nombre = nombre;
        this.lblContador = lblContador;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000); 
                contador++;
                
                lblContador.setText(nombre + ": " + contador);
                
            } catch (InterruptedException e) {
              System.out.println(e.getMessage()); 
            }
        }
    }
}
