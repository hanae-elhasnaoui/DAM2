package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Pojo.Partido;
import modelo.GestionPartidos;

public class App extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEqLocal;
	private JTextField textVisite;
	private JTextField textgolesLocal;
	private JTextField textGolesVisitante;
	private JTextField textlugar;
	private JTextField textFecha;
	private JTable table;

	private JButton btnAnadir;
	private JButton btnCargar;
	private JButton btnGuardar;
	private static DefaultTableModel modeloTabla;
	private static ArrayList<Partido> partidos = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEqLocal = new JLabel("Equipo local");
		lblEqLocal.setBounds(25, 42, 97, 14);
		contentPane.add(lblEqLocal);

		JLabel lblEqVis = new JLabel("Equipo visitante");
		lblEqVis.setBounds(25, 69, 97, 14);
		contentPane.add(lblEqVis);

		JLabel lblGolesLocal = new JLabel("Goles local");
		lblGolesLocal.setBounds(25, 94, 97, 14);
		contentPane.add(lblGolesLocal);

		JLabel lblGolesVisitante = new JLabel("Goles visitante");
		lblGolesVisitante.setBounds(25, 127, 97, 14);
		contentPane.add(lblGolesVisitante);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(25, 155, 97, 14);
		contentPane.add(lblLugar);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(25, 185, 97, 14);
		contentPane.add(lblFecha);

		textEqLocal = new JTextField();
		textEqLocal.setBounds(132, 39, 211, 20);
		contentPane.add(textEqLocal);
		textEqLocal.setColumns(10);

		textVisite = new JTextField();
		textVisite.setColumns(10);
		textVisite.setBounds(132, 66, 211, 20);
		contentPane.add(textVisite);

		textgolesLocal = new JTextField();
		textgolesLocal.setColumns(10);
		textgolesLocal.setBounds(132, 91, 211, 20);
		contentPane.add(textgolesLocal);

		textGolesVisitante = new JTextField();
		textGolesVisitante.setColumns(10);
		textGolesVisitante.setBounds(132, 124, 211, 20);
		contentPane.add(textGolesVisitante);

		textlugar = new JTextField();
		textlugar.setColumns(10);
		textlugar.setBounds(132, 152, 211, 20);
		contentPane.add(textlugar);

		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(132, 182, 211, 20);
		contentPane.add(textFecha);

		btnAnadir = new JButton("Anadir");
		btnAnadir.setBounds(33, 246, 89, 23);
		contentPane.add(btnAnadir);
		btnAnadir.addActionListener(this);

		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(143, 246, 89, 23);
		contentPane.add(btnCargar);
		btnCargar.addActionListener(this);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(254, 246, 89, 23);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener(this);

		String[] columnas = { "Equipo Local", "Equipo Visitante", "Goles Local", "Goles Visitante", "Lugar", "Fecha" };
		modeloTabla = new DefaultTableModel(columnas, 0);
		table = new JTable(modeloTabla);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(25, 299, 367, 91);
		contentPane.add(scrollPane);

	}

	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();

		if (src == btnCargar) {

			llenarTabla();

		} else if (src == btnAnadir) {

			validarDatos();

		} else if (src == btnGuardar) {

			GuardarPartidos();

		}
	}

	private void GuardarPartidos() {
		boolean test = modelo.GestionPartidos.guardarPartidos();

		if (test) {
			javax.swing.JOptionPane.showMessageDialog(null, "Los partidos se han guardado correctamente",
					"Guardado completo", javax.swing.JOptionPane.INFORMATION_MESSAGE);
		} else {
			javax.swing.JOptionPane.showMessageDialog(null, "Hubo un error al intentar escribir en el archivo.",
					"Error de Guardado", javax.swing.JOptionPane.ERROR_MESSAGE);
		}
	}

	private void validarDatos() {
		String equipoLocal = textEqLocal.getText().trim();
		String equipoVisitante = textVisite.getText().trim();
		String golesLocal = textgolesLocal.getText().trim();
		String golesVisitante = textGolesVisitante.getText().trim();
		String lugar = textlugar.getText().trim();
		String fecha = textFecha.getText().trim();

		String regixEq = "[a-zA-Z0-9]{1,20}";
		String regixGol = "[0-9]{1,2}";
		String regixFecha = "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{2}";
		boolean correcto = true;
		String message = "";

		if (!equipoLocal.matches(regixEq)) {
		    correcto = false;
		    message = "El equipo local debe tener entre 1 y 20 caracteres y solo puede contener letras y números.";

		} else if (!equipoVisitante.matches(regixEq)) {
		    correcto = false;
		    message = "El equipo visitante debe tener entre 1 y 20 caracteres y solo puede contener letras y números.";

		} else if (!golesLocal.matches(regixGol)) {
		    correcto = false;
		    message = "Los goles locales deben ser un número de 1 o 2 dígitos.";

		} else if (!golesVisitante.matches(regixGol)) {
		    correcto = false;
		    message = "Los goles visitantes deben ser un número de 1 o 2 dígitos.";

		} else if (!lugar.matches(regixEq)) {
		    correcto = false;
		    message = "El lugar debe tener entre 1 y 20 caracteres y solo puede contener letras y números.";

		} else if (!fecha.matches(regixFecha)) {
		    correcto = false;
		    message = "La fecha debe tener el formato dd/MM/yy.";
		}
		if (correcto) {
			Partido partido = new Partido(equipoLocal, equipoVisitante, golesLocal, golesVisitante, lugar, fecha);

			GestionPartidos.getPartidos().add(partido);

			Object[] fila = { partido.getEquipoLocal(), partido.getEquipoVisitante(), partido.getGolesLocal(),
					partido.getGolesVisitante(), partido.getLugar(), partido.getFecha() };

			modeloTabla.addRow(fila);

			textEqLocal.setText("");
			textVisite.setText("");
			textgolesLocal.setText("");
			textGolesVisitante.setText("");
			textlugar.setText("");
			textFecha.setText("");

			JOptionPane.showMessageDialog(this, "Partido añadido correctamente.", "Añadir",
					JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, message, "Error",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private void llenarTabla() {

		partidos = GestionPartidos.cargarPartidos();
		modeloTabla.setRowCount(0);

		for (Partido p : partidos) {
			Object[] fila = { p.getEquipoLocal(), p.getEquipoVisitante(), p.getGolesLocal(), p.getGolesVisitante(),
					p.getLugar(), p.getFecha() };
			modeloTabla.addRow(fila);
		}
		JOptionPane.showMessageDialog(this, "Se han cargado en memoria ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

	}

}
