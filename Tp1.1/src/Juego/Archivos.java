package Juego;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Archivos  implements Serializable  {
public static ArrayList<Jugador> datos = new ArrayList<Jugador>();

public final static String path = "db.txt";

public void guardar() {
	try {
		FileOutputStream fos = new FileOutputStream(path, false);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(datos);
		out.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}

}

@SuppressWarnings("unchecked")
public static void abrir() {
	File f = new File(path);
	if (!f.exists() && !f.isDirectory()) {

	}
	try {
		
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream in = new ObjectInputStream(fis);
		datos =  (ArrayList<Jugador>) in.readObject();
		in.close();
		fis.close();

	} catch (Exception ex) {
		//ex.printStackTrace();
	}
}

public static ArrayList<Jugador> listadoJugadores() {
	abrir();
	return datos;
}



 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	String tiempo;
	int movimientos;
	 

	Archivos(String nombre, String tiempo, int movimientos ) {		
 		this.nombre=nombre;
		this.tiempo=tiempo;
		this.movimientos=movimientos;
 
	}
	

}
