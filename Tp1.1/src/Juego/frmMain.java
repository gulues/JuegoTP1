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
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain {
	private int[][] Matriz;
	private int movimientos = 1;
	private JLabel lblMovimientos;
	private JLabel[] cuadro = new JLabel[16];
	private JFrame frmRompeCabezas;
	private Tablero tbl;
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

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
		
		//paneles
		
		panel2.setVisible(false);
		panel1.setBounds(0, 0, 484, 515);
		panel1.setLayout(null);
		frmRompeCabezas.getContentPane().add(panel1);
		

		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(false);
				panel2.setVisible(true);
			}
		});
		btnJugar.setBounds(173, 95, 165, 50);
		panel1.add(btnJugar);

		JButton btnLogros = new JButton("Logros");
		btnLogros.setBounds(173, 263, 165, 42);
		panel1.add(btnLogros);

		JLabel lblPuzzle = new JLabel("PUZZLE");
		lblPuzzle.setBounds(221, 38, 46, 14);
		panel1.add(lblPuzzle);

		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRompeCabezas.dispose();
			}
		});
		btnNewButton_1.setBounds(173, 343, 165, 50);
		panel1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Configuraci\u00F3n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		btnNewButton.setBounds(173, 189, 165, 50);
		panel1.add(btnNewButton);

		JLabel lblFondo1 = new JLabel("");
		lblFondo1.setBounds(0, 0, 485, 515);
		panel1.add(lblFondo1);
		panel2.setBounds(0, 0, 484, 515);
		lblFondo1.setIcon(new ImageIcon("img/background.png"));
		frmRompeCabezas.getContentPane().add(panel2);
		panel2.setLayout(null);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(116, 16, 0, 0);
		panel2.add(lblFondo);
		lblFondo.setIcon(new ImageIcon("img/cuadrado.png"));

		lblMovimientos = new JLabel("Movimientos:");
		lblMovimientos.setBounds(20, 9, 63, 14);
		panel2.add(lblMovimientos);

		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(141, 9, 38, 14);
		panel2.add(lblTiempo);

		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(276, 5, 73, 23);
		panel2.add(btnReiniciar);
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(375, 5, 63, 23);
		panel2.add(btnAyuda);

		// Accciones
		btnReiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int restart = JOptionPane.showConfirmDialog(null,
						"¿Desea reiniciar la partida?", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (restart == 0) {
					// HACER

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

				cuadro[cont].setIcon(new ImageIcon("img/" + Matriz[i][j]
						+ ".png"));
				cuadro[cont].setBounds(60 + posX, 95 + posY, 95, 95);
				posX = posX + 95;
				setActionListened(cont);
				panel2.add(cuadro[cont]);
				// frmRompeCabezas.getContentPane().add(cuadro[cont++]);

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
							cuadro[cont++].setIcon(new ImageIcon("img/"
									+ Matriz[i][j] + ".png"));
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
