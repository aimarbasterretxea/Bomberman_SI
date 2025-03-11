package Eredua;

import java.awt.Image;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public abstract class Bomberman extends Observable {
	//Atributuak
	private int x;
	private int y;
	private boolean bizirik;
	private static Timer timer=null;
	protected int bombaKop;
	private int kontBomba=3;
	private ImageIcon irudia;
	
	//Eraikitzailea
	public Bomberman() { //Timer ez sortu eraikitzailean.
		this.x = 0;
		this.y = 0;
		this.bizirik = true;
		this.irudia = new ImageIcon(new ImageIcon("irudiak/bomber1.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		addObserver(Bista.LabirintoBista.getNireLabirintoBista());
	}
	
    public void eguneratuBombaKop() {
        if (bombaKop <= 0) {
            birkargatuBomba();
        }
        System.out.println("Bomba kopurua: " + this.bombaKop);
    }

    public void bombaGehitu() {
        if (bombaKop == 0) { // Solo recargar si no hay bombas
            bombaKop = 1; // Recargar una bomba
            System.out.println("Bomba kopurua gehitu da");
            if (timer != null) {
                timer.cancel(); // Detener el Timer después de recargar
                timer = null; // Reiniciar el Timer para futuras recargas
            }
        }
    }

    public void birkargatuBomba() {
        if (timer == null) { // Solo iniciar el Timer si no hay uno activo
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    bombaGehitu();
                }
            };
            timer = new Timer();
            timer.scheduleAtFixedRate(timerTask, 3000, 3000); // Esperar 3 segundos antes de la primera ejecución
        }
    }
	
	//Geterrak
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	//Metodoak
	private void bombermanHil(){
		Jokua.getJokua().amaituJokua();
	}
	
	public void mugitu(char norabide) {
	    int xBerria = this.x;
	    int yBerria = this.y;

	    switch (norabide) {
	        case 'A': // Ezkerretara mugitu
	            yBerria--;
	            break;
	        case 'D': // Eskuinera mugitu
	            yBerria++;
	            break;
	        case 'W': // Gora mugitu
	            xBerria--;
	            break;
	        case 'S': // Behera mugitu
	            xBerria++;
	            break;
	        default:
	            return; // Norabide baliogabea bada, irten
	    }

	    // Egiaztatu posizio berria baliozkoa eta libre dagoen
	    if (posizioaBaliozkoaDa(xBerria, yBerria) && posizioaLibreaDa(xBerria, yBerria)) {
	        this.x = xBerria;
	        this.y = yBerria;
			if(LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.x,this.y).getSua() instanceof Sua) {
	        	this.bombermanHil();
			}
	        setChanged();
	        notifyObservers(new Object[]{"Move", x, y, norabide});
	    }
	}

	private boolean posizioaBaliozkoaDa(int x, int y) {
	    return x >= 0 && x < 11 && y >= 0 && y < 17;
	}

	private boolean posizioaLibreaDa(int x, int y) {
	    Gelaxka gelaxka = LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(x, y);
	    return gelaxka.getBloke() == null && gelaxka.getBomba() == null;
	}

	public abstract void bombaJarri() ;
}
