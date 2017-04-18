package Juego;
import java.io.Serializable;

	

	public class Jugador implements Serializable {

		private static final long serialVersionUID = 1L;
		String nombre;
		String tiempo;
		int movimientos;
		
		
		public Jugador(String nombre, String tiempo, int movimientos) {
		
			this.nombre = nombre;
			this.tiempo = tiempo;
			this.movimientos = movimientos;

		}

	}


