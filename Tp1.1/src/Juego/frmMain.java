package Juego;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


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
	private JLabel lblPreview = new JLabel("");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		
				frmMain window = new frmMain();
				window.frmRompeCabezas.setVisible(true);

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
		 try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel1.setVisible(true);
		panel3.setVisible(false);
		panel3.setBounds(0, 0, 485, 515);
		frmRompeCabezas.getContentPane().add(panel3);
		panel3.setLayout(null);
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			panel1.setVisible(true);
			panel3.setVisible(false);
			}
		});
		btnAceptar.setBounds(81, 453, 142, 51);
		panel3.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel3.setVisible(false);
				panel1.setVisible(true);
			}
		});
		btnVolver.setBounds(255, 453, 142, 51);
		panel3.add(btnVolver);
		
		JPanel pnlOptions = new JPanel();
		pnlOptions.setOpaque(false);
		pnlOptions.setBounds(81, 54, 316, 86);
		panel3.add(pnlOptions);
		pnlOptions.setLayout(null);
		
			JRadioButton rdbtnImagenGato = new JRadioButton("Imagen Gato");
			rdbtnImagenGato.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					changeImagePreview("cat");
				}
			});
			rdbtnImagenGato.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					changeImagePreview("cat");
				}
			});
			rdbtnImagenGato.setBounds(54, 59, 230, 23);
			pnlOptions.add(rdbtnImagenGato);
			
			JRadioButton rdbtnImagenPerro = new JRadioButton("Imagen Perro");
			rdbtnImagenPerro.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					changeImagePreview("dog");
				}
			});
			rdbtnImagenPerro.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					changeImagePreview("dog");
				}
			});
			
			rdbtnImagenPerro.setBounds(54, 33, 230, 23);
			pnlOptions.add(rdbtnImagenPerro);
			
			JRadioButton rdbtnNumeros = new JRadioButton("Numeros");
			rdbtnNumeros.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					changeImagePreview("numbers");
					
				}
			});
			rdbtnNumeros.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						changeImagePreview("numbers");
				}

				
			});
			rdbtnNumeros.setBounds(54, 7, 230, 23);
			pnlOptions.add(rdbtnNumeros);
			rdbtnNumeros.setSelected(true);
			ButtonGroup bg = new ButtonGroup();
			
			bg.add(rdbtnNumeros);
			bg.add(rdbtnImagenPerro);
			bg.add(rdbtnImagenGato);
		
		JLabel lblSeleccioneLaImagen = new JLabel("Seleccione el tipo de juego:");
		lblSeleccioneLaImagen.setBounds(81, 27, 178, 23);
		panel3.add(lblSeleccioneLaImagen);
		
		
		
		
		
		lblPreview.setOpaque(true);
		lblPreview.setBounds(118, 192, 250, 250);
		lblPreview.setIcon(new ImageIcon("img/numbers/preview.png"));
		panel3.add(lblPreview);
		
		JLabel lblVistaPrevia = new JLabel("Vista Previa");
		lblVistaPrevia.setBounds(81, 158, 178, 23);
		panel3.add(lblVistaPrevia);
		
		JLabel lblFondo3 = new JLabel("");
		lblFondo3.setBounds(0, 0, 485, 515);
		lblFondo3.setIcon(new ImageIcon("img/background.png"));
		panel3.add(lblFondo3);
		panel3.setVisible(false);
		panel1.setBounds(0, 0, 484, 515);
		panel1.setLayout(null);
		frmRompeCabezas.getContentPane().add(panel1);
		

		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tbl = new Tablero(4);
				crearCuadros(lblPreview.getText());
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
				panel2.setBounds(0, 0, 484, 515);
				frmRompeCabezas.getContentPane().add(panel2);
				panel2.setLayout(null);
				
						lblMovimientos = new JLabel("Movimientos:");
						lblMovimientos.setBounds(20, 9, 143, 14);
						panel2.add(lblMovimientos);
						
								JLabel lblTiempo = new JLabel("Tiempo:");
								lblTiempo.setBounds(141, 9, 111, 14);
								panel2.add(lblTiempo);
								
										JButton btnReiniciar = new JButton("Reiniciar");
										btnReiniciar.setBounds(276, 5, 100, 23);
										panel2.add(btnReiniciar);
										JButton btnAyuda = new JButton("Ayuda");
										btnAyuda.setBounds(375, 5, 99, 23);
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
				
				
				panel1.setVisible(true);
				panel2.setVisible(false);
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
				setActionListened(cont,Style);
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
 private void changeImagePreview(String preview) {
	lblPreview.setIcon(new ImageIcon("img/" +preview+ "/preview.png"));
	lblPreview.setText(preview);
	
}

 private static void playSound(String sound) {
		String audioFilePath = "sounds/" + sound + ".wav";
		Sonidos player = new Sonidos();
		player.play(audioFilePath);
	}
	
}
