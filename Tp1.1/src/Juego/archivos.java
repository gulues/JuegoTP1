package Juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class archivos implements Serializable {
	private static final long serialVersionUID = 1L;
	public static ArrayList<Jugador> datos = new ArrayList<Jugador>();
	public final static String path = "db.txt";

	// se guardan el objeto jugador actual en archivo, y se remplaza la variable
	// "Tiempo: hh:mm:ss" por "hh:mm:ss" de jugador.tiempo

	public void guardar(Jugador J) {
		try {
			String reemplazoString = new String(J.tiempo);
			J.tiempo = reemplazoString.replace("Tiempo: ", "");
			datos.add(J);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(datos);
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Jugador> abrir() {
		File f = new File(path);
		if (!f.exists() && !f.isDirectory())
			return null;

		try {

			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fis);
			datos = (ArrayList<Jugador>) in.readObject();
			in.close();
			fis.close();

		} catch (Exception ex) {
			// ex.printStackTrace();
		}
		return datos;
	}

}
