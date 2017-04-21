package Juego;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

public class Tablero {
	private int[][] tabla;
	public int size;

	public Tablero(int size) {
		this.size = size;
		tabla = new int[size][size];
		// Lista de numeros del 0-15 usados con el metodo Colllections.suffle
		// para establecer los cuadrados aleatoriamente
		ArrayList<Integer> cuadrado;
		cuadrado = new ArrayList<Integer>(size);
		for (int i = 0; i < size * size; i++)
			cuadrado.add(i);

		Collections.shuffle(cuadrado);

		int cont = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tabla[i][j] = cuadrado.get(cont++);
			}
		}

	}
//recibe del Jlabel.getText las coordenadas en el punto coord
	public boolean moverCuadrado(Point coord) {
		int[] posInicial = new int[2];
		posInicial = checkPosicion(coord.x, coord.y);
		
		if (posInicial[0] != -1) {
		//se permuta ya que es una movida valida	
			tabla[posInicial[0]][posInicial[1]] = tabla[coord.x][coord.y];
			tabla[coord.x][coord.y] = 0;
			return true;
		}
		return false;

	}
//se verifican las coordenadas del JLabel en el cual se hizo clic
//si el vector PosXY[0] es -1, no se hara nada
//si es distinto, es una jugada valida y podra permutarse con la casilla vacia
	private int[] checkPosicion(int posX, int posY) {
		int[] PosXY = new int[2];
		PosXY[0] = -1;
//chequeo posicion izquierda
		if (posX > 0)
			if (tabla[posX - 1][posY] == 0) {
				PosXY[0] = posX - 1;
				PosXY[1] = posY;
			}
//chequeo posicion derecha
		if (posX < tabla.length - 1)
			if (tabla[posX + 1][posY] == 0) {
				PosXY[0] = posX + 1;
				PosXY[1] = posY;
			}
//chequeo posicion abajo
		if (posY > 0)
			if (tabla[posX][posY - 1] == 0) {
				PosXY[0] = posX;
				PosXY[1] = posY - 1;
			}
//chequeo posicion arriba
		if (posY < tabla.length - 1)
			if (tabla[posX][posY + 1] == 0) {
				PosXY[0] = posX;
				PosXY[1] = posY + 1;
			}

		return PosXY;
	}

	public int[][] getTabla() {
		return tabla;
	}

	public void setTabla(int[][] tabla) {
		this.tabla = tabla;
	}
// se compara una lista del 1...10 la matriz actual
	public boolean checkWin() {
		int cont = 1;
		int comp = 0;
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				if (tabla[i][j] == cont++)
					comp++;
				else
					break;
			}
		}
//si el contador es igual al tamaño de la matriz significa que gano
		if (comp == (tabla.length * tabla.length) - 1)
			return true;
		return false;
	}

}
