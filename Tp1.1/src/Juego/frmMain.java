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
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class frmMain {
	private int[][] Matriz;
	private int movimientos = 1;
	private JLabel lblMovimientos;
	private JLabel[] cuadro = new JLabel[16];
	private JFrame frmRompeCabezas;
	private Tablero tbl;
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();

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
		
		panel1.setVisible(true);
		panel1.setBounds(0, 0, 484, 515);
		panel1.setLayout(null);
		frmRompeCabezas.getContentPane().add(panel1);
		

		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tbl = new Tablero(4);
				crearCuadros("numbers");
				panel1.setVisible(false);
				panel2.setVisible(true);
			}
		});
		
				JLabel lblPuzzle = new JLabel("PUZZLE");
				lblPuzzle.setBounds(0, 0, 485, 46);
				panel1.add(lblPuzzle);
				lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
				lblPuzzle.setForeground(Color.ORANGE);
				lblPuzzle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnJugar.setBounds(173, 95, 165, 50);
		panel1.add(btnJugar);

		JButton btnLogros = new JButton("Logros");
		btnLogros.setBounds(173, 239, 165, 42);
		panel1.add(btnLogros);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRompeCabezas.dispose();
			}
		});
		btnSalir.setBounds(173, 375, 165, 50);
		panel1.add(btnSalir);
		
		JButton btnConfig = new JButton("Configuraci\u00F3n");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(false);
				panel3.setVisible(true);
				
			}
		});
		btnConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			}
		});
		btnConfig.setBounds(173, 167, 165, 50);
		panel1.add(btnConfig);

		JLabel lblFondo1 = new JLabel("");
		lblFondo1.setBounds(0, 0, 485, 515);
		panel1.add(lblFondo1);
		lblFondo1.setIcon(new ImageIcon("img/background.png"));
				panel3.setVisible(false);
				panel2.setBounds(0, 0, 484, 515);
				frmRompeCabezas.getContentPane().add(panel2);
				panel2.setLayout(null);
				
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
										
												JLabel lblFondo = new JLabel("");
												lblFondo.setBounds(0, 35, 484, 480);
												panel2.add(lblFondo);
												lblFondo.setIcon(new ImageIcon("img/cuadrado.png"));
												
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
				panel3.setBounds(0, 0, 485, 515);
				frmRompeCabezas.getContentPane().add(panel3);
				panel3.setLayout(null);
				JButton btnNewButton_2 = new JButton("Aceptar");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					}
				});
				btnNewButton_2.setBounds(81, 453, 142, 51);
				panel3.add(btnNewButton_2);
				
				JButton btnNewButton_3 = new JButton("Volver");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel3.setVisible(false);
						panel1.setVisible(true);
					}
				});
				btnNewButton_3.setBounds(255, 453, 142, 51);
				panel3.add(btnNewButton_3);
				
				JLabel lblSeleccioneLaImagen = new JLabel("Seleccione el tipo de juego:");
				lblSeleccioneLaImagen.setBounds(81, 27, 178, 23);
				panel3.add(lblSeleccioneLaImagen);
				
				JPanel panel = new JPanel();
				panel.setBounds(81, 54, 316, 86);
				panel3.add(panel);
				panel.setLayout(null);
				
				JRadioButton rdbtnImagenGato = new JRadioButton("Imagen Gato");
				rdbtnImagenGato.setBounds(54, 59, 87, 23);
				panel.add(rdbtnImagenGato);
				
				JRadioButton rdbtnImagenPerro = new JRadioButton("Imagen Perro");
				rdbtnImagenPerro.setBounds(54, 33, 91, 23);
				panel.add(rdbtnImagenPerro);
				
				JRadioButton rdbtnNumeros = new JRadioButton("Numeros");
				rdbtnNumeros.setBounds(54, 7, 67, 23);
				panel.add(rdbtnNumeros);
				rdbtnNumeros.setSelected(true);
				
				JLabel lblPreview = new JLabel("");
				lblPreview.setOpaque(true);
				lblPreview.setBounds(118, 192, 250, 250);
				panel3.add(lblPreview);
				
				JLabel lblVistaPrevia = new JLabel("Vista Previa");
				lblVistaPrevia.setBounds(81, 158, 178, 23);
				panel3.add(lblVistaPrevia);
				
				JLabel lblFondo3 = new JLabel("");
				lblFondo3.setBounds(0, 0, 485, 515);
				lblFondo3.setIcon(new ImageIcon("img/background.png"));
				panel3.add(lblFondo3);
				
				
				panel1.setVisible(true);
				panel2.setVisible(false);
				panel3.setVisible(false);
	}

	private void crearCuadros(String Style) {
		int cont = 0;
		int posX = 0;
		int posY = 0;

		Matriz = tbl.getTabla();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cuadro[cont] = new JLabel();
				cuadro[cont].setText(i + "," + j);

				cuadro[cont].setIcon(new ImageIcon("img/"+ Style+ "/"
						+ Matriz[i][j] + ".png"));
				cuadro[cont].setBounds(60 + posX, 95 + posY, 95, 95);
				posX = posX + 95;
				setActionListened(cont,"numbers");
				panel2.add(cuadro[cont++]);
				//frmRompeCabezas.getContentPane().add(cuadro[cont++]);

			}
			posY = posY + 95;
			posX = 0;
		}
	}

	// Crear las acciones del clic en cada uno de los Cuadros: Jlabel[]
	private void setActionListened(int index, String Style) {
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
							cuadro[cont++].setIcon(new ImageIcon("img/"+ Style+ "/"
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
