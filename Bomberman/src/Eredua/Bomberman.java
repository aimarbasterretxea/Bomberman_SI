package Eredua;

import java.util.Timer;
import java.util.TimerTask;


public abstract class Bomberman {
	//Atributuak
	protected int x;
	protected int y;
	private static Timer timer=null;
	protected int bombaKop;
	protected String bombaMota;
	
	//Eraikitzailea
	protected Bomberman() { 
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
            Generator.getNireGenerator().getLabirintoa().setChanged("BombaJarri", bombaKop, -1, ' ',false);
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
		Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.x,this.y).suaKendu();
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
	        if(Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.x,this.y).getSua()!=null || Generator.getNireGenerator().getLabirintoa().etsaiaDago(x,y)) {
			Generator.getNireGenerator().getLabirintoa().setChanged("Move", x, y, norabide,true);	
	        this.bombermanHil();
			}
			Generator.getNireGenerator().getLabirintoa().setChanged("Move", x, y, norabide,true);
	        
	    }
	    else {
	    	Generator.getNireGenerator().getLabirintoa().setChanged("Biratu", x, y, norabide,false);

	    }
	}

	private boolean posizioaBaliozkoaDa(int x, int y) {
	    return x >= 0 && x < 11 && y >= 0 && y < 17;
	}

	private boolean posizioaLibreaDa(int x, int y) {
	    Gelaxka gelaxka = Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(x, y);
	    return gelaxka.getBloke() == null && gelaxka.getBomba() == false;
	}

	public void bombaJarri() {
 		if (Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.getX(), this.getY()).getBomba() == false && bombaKop > 0) {
 			Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.getX(), this.getY()).bombaJarri(this.bombaMota);
 			bombaKop--;
 			}	
 		Generator.getNireGenerator().getLabirintoa().bombaJarriDa(this.bombaKop);
 		this.eguneratuBombaKop();
 	}
}
