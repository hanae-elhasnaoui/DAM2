package EJERCICIO5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
	JButton btnMenos1, btnFin1, btnMas1;
	JLabel lblContador1, lblPrioridad1;

	JButton btnMenos2, btnFin2, btnMas2;
	JLabel lblContador2, lblPrioridad2;

	JButton btnMenos3, btnFin3, btnMas3;
	JLabel lblContador3, lblPrioridad3;

	JButton btnFinalizarTodos;

	Thread t1, t2, t3;
	HiloContador h1, h2, h3;

	public Ventana() {
		setTitle("Ejercicio 5");
		setSize(400, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(7, 1, 5, 5));

		JPanel p1 = new JPanel();
		btnMenos1 = new JButton("--");
		btnFin1 = new JButton("Fin hilo 1");
		btnMas1 = new JButton("++");
		p1.add(btnMenos1);
		p1.add(btnFin1);
		p1.add(btnMas1);
		getContentPane().add(p1);

		JPanel p2 = new JPanel();
		btnMenos2 = new JButton("--");
		btnFin2 = new JButton("Fin hilo 2");
		btnMas2 = new JButton("++");
		p2.add(btnMenos2);
		p2.add(btnFin2);
		p2.add(btnMas2);
		getContentPane().add(p2);

		JPanel p3 = new JPanel();
		btnMenos3 = new JButton("--");
		btnFin3 = new JButton("Fin hilo 3");
		btnMas3 = new JButton("++");
		p3.add(btnMenos3);
		p3.add(btnFin3);
		p3.add(btnMas3);
		getContentPane().add(p3);

		JPanel p4 = new JPanel();
		btnFinalizarTodos = new JButton("Finalizar todos");
		p4.add(btnFinalizarTodos);
		getContentPane().add(p4);

		lblContador1 = new JLabel("Hilo 1: 0", SwingConstants.CENTER);
		lblPrioridad1 = new JLabel("Pri: 0", SwingConstants.CENTER);
		lblContador2 = new JLabel("Hilo 2: 0", SwingConstants.CENTER);
		lblPrioridad2 = new JLabel("Pri: 0", SwingConstants.CENTER);
		lblContador3 = new JLabel("Hilo 3: 0", SwingConstants.CENTER);
		lblPrioridad3 = new JLabel("Pri: 0", SwingConstants.CENTER);

		lblContador1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		lblPrioridad1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		lblContador2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		lblPrioridad2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		lblContador3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		lblPrioridad3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		JPanel p5 = new JPanel(new GridLayout(1, 2));
		p5.add(lblContador1);
		p5.add(lblPrioridad1);
		getContentPane().add(p5);

		JPanel p6 = new JPanel(new GridLayout(1, 2));
		p6.add(lblContador2);
		p6.add(lblPrioridad2);
		getContentPane().add(p6);

		JPanel p7 = new JPanel(new GridLayout(1, 2));
		p7.add(lblContador3);
		p7.add(lblPrioridad3);
		getContentPane().add(p7);
		
		
		h1 = new HiloContador("Hilo 1", lblContador1);
		t1 = new Thread(h1);
		t1.start();

		h2 = new HiloContador("Hilo 2", lblContador2);
		t2 = new Thread(h2);
		t2.start();

		h3 = new HiloContador("Hilo 3", lblContador3);
		t3 = new Thread(h3);
		t3.start();
		
		
		btnMenos1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t1 != null) {
					t1.setPriority(Thread.MIN_PRIORITY);
					lblPrioridad1.setText("Pri: " + t1.getPriority());
				}
			}
		});

		btnMas1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t1 != null) {
					t1.setPriority(Thread.MAX_PRIORITY);
					lblPrioridad1.setText("Pri: " + t1.getPriority());
				}
			}
		});

		btnFin1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t1 != null) {
					t1.interrupt();
					btnFin1.setEnabled(false);

				}
			}
		});

		btnMenos2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t2 != null) {
					t2.setPriority(Thread.MIN_PRIORITY);
					lblPrioridad2.setText("Pri: " + t2.getPriority());
				}
			}
		});

		btnMas2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t2 != null) {
					t2.setPriority(Thread.MAX_PRIORITY);
					lblPrioridad2.setText("Pri: " + t2.getPriority());
				}
			}
		});

		btnFin2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t2 != null) {
					t2.interrupt(); 
					btnFin2.setEnabled(false);
				}
			}
		});

		btnMenos3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t3 != null) {
					t3.setPriority(Thread.MIN_PRIORITY);
					lblPrioridad3.setText("Pri: " + t3.getPriority());
				}
			}
		});

		btnMas3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t3 != null) {
					t3.setPriority(Thread.MAX_PRIORITY);
					lblPrioridad3.setText("Pri: " + t3.getPriority());
				}
			}
		});
		
		btnFin3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t3 != null) {
					t3.interrupt(); 
					btnFin3.setEnabled(false);
				}
			}
		});

		btnFinalizarTodos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (t1 != null) {
					t1.interrupt();
				}
				if (t2 != null) {
					t2.interrupt();
				}
				if (t3 != null) {
					t3.interrupt();
				}
				btnFinalizarTodos.setEnabled(false);
			}
		});

	}

	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
		
	}
}
