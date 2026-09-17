package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEqLocal;
	private JTextField textVisite;
	private JTextField textgolesLocal;
	private JTextField textGolesVisitante;
	private JTextField textlugar;
	private JTextField textFecha;
	private JTable table;

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
		
		JButton btnNewButton = new JButton("Anadir");
		btnNewButton.setBounds(33, 246, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(143, 246, 89, 23);
		contentPane.add(btnCargar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(254, 246, 89, 23);
		contentPane.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(25, 299, 367, 91);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Equipo local", "Equipo visitante", "Goles vlocal", "Goles visitante", "lugar", "Fecha"
			}
		));
		scrollPane.setRowHeaderView(table);

	}
}
