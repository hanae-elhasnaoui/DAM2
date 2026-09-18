package ejercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Ejer8 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldP1;
	private JTextField textField_P2;
	private JTextField textField_P3;
	private JTextField textPID1;
	private JTextField textPID2;
	private JTextField textPID3;
	private JTextField textPIDPadre1;
	private JTextField textPIDPadre2;
	private JTextField textPIDPadre3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer8 frame = new Ejer8();
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
	public Ejer8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldP1 = new JTextField();
		textFieldP1.setBounds(83, 38, 86, 20);
		contentPane.add(textFieldP1);
		textFieldP1.setColumns(10);
		
		textField_P2 = new JTextField();
		textField_P2.setColumns(10);
		textField_P2.setBounds(199, 38, 86, 20);
		contentPane.add(textField_P2);
		
		textField_P3 = new JTextField();
		textField_P3.setColumns(10);
		textField_P3.setBounds(314, 38, 86, 20);
		contentPane.add(textField_P3);
		
		JButton btnStartP1 = new JButton("Start");
		btnStartP1.setBounds(83, 69, 89, 23);
		contentPane.add(btnStartP1);
		
		JButton btnStartP2 = new JButton("Start");
		btnStartP2.setBounds(196, 69, 89, 23);
		contentPane.add(btnStartP2);
		
		JButton btnStartP3 = new JButton("Start");
		btnStartP3.setBounds(314, 69, 89, 23);
		contentPane.add(btnStartP3);
		
		JLabel lblPID = new JLabel("PID");
		lblPID.setBounds(10, 118, 46, 14);
		contentPane.add(lblPID);
		
		JLabel lblPidPadre = new JLabel("PID Padre");
		lblPidPadre.setBounds(10, 143, 76, 14);
		contentPane.add(lblPidPadre);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(10, 171, 76, 14);
		contentPane.add(lblResultado);
		
		textPID1 = new JTextField();
		textPID1.setEnabled(false);
		textPID1.setBounds(83, 115, 86, 20);
		contentPane.add(textPID1);
		textPID1.setColumns(10);
		
		textPID2 = new JTextField();
		textPID2.setEnabled(false);
		textPID2.setColumns(10);
		textPID2.setBounds(199, 115, 86, 20);
		contentPane.add(textPID2);
		
		textPID3 = new JTextField();
		textPID3.setEnabled(false);
		textPID3.setColumns(10);
		textPID3.setBounds(314, 115, 86, 20);
		contentPane.add(textPID3);
		
		textPIDPadre1 = new JTextField();
		textPIDPadre1.setEnabled(false);
		textPIDPadre1.setColumns(10);
		textPIDPadre1.setBounds(83, 143, 86, 20);
		contentPane.add(textPIDPadre1);
		
		textPIDPadre2 = new JTextField();
		textPIDPadre2.setEnabled(false);
		textPIDPadre2.setColumns(10);
		textPIDPadre2.setBounds(199, 143, 86, 20);
		contentPane.add(textPIDPadre2);
		
		textPIDPadre3 = new JTextField();
		textPIDPadre3.setEnabled(false);
		textPIDPadre3.setColumns(10);
		textPIDPadre3.setBounds(314, 143, 86, 20);
		contentPane.add(textPIDPadre3);
		
		JTextArea Resultado2 = new JTextArea();
		Resultado2.setEnabled(false);
		Resultado2.setBounds(267, 181, 132, 230);
		contentPane.add(Resultado2);
		
		JTextArea Resultado1 = new JTextArea();
		Resultado1.setEnabled(false);
		Resultado1.setBounds(93, 181, 164, 230);
		contentPane.add(Resultado1);

	}
}
