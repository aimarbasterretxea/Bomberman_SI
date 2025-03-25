package Eredua;

import java.util.Timer;
import java.util.TimerTask;


public abstract class Bomberman {
	//Atributuak
	protected int x;
	protected int y;
	private static Timer timer=null;
	protected int bombaKop;
	
	//Eraikitzailea
	public Bomberman() { //Timer ez sortu eraikitzailean.
		this.x = 0;
		this.y = 0;
	}
	
    public void eguneratuBombaKop() {
        if (bombaKop <= 0) {
            birkargatuBomba();
        }
    }

    public void bombaGehitu() {
        if (bombaKop == 0) { 
            bombaKop = 1; 
            //LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.x, this.y).bombaJarri();
	       LabirintoaKlasikoa.getNireLabirintoKlasikoa().setChanged("BombaJarri", bombaKop, -1, ' ',false);
            if (timer != null) {
                timer.cancel(); // Gelditu Timer
                timer = null; // Berrabiarazi Timer
            }
            
        }
    }

    public void birkargatuBomba() {
        if (timer == null) { 
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
		LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.x,this.y).suaKendu();
		Jokua.getJokua().amaituJokua(1);
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
			if(LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.x,this.y).getSua()) {
			LabirintoaKlasikoa.getNireLabirintoKlasikoa().setChanged("Move", x, y, norabide,true);	
	        this.bombermanHil();
			}
	        LabirintoaKlasikoa.getNireLabirintoKlasikoa().setChanged("Move", x, y, norabide,true);
	        
	    }
	    else {
	        LabirintoaKlasikoa.getNireLabirintoKlasikoa().setChanged("Biratu", x, y, norabide,false);

	    }
	}

	private boolean posizioaBaliozkoaDa(int x, int y) {
	    return x >= 0 && x < 11 && y >= 0 && y < 17;
	}

	private boolean posizioaLibreaDa(int x, int y) {
	    Gelaxka gelaxka = LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(x, y);
	    return gelaxka.getBloke() == null && gelaxka.getBomba() == false;
	}

	public abstract void bombaJarri() ;
}
