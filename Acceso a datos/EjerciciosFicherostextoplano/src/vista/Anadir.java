package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Anadir extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static JTextField textFecha;
	private static JTextField textPara;
	private static JTextField textDe;
	private static JTextField textAsunto;
	private static JComboBox<Integer> comboDia;
	private static JComboBox<String> comboMes;
	private static JComboBox<Integer> comboMinutos;
	private static JComboBox<String> comboHora;
	private static JButton btnOK;
	private static JButton btnCancel;
	private static JTextArea textArea;
	
	private app ventanaPrincipal;

	/**
	 * Create the panel.
	 */
	public Anadir(app ventanaPrincipal)  {
	    this.ventanaPrincipal = ventanaPrincipal;

		setLayout(null);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(29, 32, 46, 14);
		add(lblFecha);

		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(29, 63, 46, 14);
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

		textFecha = new JTextField();
		textFecha.setBounds(129, 29, 62, 20);
		add(textFecha);
		textFecha.setColumns(10);

		textPara = new JTextField();
		textPara.setBounds(125, 131, 258, 20);
		add(textPara);
		textPara.setColumns(10);

		textDe = new JTextField();
		textDe.setColumns(10);
		textDe.setBounds(125, 96, 258, 20);
		add(textDe);

		textAsunto = new JTextField();
		textAsunto.setColumns(10);
		textAsunto.setBounds(125, 156, 258, 20);
		add(textAsunto);

		String[] mes = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		Integer[] day = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, 31 };

		comboMes = new JComboBox<>(mes);
		comboMes.setToolTipText("");
		comboMes.setEditable(true);
		comboMes.setBounds(201, 28, 96, 22);
		add(comboMes);

		comboDia = new JComboBox<>(day);
		comboDia.setBounds(307, 27, 76, 22);
		add(comboDia);
		Integer[] minutos = { 00, 05, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 };
		String[] hora = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23" };
		comboHora = new JComboBox<>(hora);
		comboHora.setBounds(129, 59, 51, 22);
		add(comboHora);

		comboMinutos = new JComboBox<>(minutos);
		comboMinutos.setBounds(201, 59, 51, 22);
		add(comboMinutos);

		textArea = new JTextArea();
		textArea.setBounds(129, 184, 254, 83);
		add(textArea);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(295, 292, 88, 22);
		add(btnCancel);
		btnCancel.addActionListener(this);

		btnOK = new JButton("OK");
		btnOK.setBounds(227, 292, 62, 22);
		add(btnOK);
		btnOK.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();

		if (src == btnOK) {

			 String asunto=textAsunto.getText();
			 String dia=comboDia.getSelectedItem().toString();
			 String txthora= comboHora.getSelectedItem().toString();
			 String mes=comboMes.getSelectedItem().toString();
			 String min=comboMinutos.getSelectedItem().toString();
			 String de=textDe.getText();
			 String txtfecha=textFecha.getText();;
			 String para=textPara.getText();
			 String contenido=textArea.getText();;
			 
			 String fecha=txtfecha+"-"+mes+"-"+dia;
			 String hora=txthora+":"+min;

			if (fecha.isEmpty()) {
				javax.swing.JOptionPane.showMessageDialog(this, "El campo Fecha es obligatorio");
				textFecha.requestFocus();
			}

			if (para.isEmpty()) {
				javax.swing.JOptionPane.showMessageDialog(this, "El campo Para es obligatorio");
				textPara.requestFocus();
			}

			if (de.isEmpty()) {
				javax.swing.JOptionPane.showMessageDialog(this, "El campo De es obligatorio");
				textDe.requestFocus();
			}

			if (asunto.isEmpty()) {
				javax.swing.JOptionPane.showMessageDialog(this, "El campo Asunto es obligatorio");
				textAsunto.requestFocus();
			}

			if (contenido.isEmpty()) {
				javax.swing.JOptionPane.showMessageDialog(this, "El campo Contenido es obligatorio");
				textArea.requestFocus();
			}

			Modelo.GestionDeMensajes.AddMessag(fecha,hora,de,para,asunto,contenido);

		} else if (src == btnCancel) {
			
			ventanaPrincipal.volverAlInicio();
			
		}
	}


}
