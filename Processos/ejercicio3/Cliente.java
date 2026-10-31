package ejercicio3;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblFoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblFoto = new JLabel("");
		lblFoto.setBounds(104, 27, 242, 176);
		contentPane.add(lblFoto);

		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				ricibirFoto();

			}
		});
		hilo.start();
	}

	public void ricibirFoto() {

		boolean recibido = false;

		try (Socket cliente = new Socket("localhost", 7000);
				DataInputStream entrada = new DataInputStream(cliente.getInputStream());
				FileOutputStream archivo = new FileOutputStream("copia.jpg")) {

			long pendientes = entrada.readLong();

			byte[] buffer = new byte[4096];

			while (pendientes > 0) {

				int cantidad = (int) Math.min(buffer.length, pendientes);
				int leidos = entrada.read(buffer, 0, cantidad);

				if (leidos == -1) {
					throw new IOException("Imagen incompleta");
				}

				archivo.write(buffer, 0, leidos);
				pendientes -= leidos;
			}

			recibido = true;

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		if (recibido) {
			mostrarFoto("copia.jpg");
		} else {
			mostrarFoto("src/ejercicio3/NoDisponible.jpg");
		}
	}

	public void mostrarFoto(String ruta) {

		SwingUtilities.invokeLater(() -> {

			ImageIcon imagen = new ImageIcon(ruta);
			java.awt.Image ajustada = imagen.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
					java.awt.Image.SCALE_SMOOTH);

			lblFoto.setIcon(new ImageIcon(ajustada));
		});
	}
}
