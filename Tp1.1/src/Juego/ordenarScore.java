package Juego;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ordenarScore {
	private ArrayList<Jugador> listaSorder= new ArrayList<Jugador>();

	public ordenarScore(ArrayList<Jugador> listaSorder) {
		this.listaSorder = listaSorder;
	}


	public void ordenarMov() {
		
			Collections.sort(listaSorder, new Comparator<Jugador>() {
				public int compare(Jugador a, Jugador b) {
					if (a.movimientos == b.movimientos)
						return a.nombre.compareTo(b.nombre);
					return a.movimientos > b.movimientos? 1 : a.movimientos < b.movimientos ? -1
							: 0;
				}
			});
		
		
	}

}
