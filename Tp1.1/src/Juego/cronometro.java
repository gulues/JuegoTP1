package Juego;

public class cronometro implements Runnable {

	Thread crono;

	/** Creates new form cronometro */
	public cronometro() {
		crono = new Thread(this);
		crono.start();
	}

	int minutos = 0, segundos = 0, horas = 0;
	String hs0 = "0", min0 = "0", seg0 = "0";

	@SuppressWarnings("static-access")
	public void run() {
		try {
			while (true) {
				if (segundos == 59) {
					segundos = 0;
					minutos++;
				}
				if (minutos == 59) {
					minutos = 0;
					horas++;
				}
				segundos++;

				if (horas < 10)
					hs0 = "0";
				else
					hs0 = "";
				if (minutos < 10)
					min0 = "0";
				else
					min0 = "";
				if (segundos < 10)
					seg0 = "0";
				else
					seg0 = "";

				frmMain.lblTiempo.setText("Tiempo: " + hs0 + horas + ":" + min0
						+ minutos + ":" + seg0 + segundos);
				crono.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}