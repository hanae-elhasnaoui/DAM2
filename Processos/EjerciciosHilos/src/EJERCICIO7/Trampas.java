package EJERCICIO7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Trampas extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldCaballo1;
	private JTextField textFieldCaballo2;
	private JTextField textFieldCaballo3;
	private JTextField textFieldCaballo4;

	public static void main(String[] args) {

				Trampas frame = new Trampas();
				frame.setVisible(true);
			
		
	}

	public Trampas() {

		setTitle("Trampas - Prioridades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCab1 = new JLabel("Caballo 1");
		lblCab1.setBounds(79, 42, 80, 20);
		contentPane.add(lblCab1);

		textFieldCaballo1 = new JTextField();
		textFieldCaballo1.setText("6");
		textFieldCaballo1.setBounds(219, 42, 96, 20);
		contentPane.add(textFieldCaballo1);

		JLabel lblCaballo2 = new JLabel("Caballo 2");
		lblCaballo2.setBounds(79, 94, 80, 20);
		contentPane.add(lblCaballo2);

		textFieldCaballo2 = new JTextField();
		textFieldCaballo2.setText("6");
		textFieldCaballo2.setBounds(219, 94, 96, 20);
		contentPane.add(textFieldCaballo2);

		JLabel lblCaballo3 = new JLabel("Caballo 3");
		lblCaballo3.setBounds(79, 141, 80, 20);
		contentPane.add(lblCaballo3);

		textFieldCaballo3 = new JTextField();
		textFieldCaballo3.setText("6");
		textFieldCaballo3.setBounds(219, 141, 96, 20);
		contentPane.add(textFieldCaballo3);

		// CABALLO 4
		JLabel lblCaballo4 = new JLabel("Caballo 4");
		lblCaballo4.setBounds(79, 194, 80, 20);
		contentPane.add(lblCaballo4);

		textFieldCaballo4 = new JTextField();
		textFieldCaballo4.setText("6");
		textFieldCaballo4.setBounds(219, 194, 96, 20);
		contentPane.add(textFieldCaballo4);

		// BOTÓN GUARDAR
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(342, 233, 84, 20);
		contentPane.add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					
					int p1 = getPrioridad1();
					int p2 = getPrioridad2();
					int p3 = getPrioridad3();
					int p4 = getPrioridad4();

					if (p1 >= 1 && p1 <= 10 && p2 >= 1 && p2 <= 10 && p3 >= 1 && p3 <= 10 && p4 >= 1 && p4 <= 10) {

						Carrera carrera = new Carrera(Trampas.this);
						carrera.setVisible(true);

						dispose();

					} else {
						JOptionPane.showMessageDialog(Trampas.this, "Las prioridades deben estar entre 1 y 10");
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(Trampas.this, "Introduce números válidos");
				}
			}
		});
	}

	public int getPrioridad1() {
		return Integer.parseInt(textFieldCaballo1.getText().trim());
	}

	public int getPrioridad2() {
		return Integer.parseInt(textFieldCaballo2.getText().trim());
	}

	public int getPrioridad3() {
		return Integer.parseInt(textFieldCaballo3.getText().trim());
	}

	public int getPrioridad4() {
		return Integer.parseInt(textFieldCaballo4.getText().trim());
	}
}