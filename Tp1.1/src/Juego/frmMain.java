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
import javax.swing.border.LineBorder;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Rectangle;

import javax.swing.JTextField;

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
	private JPanel panel4 = new JPanel();
	private JLabel lblPreview = new JLabel("");
	private JLabel lbWin = new JLabel("");
	private JTextField txtNombre;
	public static JLabel lblTiempo = new JLabel("Tiempo:");
	private JLabel lblMovimientosFinal;
	private JLabel lblTiempoFinal = new JLabel("Tiempo:");

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
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setPanelVisible(0);
		ButtonGroup bg = new ButtonGroup();

		frmRompeCabezas.getContentPane().add(panel1);

		JLabel lblPuzzle = new JLabel("PUZZLE");
		lblPuzzle.setBounds(0, 0, 485, 46);

		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setForeground(Color.ORANGE);
		lblPuzzle.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JButton btnConfig = new JButton("Configuraci\u00F3n");
		btnConfig.setBounds(173, 167, 165, 50);

		panel1.setBounds(0, 0, 484, 515);
		panel1.setLayout(null);

		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(173, 95, 165, 50);

		JButton btnLogros = new JButton("Logros");
		btnLogros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDetalles fDetalles = new frmDetalles();
				fDetalles.setLocationRelativeTo(null);
				fDetalles.setVisible(true);
			}

		});
		btnLogros.setBounds(173, 239, 165, 42);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(173, 375, 165, 50);

		panel1.add(btnJugar);
		panel1.add(btnConfig);
		panel1.add(btnLogros);
		panel1.add(btnSalir);
		panel1.add(lblPuzzle);

		JLabel lblFondo1 = new JLabel("");
		lblFondo1.setBounds(0, 0, 485, 515);
		lblFondo1.setIcon(new ImageIcon("img/background.png"));
		panel1.add(lblFondo1);

		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tbl = new Tablero(4);
				crearCuadros(lblPreview.getText());
				setPanelVisible(2);
			}
		});

		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelVisible(3);
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRompeCabezas.dispose();
			}
		});

		frmRompeCabezas.getContentPane().add(panel2);

		lblMovimientos = new JLabel("Movimientos:");
		lblMovimientos.setBounds(20, 9, 119, 14);

		lblTiempo.setBounds(141, 9, 111, 14);

		JButton btnReiniciar = new JButton("Menu Principal");
		btnReiniciar.setBounds(276, 5, 100, 23);

		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(386, 5, 99, 23);

		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 35, 484, 480);
		lblFondo.setIcon(new ImageIcon("img/cuadrado.png"));

		panel2.setBounds(0, 0, 484, 515);
		panel2.setLayout(null);
		panel2.add(btnAyuda);
		panel2.add(btnReiniciar);
		panel2.add(lblMovimientos);
		panel2.add(lblTiempo);
		panel2.add(lblFondo);

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
		frmRompeCabezas.getContentPane().add(panel3);

		JPanel pnlOptions = new JPanel();
		pnlOptions.setOpaque(false);
		pnlOptions.setBounds(81, 54, 316, 86);
		pnlOptions.setLayout(null);

		JRadioButton rdbtnImagenGato = new JRadioButton("Imagen Gato");
		JRadioButton rdbtnImagenPerro = new JRadioButton("Imagen Perro");
		JRadioButton rdbtnNumeros = new JRadioButton("Numeros");

		rdbtnImagenPerro.setBounds(54, 60, 230, 23);
		pnlOptions.add(rdbtnImagenPerro);

		rdbtnImagenGato.setBounds(54, 30, 230, 23);
		pnlOptions.add(rdbtnImagenGato);

		rdbtnNumeros.setBounds(54, 0, 230, 23);
		pnlOptions.add(rdbtnNumeros);

		// Default estilo (Numerico)
		rdbtnNumeros.setSelected(true);
		lblPreview.setText("numbers");
		bg.add(rdbtnNumeros);
		bg.add(rdbtnImagenPerro);
		bg.add(rdbtnImagenGato);

		JLabel lblSeleccioneLaImagen = new JLabel("Tiipo de juego:");
		lblSeleccioneLaImagen.setBounds(81, 27, 178, 23);

		lblPreview.setOpaque(true);
		lblPreview.setBounds(118, 192, 250, 250);
		lblPreview.setIcon(new ImageIcon("img/numbers/preview.png"));

		JLabel lblVistaPrevia = new JLabel("Vista Previa");
		lblVistaPrevia.setBounds(81, 158, 178, 23);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(81, 453, 142, 51);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(255, 453, 142, 51);

		panel3.setBounds(0, 0, 485, 515);

		panel3.setLayout(null);
		panel3.add(btnAceptar);
		panel3.add(btnVolver);
		panel3.add(lblVistaPrevia);
		panel3.add(lblPreview);
		panel3.add(pnlOptions);
		panel3.add(lblSeleccioneLaImagen);

		JLabel lblFondo3 = new JLabel("");
		lblFondo3.setBounds(0, 0, 485, 515);
		lblFondo3.setIcon(new ImageIcon("img/background.png"));
		panel3.add(lblFondo3);

		// ACCIONES
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelVisible(1);
			}
		});

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelVisible(1);
			}
		});

		rdbtnNumeros.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				changeImagePreview("numbers");

			}
		});
		rdbtnImagenGato.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				changeImagePreview("cat");
			}
		});
		rdbtnImagenPerro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				changeImagePreview("dog");
			}
		});

		panel4.setBounds(0, 0, 484, 515);
		frmRompeCabezas.getContentPane().add(panel4);
		panel4.setLayout(null);

		JButton btnVolverAJugar = new JButton("Volver a Jugar");

		btnVolverAJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Archivos file = new Archivos(txtNombre.getText(), lblTiempo
						.getText(), movimientos);
				file.guardar();

				frmRompeCabezas.dispose();
				frmMain.main(null);
			}
		});
		btnVolverAJugar.setBounds(78, 458, 126, 46);
		panel4.add(btnVolverAJugar);

		JButton btnEnd = new JButton("Salir");
		btnEnd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmRompeCabezas.dispose();
			}
		});
		btnEnd.setBounds(242, 458, 126, 46);
		panel4.add(btnEnd);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 413, 182, 28);
		panel4.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblEscribeTuNombre = new JLabel(
				"Escribe tu nombre para guardar tu puntuaci\u00F3n: ");
		lblEscribeTuNombre.setForeground(Color.WHITE);
		lblEscribeTuNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscribeTuNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEscribeTuNombre.setBounds(0, 388, 485, 14);
		panel4.add(lblEscribeTuNombre);

		JLabel lblFelicitaciones = new JLabel("FELICITACIONES!!!");
		lblFelicitaciones.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblFelicitaciones.setBounds(110, 163, 252, 36);
		panel4.add(lblFelicitaciones);

		lblTiempoFinal.setForeground(Color.WHITE);
		lblTiempoFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTiempoFinal.setBounds(79, 330, 271, 14);
		panel4.add(lblTiempoFinal);

		lblMovimientosFinal = new JLabel("MOVIMIENTOS:");
		lblMovimientosFinal.setForeground(Color.WHITE);
		lblMovimientosFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMovimientosFinal.setBounds(78, 355, 333, 14);
		panel4.add(lblMovimientosFinal);

		lbWin.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbWin.setBounds(new Rectangle(41, 0, 400, 323));

		panel4.add(lbWin);

		JLabel lblFondoWin = new JLabel("");
		lblFondoWin.setBounds(0, 0, 485, 515);
		lblFondoWin.setIcon(new ImageIcon("img/background.png"));
		panel4.add(lblFondoWin);

		setPanelVisible(1);

	}

	private void setPanelVisible(int panelSelected) {
		switch (panelSelected) {
		case 1:
			panel1.setVisible(true);
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(false);
			break;
		case 2:
			@SuppressWarnings("unused")
			cronometro c = new cronometro();
			panel1.setVisible(false);
			panel2.setVisible(true);
			panel3.setVisible(false);
			panel4.setVisible(false);
			break;
		case 3:
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(true);
			panel4.setVisible(false);
			break;
		case 4:
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(true);
			break;
		}

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
				cuadro[cont].setIcon(new ImageIcon("img/" + Style + "/"
						+ Matriz[i][j] + ".png"));
				cuadro[cont].setBounds(60 + posX, 95 + posY, 95, 95);
				posX = posX + 95;
				cuadro[cont].setBorder(LineBorder.createBlackLineBorder());
				setActionListened(cont, Style);
				panel2.add(cuadro[cont++]);
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
							cuadro[cont].setBorder(LineBorder
									.createBlackLineBorder());
							cuadro[cont++].setIcon(new ImageIcon("img/" + Style
									+ "/" + Matriz[i][j] + ".png"));
						}
					}

					if (tbl.checkWin()) {
						lbWin.setIcon(new ImageIcon("img/win.gif"));
						lblMovimientosFinal.setText(lblMovimientos.getText());
						lblTiempoFinal.setText(lblTiempo.getText());
						setPanelVisible(4);
						playSound("win");

					}
				}
			}
		});

	}

	private void changeImagePreview(String preview) {
		lblPreview.setIcon(new ImageIcon("img/" + preview + "/preview.png"));
		lblPreview.setText(preview);

	}

	private static void playSound(String sound) {
		String audioFilePath = "sounds/" + sound + ".wav";
		Sonidos player = new Sonidos();
		player.play(audioFilePath);
	}

}
