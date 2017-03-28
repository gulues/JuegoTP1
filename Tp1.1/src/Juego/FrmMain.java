package Juego;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmMain {
	Tablero tbl = new Tablero(4);
	int[][] Matriz ;
	int movimientos=1;
	JLabel lblMovimientos;
	JLabel[] cuadro = new JLabel[16];
	static String path = new File("").getAbsolutePath();
	JLabel lblGanaste = new JLabel("GANASTE!!!");
	
	public JFrame frmRompeCabezas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					FrmMain window = new FrmMain();
					window.frmRompeCabezas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmMain() {
		initialize();
	}

	private void initialize() {
		
		frmRompeCabezas = new JFrame();
		frmRompeCabezas.getContentPane()
				.setBackground(new Color(240, 240, 240));
		frmRompeCabezas.setBounds(100, 100, 491, 544);
		frmRompeCabezas.setLocationRelativeTo(null);
		frmRompeCabezas.setTitle("Rompe Cabezas");
		frmRompeCabezas.setResizable(false);
		frmRompeCabezas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRompeCabezas.getContentPane().setLayout(null);

		
		int cont = 0;
		int posX = 0;
		int posY = 0;
		Matriz = tbl.getTabla();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cuadro[cont] = new JLabel();
				
				cuadro[cont].setText(i + "," + j);
				cuadro[cont].setIcon(new ImageIcon(path + "/img/"
						+ Matriz[i][j] + ".png"));
				cuadro[cont].setBounds(50 + posX, 105 + posY, 95, 95);
				
				posX = posX + 100;
				// cuadro[cont].setText(text);
				setActionListened(cont++);
				frmRompeCabezas.getContentPane().add(cuadro[cont - 1]);
			}
			posY = posY + 95;
			posX = 0;
		}
		lblGanaste.setOpaque(true);
		
		
		lblGanaste.setForeground(Color.RED);
		lblGanaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanaste.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblGanaste.setBounds(0, 39, 475, 465);
		lblGanaste.setVisible(false);
		frmRompeCabezas.getContentPane().add(lblGanaste);


		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(path + "/img/cuadrado.png"));
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
		
		System.out.println(tbl.toString());

	}

	private void setActionListened(int var) {
		cuadro[var].addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				String str = label.getText();
				String[] ar = str.split(",");
				int cuadroPosX= Integer.parseInt(ar[0]);
				int cuadroPosY= Integer.parseInt(ar[1]);
				if(tbl.moverCuadrado(cuadroPosX,cuadroPosY)){
					Matriz = tbl.getTabla();
					int cont=0;
					lblMovimientos.setText("Movimientos: " + movimientos++);
					
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							cuadro[cont].setText(i + "," + j);
							cuadro[cont++].setIcon(new ImageIcon(path + "/img/"
									+ Matriz[i][j] + ".png"));
							
						}
					}
				if (tbl.checkWin()){
					//lblGanaste.setVisible(true);
					FrmMain.this.frmRompeCabezas.setEnabled(false);
					playSound("win");
					
					
				}
				}
			}
		});
		
	}

	private static void playSound(String sound){
		String audioFilePath = path + "/sounds/"+sound+".wav";
        Sonidos player = new Sonidos();
        player.play(audioFilePath);
	}
}
