package EJERCICIO7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Carrera extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Trampas ventanaTrampas;

    public Carrera(Trampas trampas) {
        this.ventanaTrampas = trampas;

        setTitle("Carrera de Caballos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JProgressBar bar1 = new JProgressBar(0, 100);
        bar1.setBounds(40, 40, 400, 25);
        bar1.setStringPainted(true);
        contentPane.add(bar1);

        JProgressBar bar2 = new JProgressBar(0, 100);
        bar2.setBounds(40, 90, 400, 25);
        bar2.setStringPainted(true);
        contentPane.add(bar2);

        JProgressBar bar3 = new JProgressBar(0, 100);
        bar3.setBounds(40, 140, 400, 25);
        bar3.setStringPainted(true);
        contentPane.add(bar3);

        JProgressBar bar4 = new JProgressBar(0, 100);
        bar4.setBounds(40, 190, 400, 25);
        bar4.setStringPainted(true);
        contentPane.add(bar4);

        JLabel lblGanador = new JLabel("Esperando inicio de la carrera...");
        lblGanador.setBounds(40, 240, 300, 20);
        contentPane.add(lblGanador);

        JButton btnEmpezar = new JButton("Empieza la carrera");
        btnEmpezar.setBounds(160, 290, 160, 30);
        contentPane.add(btnEmpezar);

        btnEmpezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bar1.setValue(0);
                bar2.setValue(0);
                bar3.setValue(0);
                bar4.setValue(0);
                
                lblGanador.setText("¡En carrera!");
                HiloCaballo.iniciarCarrera();

                HiloCaballo h1 = new HiloCaballo(bar1, "Caballo 1", lblGanador);
                HiloCaballo h2 = new HiloCaballo(bar2, "Caballo 2", lblGanador);
                HiloCaballo h3 = new HiloCaballo(bar3, "Caballo 3", lblGanador);
                HiloCaballo h4 = new HiloCaballo(bar4, "Caballo 4", lblGanador);

                h1.setPriority(ventanaTrampas.getPrioridad1());
                h2.setPriority(ventanaTrampas.getPrioridad2());
                h3.setPriority(ventanaTrampas.getPrioridad3());
                h4.setPriority(ventanaTrampas.getPrioridad4());

                h1.start();
                h2.start();
                h3.start();
                h4.start();
            }
        });
    }
}
