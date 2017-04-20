package Juego;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unused")
public class Tablero {
	private int[][] tabla;
	public int size;

	public Tablero(int size) {
		this.size = size;
		tabla = new int[size][size];
		ArrayList<Integer> cuadrado;
		cuadrado = new ArrayList<Integer>(size);
		for (int i =0; i < size * size; i++)
			cuadrado.add(i);

	   Collections.shuffle(cuadrado);
		//cuadrado.add(0);
		int cont = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tabla[i][j] = cuadrado.get(cont++);
			}
		}

	}

	public boolean moverCuadrado(Point coord) {
		int[] posInicial = new int[2];
		posInicial = checkPosicion(coord.x, coord.y);
		if (posInicial[0] != -1) {
			tabla[posInicial[0]][posInicial[1]] = tabla[coord.x][coord.y];
			tabla[coord.x][coord.y] = 0;
			return true;
		}
		return false;

	}

	private int[] checkPosicion(int posX, int posY) {
		int[] PosXY = new int[2];
		PosXY[0] = -1;

		if (posX > 0)
			if (tabla[posX - 1][posY] == 0) {
				PosXY[0] = posX - 1;
				PosXY[1] = posY;
			}
		if (posX < tabla.length - 1)
			if (tabla[posX + 1][posY] == 0) {
				PosXY[0] = posX + 1;
				PosXY[1] = posY;
			}
		if (posY > 0)
			if (tabla[posX][posY - 1] == 0) {
				PosXY[0] = posX;
				PosXY[1] = posY - 1;
			}
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
		if (comp == (tabla.length * tabla.length) - 1)
			return true;
		return false;
	}

}
