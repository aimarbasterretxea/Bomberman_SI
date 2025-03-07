package Eredua;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Bomberman extends Observable {
	//Atributuak
	private int x;
	private int y;
	private boolean bizirik;
	private Timer timer=null;
	protected int bombaKop;
	private int kontBomba=3;
	
	//Eraikitzailea
	public Bomberman() {
		this.x = 0;
		this.y = 0;
		this.bizirik = true;
		addObserver(Bista.LabirintoBista.getNireLabirintoBista());
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				updateKont();
			}	
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 200);
	}
	
	private void updateKont() {
		if(LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.x,this.y).getSua() instanceof Sua) {
        	this.bombermanHil();
		}
		//System.out.println("Kont: "+kontSua);
		if(bombaKop == 0) {
			System.out.println("Bomba kopurua agortu da");
			kontBomba--;
			if (kontBomba == 0) {
				System.out.println("Bomba kopurua gehi bat");
				kontBomba = 3;
				bombaKop++;
			}
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
	        setChanged();
	        notifyObservers(new Object[]{"Move", x, y});
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
