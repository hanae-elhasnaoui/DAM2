package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Pojo.Mensaje;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class app extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btncargar;
	private JButton btnAnadir;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JButton btnImprimirMensajes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app frame = new app();
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
	public app() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btncargar = new JButton("Cargar mensajes");
		btncargar.setBounds(48, 85, 140, 23);
		contentPane.add(btncargar);
		btncargar.addActionListener((ActionListener) this);

		btnAnadir = new JButton("Añadir mensajes");
		btnAnadir.setBounds(48, 144, 140, 23);
		contentPane.add(btnAnadir);
		btnAnadir.addActionListener((ActionListener) this);

		btnGuardar = new JButton("Guardar mensajes");
		btnGuardar.setBounds(229, 85, 140, 23);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener((ActionListener) this);

		btnImprimirMensajes = new JButton("Imprimir mensajes");
		btnImprimirMensajes.setBounds(229, 144, 140, 23);
		contentPane.add(btnImprimirMensajes);
		btnImprimirMensajes.addActionListener((ActionListener) this);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(304, 211, 95, 23);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();

		if (src == btncargar) {

			Modelo.GestionDeMensajes.leerFechero();

			int i = Modelo.GestionDeMensajes.CuantasMensajes();

			JOptionPane.showMessageDialog(this, "Se han cargado en memoria " + i + " Mensajes", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);

		} else if (src == btnAnadir) {

			
			  Anadir anadir = new Anadir(this);

			    this.setContentPane(anadir);
			    this.revalidate();
			    this.repaint();
			

		} else if (src == btnGuardar) {

			Modelo.GestionDeMensajes.WriteFechero();

			JOptionPane.showMessageDialog(this,
					"Los mensajes en memoria ,han sido guardados en el fichero mensajes.txt", "Mensaje",
					JOptionPane.INFORMATION_MESSAGE);

		} else if (src == btnImprimirMensajes) {
			ImprimirMensajes imprimir = new ImprimirMensajes();

		    this.setContentPane(imprimir);
		    this.revalidate();
		    this.repaint();
			

		} else if (src == btnSalir) {

		}

	}

	public void volverAlInicio() {
		setContentPane(contentPane);
	    revalidate();
	    repaint();		
	}

}
