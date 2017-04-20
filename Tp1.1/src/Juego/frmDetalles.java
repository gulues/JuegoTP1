package Juego;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmDetalles extends JDialog {
	private JTable tblJugadores;
	public static DefaultTableModel modeloJugadores;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public frmDetalles() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		JScrollPane scrollTblJugadores = new JScrollPane();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		
		modeloJugadores = new DefaultTableModel();
		modeloJugadores.addColumn("Nombre Jugador");
		modeloJugadores.addColumn("Tiempo");
		modeloJugadores.addColumn("Movimientos");
		tblJugadores = new JTable(modeloJugadores);
		tblJugadores.setFillsViewportHeight(true);
		scrollTblJugadores.setViewportView(tblJugadores);
		ArrayList<Jugador>lista= new ArrayList<Jugador>();
		archivos ar = new archivos();
		ar.abrir();
		lista= archivos.datos;
		refreshTable(lista);
		getContentPane().add(scrollTblJugadores);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
					dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	public static void refreshTable(ArrayList<Jugador> listadoJugadores) {
		if (listadoJugadores.isEmpty())
			return;
		// Cargar modelo de jugadores
		for (int i = 0; i < modeloJugadores.getRowCount(); i++) {
			modeloJugadores.removeRow(i);
			i -= 1;
		}
		Object[] arreglo = new String[3];

		for (Jugador j : listadoJugadores) {
			arreglo[0] = j.nombre;
			arreglo[1] = j.tiempo;
			arreglo[2] = j.movimientos +"";
			modeloJugadores.addRow(arreglo);
		}

	}
}
