package Juego;

public class cronometro implements Runnable {
	public static boolean cero;
	int minutos = 0, segundos = 0, horas = 0;
	Thread crono;

	public cronometro() {
		crono = new Thread(this);
		crono.start();
	}

	// para restablecer el cronometro a cero
	public void setCero(boolean b) {
		cero = b;
	}

	public void run() {

		String hs0 = "0", min0 = "0", seg0 = "0";
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
				if (cero) {
					minutos = 0;
					segundos = 0;
					horas = 0;
				}

				frmMain.lblTiempo.setText("Tiempo: " + hs0 + horas + ":" + min0
						+ minutos + ":" + seg0 + segundos);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}