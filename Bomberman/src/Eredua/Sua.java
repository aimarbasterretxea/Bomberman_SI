package Eredua;

import java.util.Timer;
import java.util.TimerTask;

public class Sua {
	//Atributua
    private int x;
    private int y;
    private Timer timer = null;
    private int kont = 2;
    private boolean azkenSuaDa = true; 

    // Eraikitzailea
    public Sua(int pX, int pY) {
        this.x = pX;
        this.y = pY;

        if (besteSuaDago(x, y)) {
            azkenSuaDa = false; 
        }

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                updateKont();
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private void updateKont() {
        kont--;
        System.out.println("sua at (" + x + "," + y + "): " + kont);

        if (kont == 0) {
            if (azkenSuaDa) {
                LabirintoaKlasikoa.getNireLabirintoKlasikoa().suaKendu(x, y);
            }
            timer.cancel();
        }
    }

    private boolean besteSuaDago(int x, int y) {
        if(LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(x, y).getSua()==null) {
        	return false;// Modificar según sea necesario
        } else {
        	return true;
        }
    }
}
