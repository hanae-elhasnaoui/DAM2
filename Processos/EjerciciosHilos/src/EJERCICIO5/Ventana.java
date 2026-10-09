package EJERCICIO5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHilo1 = new JButton("Fin hilo 1");
		btnHilo1.setBounds(197, 83, 89, 23);
		contentPane.add(btnHilo1);
		
		JButton btnHilo3 = new JButton("Fin hilo 3");
		btnHilo3.setBounds(197, 151, 89, 23);
		contentPane.add(btnHilo3);
		
		JButton btnHilo2 = new JButton("Fin hilo 2");
		btnHilo2.setBounds(197, 117, 89, 23);
		contentPane.add(btnHilo2);
		
		JButton btnH1min = new JButton("--");
		btnH1min.setBounds(117, 83, 53, 23);
		contentPane.add(btnH1min);
		
		JButton btnH2min = new JButton("--");
		btnH2min.setBounds(117, 117, 53, 23);
		contentPane.add(btnH2min);
		
		JButton btnH3min = new JButton("--");
		btnH3min.setBounds(117, 151, 53, 23);
		contentPane.add(btnH3min);
		
		JButton btnH1max = new JButton("++");
		btnH1max.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnH1max.setBounds(314, 83, 53, 23);
		contentPane.add(btnH1max);
		
		JButton btnH2max = new JButton("++");
		btnH2max.setBounds(314, 117, 53, 23);
		contentPane.add(btnH2max);
		
		JButton btnH3max = new JButton("++");
		btnH3max.setBounds(314, 151, 53, 23);
		contentPane.add(btnH3max);
		
		JButton btnFintodos = new JButton("Finalizar todos");
		btnFintodos.setBounds(181, 203, 134, 23);
		contentPane.add(btnFintodos);
		
		JLabel lblH1 = new JLabel("hilo 1:0");
		lblH1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblH1.setBounds(106, 276, 76, 23);
		contentPane.add(lblH1);
		
		JLabel lblH2 = new JLabel("hilo 2:0");
		lblH2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblH2.setBounds(106, 314, 76, 23);
		contentPane.add(lblH2);
		
		JLabel lblHilo3 = new JLabel("hilo 3:0");
		lblHilo3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHilo3.setBounds(106, 347, 76, 23);
		contentPane.add(lblHilo3);

	}
}
