package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.GestionDeMensajes;
import Pojo.Mensaje;

public class ImprimirMensajes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabla;
	private static DefaultTableModel modeloTabla;

	/**
	 * Create the panel.
	 */
	public ImprimirMensajes() {
		String[] columnas = {
	            "De",
	            "Para",
	            "Fecha",
	            "Hora",
	            "Asunto",
	            "Contenido"
	        };
		modeloTabla=new DefaultTableModel(columnas,0);
		tabla = new JTable(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(tabla);

		add(scrollPane, BorderLayout.CENTER);
		IllenarTabla();
		
	}

	public static void IllenarTabla() {
		
		ArrayList<Mensaje> listaMensajes=GestionDeMensajes.getMessages();
		
		for(Mensaje m: listaMensajes) {
			
			String de = m.getDe().replace("De:", "").trim();
			String para = m.getPara().replace("Para:", "").trim();
			String fecha = m.getFecha().replace("Fecha:", "").trim();
			String hora = m.getHora().replace("Hora:", "").trim();
			String asunto = m.getAsunto().replace("Asunto:", "").trim();
			String contenido = m.getContenido().replace("Contenido:", "").trim();
			System.out.println("imp");
			System.out.printf( de, para, fecha, hora, asunto, contenido);
			Object[] fila = { de, para, fecha, hora, asunto, contenido };
			modeloTabla.addRow(fila);
			
		}
		
	}
	

}

