package ejercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Ejer8 extends JFrame  implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldP1;
	private JTextField txtIpconfig;
	private JTextField txtPrueba;
	private JTextField textPID1;
	private JTextField textPID2;
	private JTextField textPID3;
	private JTextField textPIDPadre1;
	private JTextField textPIDPadre2;
	private JTextField textPIDPadre3;
	private JButton btnStartP2;
	private JButton btnStartP1;
	private JButton btnStartP3;
	private JTextArea Resultado2 ;
	private JTextArea Resultado1;
	private JScrollPane scrollPane;
	private String res="";
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
		setBounds(100, 100, 636, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldP1 = new JTextField();
		textFieldP1.setText("taskmgr");
		textFieldP1.setBounds(179, 37, 86, 20);
		contentPane.add(textFieldP1);
		textFieldP1.setColumns(10);
		
		txtIpconfig = new JTextField();
		txtIpconfig.setText("ipconfig");
		txtIpconfig.setColumns(10);
		txtIpconfig.setBounds(295, 37, 86, 20);
		contentPane.add(txtIpconfig);
		
		txtPrueba = new JTextField();
		txtPrueba.setText("Prueba");
		txtPrueba.setColumns(10);
		txtPrueba.setBounds(410, 37, 86, 20);
		contentPane.add(txtPrueba);
		
		btnStartP1 = new JButton("Start");
		btnStartP1.setBounds(179, 68, 89, 23);
		contentPane.add(btnStartP1);
		btnStartP1.addActionListener(this);
		
		btnStartP2 = new JButton("Start");
		btnStartP2.setBounds(292, 68, 89, 23);
		contentPane.add(btnStartP2);
		btnStartP2.addActionListener(this);
		
		 btnStartP3 = new JButton("Start");
		btnStartP3.setBounds(410, 68, 89, 23);
		contentPane.add(btnStartP3);
		btnStartP3.addActionListener(this);
		
		JLabel lblPID = new JLabel("PID");
		lblPID.setBounds(64, 114, 46, 14);
		contentPane.add(lblPID);
		
		JLabel lblPidPadre = new JLabel("PID Padre");
		lblPidPadre.setBounds(64, 139, 76, 14);
		contentPane.add(lblPidPadre);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(10, 171, 76, 14);
		contentPane.add(lblResultado);
		
		textPID1 = new JTextField();
		textPID1.setEnabled(false);
		textPID1.setBounds(179, 114, 86, 20);
		contentPane.add(textPID1);
		textPID1.setColumns(10);
		
		textPID2 = new JTextField();
		textPID2.setEnabled(false);
		textPID2.setColumns(10);
		textPID2.setBounds(295, 114, 86, 20);
		contentPane.add(textPID2);
		
		textPID3 = new JTextField();
		textPID3.setEnabled(false);
		textPID3.setColumns(10);
		textPID3.setBounds(410, 114, 155, 20);
		contentPane.add(textPID3);
		
		textPIDPadre1 = new JTextField();
		textPIDPadre1.setEnabled(false);
		textPIDPadre1.setColumns(10);
		textPIDPadre1.setBounds(179, 142, 86, 20);
		contentPane.add(textPIDPadre1);
		
		textPIDPadre2 = new JTextField();
		textPIDPadre2.setEnabled(false);
		textPIDPadre2.setColumns(10);
		textPIDPadre2.setBounds(295, 142, 86, 20);
		contentPane.add(textPIDPadre2);
		
		textPIDPadre3 = new JTextField();
		textPIDPadre3.setEnabled(false);
		textPIDPadre3.setColumns(10);
		textPIDPadre3.setBounds(410, 142, 155, 20);
		contentPane.add(textPIDPadre3);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(47, 193, 265, 230);
		 contentPane.add(scrollPane_1);
		
		 Resultado1 = new JTextArea();
		 scrollPane_1.setViewportView(Resultado1);
		 Resultado1.setEnabled(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(381, 192, 196, 219);
		contentPane.add(scrollPane);
		
		Resultado2 = new JTextArea();
		scrollPane.setViewportView(Resultado2);
		Resultado2.setEnabled(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();

		if (src == btnStartP1) {
			
			createProcesso1();

		}else if (src == btnStartP2) {
			createProcesso2();
			
		}else if (src == btnStartP3) {
			createProcesso3();
		}
	}

	private void createProcesso3() {
		try {
			res+=txtPrueba.getText().toString()+"\n";
			Resultado2.setText(res);

			textPID3.setText("");
			Resultado1.setText("");
			
			textPIDPadre3.setText(String.valueOf(ProcessHandle.current().pid()));
			
			String programa = txtPrueba.getText();
			StringBuilder pidsAcumulados = new StringBuilder();
			StringBuilder salidaTotal = new StringBuilder();
			
			for (int i = 0; i < 5; i++) {
				ProcessBuilder pb = new ProcessBuilder(programa + ".exe");
				Process p = pb.start();
				
				pidsAcumulados.append(p.pid()).append(" ");
				
				OutputStreamWriter escritor = new OutputStreamWriter(p.getOutputStream());
				escritor.write("Prueba\n");
				escritor.flush();
				escritor.close();
				
				BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String linea;
				while ((linea = lector.readLine()) != null) {
					salidaTotal.append(linea).append("\n");
				}
				lector.close();
				
				p.waitFor();
			}
			
			textPID3.setText(pidsAcumulados.toString().trim());
			Resultado1.setText(salidaTotal.toString());
			
		} catch (IOException | InterruptedException ex) {
			Resultado1.setText("Error en Proceso 3:\n" + ex.getMessage());
		}
	}

	private void createProcesso2() {
		try {
			Resultado1.setText("");
			String comando = txtIpconfig.getText();
			res+=comando.toString()+"\n";
			Resultado2.setText(res);
			
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", comando);
			Process p=pb.start();
			
			textPID2.setText(String.valueOf(p.pid()));
			textPIDPadre2.setText(String.valueOf(ProcessHandle.current().pid()));
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			StringBuilder salida = new StringBuilder();
			while ((linea = lector.readLine()) != null) {
				salida.append(linea).append("\n");
			}
			lector.close();
			
			Resultado1.setText(salida.toString());
		} catch (IOException ex) {
			Resultado1.setText("Error en CMD:\n" + ex.getMessage());
		}		
	}

	private void createProcesso1() {
		try {
			String programa = textFieldP1.getText();
			res+=programa.toString()+"\n";
			Resultado2.setText(res);
			ProcessBuilder pb = new ProcessBuilder(programa);
			Process p=pb.start();
			
			textPID1.setText(String.valueOf(p.pid()));
			
			textPIDPadre1.setText(String.valueOf(ProcessHandle.current().pid()));
			Resultado1.setText("Programa del sistema\niniciado correctamente.");
		} catch (IOException ex) {
			Resultado1.setText("Error al iniciar el programa:\n" + ex.getMessage());
		}		
	}
}
