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
		
		refreshTable(Archivos.datos);
		
		tblJugadores = new JTable(modeloJugadores);
		tblJugadores.setFillsViewportHeight(true);
		scrollTblJugadores.setViewportView(tblJugadores);
		modeloJugadores = new DefaultTableModel();
		modeloJugadores.addColumn("Nombre Jugador");
		modeloJugadores.addColumn("Tiempo");
		modeloJugadores.addColumn("Movimientos");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public static void refreshTable(ArrayList<Jugador> listadoJugadores) {
		if (listadoJugadores.isEmpty()) return;
		// Cargar modelo de jugadores
		for (int i = 0; i < modeloJugadores.getRowCount(); i++) {
			modeloJugadores.removeRow(i);
			i -= 1;
		}
		Object[] arreglo = new String[3];

		for (Jugador j : listadoJugadores) {
			arreglo[0] = j.nombre;
			arreglo[1] = j.tiempo;
			arreglo[2] = j.movimientos;
			modeloJugadores.addRow(arreglo);
		}
		
	}
}
