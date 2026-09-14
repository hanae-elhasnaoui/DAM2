package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class app extends JFrame {

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btncargar = new JButton("Cargar mensajes");
		btncargar.setBounds(48, 59, 140, 23);
		contentPane.add(btncargar);
		btncargar.addActionListener((ActionListener) this);
		
		btnAnadir = new JButton("Añadir mensajes");
		btnAnadir.setBounds(48, 118, 140, 23);
		contentPane.add(btnAnadir);
		btnAnadir.addActionListener((ActionListener) this);
		
		btnGuardar = new JButton("Guardar mensajes");
		btnGuardar.setBounds(229, 59, 140, 23);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener((ActionListener) this);
		
		btnImprimirMensajes = new JButton("Imprimir mensajes");
		btnImprimirMensajes.setBounds(229, 118, 140, 23);
		contentPane.add(btnImprimirMensajes);
		btnImprimirMensajes.addActionListener((ActionListener) this);
		
		 btnSalir = new JButton("Salir");
		btnSalir.setBounds(304, 211, 95, 23);
		contentPane.add(btnSalir);
		btnSalir.addActionListener((ActionListener) this);

	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		Object src=e.getSource();
		
		if(src==btncargar) {
			
		}else if(src==btnAnadir){
			
		}else if(src==btnGuardar) {
			
		}else if(src==btnImprimirMensajes) {
			
		}else if(src==btnSalir) {
			
		}
	}
	
}
