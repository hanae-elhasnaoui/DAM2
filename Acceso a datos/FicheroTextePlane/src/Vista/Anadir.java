package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Anadir extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Anadir() {
		setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(29, 28, 46, 14);
		add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(29, 74, 46, 14);
		add(lblHora);
		
		JLabel lblDe = new JLabel("De");
		lblDe.setBounds(29, 99, 46, 14);
		add(lblDe);
		
		
		JLabel lblPara = new JLabel("Para");
		lblPara.setBounds(29, 134, 46, 14);
		add(lblPara);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(29, 159, 46, 14);
		add(lblAsunto);
		
		JLabel lblContenido = new JLabel("Contenido");
		lblContenido.setBounds(29, 184, 76, 14);
		add(lblContenido);
		
		textField = new JTextField();
		textField.setBounds(92, 28, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 131, 258, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 96, 258, 20);
		add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(125, 156, 258, 20);
		add(textField_3);

	}
}
