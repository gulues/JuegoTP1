package Juego;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmMain {
	private int[][] Matriz;
	private int movimientos = 1;
	private JLabel lblMovimientos;
	private JLabel[] cuadro = new JLabel[16];
	public JFrame frmRompeCabezas;
	private Tablero tbl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frmMain window = new frmMain();
					window.frmRompeCabezas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmMain() {
		initialize();
	}

	private void initialize() {

		frmRompeCabezas = new JFrame();
		frmRompeCabezas.setBounds(100, 100, 491, 544);
		frmRompeCabezas.setLocationRelativeTo(null);
		frmRompeCabezas.setTitle("Rompe Cabezas");
		frmRompeCabezas.setResizable(false);
		frmRompeCabezas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRompeCabezas.getContentPane().setLayout(null);
		 
		tbl = new Tablero(4);
		crearCuadros();

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("img/cuadrado.png"));
		lblFondo.setBounds(0, 50, 484, 465);
		frmRompeCabezas.getContentPane().add(lblFondo);

		lblMovimientos = new JLabel("Movimientos:");
		lblMovimientos.setBounds(10, 11, 115, 14);
		frmRompeCabezas.getContentPane().add(lblMovimientos);

		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(135, 11, 46, 14);
		frmRompeCabezas.getContentPane().add(lblTiempo);

		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(228, 7, 89, 23);
		frmRompeCabezas.getContentPane().add(btnReiniciar);
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(330, 7, 89, 23);
		frmRompeCabezas.getContentPane().add(btnAyuda);

		// Accciones
		btnReiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int restart = JOptionPane.showConfirmDialog(null,
						"¿Desea reiniciar la partida?", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (restart == 0) {
					//HACER
					
					frmRompeCabezas.dispose();
					frmMain.main(null);
					
				}
			}
		});
	}

	private void crearCuadros() {
		int cont = 0;
		int posX = 0;
		int posY = 0;

		Matriz = tbl.getTabla();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cuadro[cont] = new JLabel();
				cuadro[cont].setText(i + "," + j);
				cuadro[cont].setIcon(new ImageIcon("img/" + Matriz[i][j]+ ".png"));
				cuadro[cont].setBounds(50 + posX, 105 + posY, 95, 95);
				posX = posX + 100;
				setActionListened(cont);
				frmRompeCabezas.getContentPane().add(cuadro[cont++]);
			}
			posY = posY + 95;
			posX = 0;
		}
	}
	
	
	
	// Crear las acciones del clic en cada uno de los Cuadros: Jlabel[]
	private void setActionListened(int index) {
		cuadro[index].addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JLabel labelAux = (JLabel) e.getSource();
				String str = labelAux.getText();
				String[] coord = str.split(",");
				Point cuadroXY = new Point(Integer.parseInt(coord[0]), Integer
						.parseInt(coord[1]));

				if (tbl.moverCuadrado(cuadroXY)) {
					Matriz = tbl.getTabla();
					int cont = 0;
					lblMovimientos.setText("Movimientos: " + movimientos++);

					for (int i = 0; i < tbl.size; i++) {
						for (int j = 0; j < tbl.size; j++) {
							cuadro[cont].setText(i + "," + j);
							cuadro[cont++].setIcon(new ImageIcon("img/"+ Matriz[i][j] + ".png"));
						}
					}
					if (tbl.checkWin()) {
						playSound("win");

					}
				}
			}
		});

	}

	private static void playSound(String sound) {
		String audioFilePath = "sounds/" + sound + ".wav";
		Sonidos player = new Sonidos();
		player.play(audioFilePath);
	}
}
