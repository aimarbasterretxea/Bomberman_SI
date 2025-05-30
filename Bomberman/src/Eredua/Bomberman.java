package Eredua;

import java.util.Timer;
import java.util.TimerTask;


public abstract class Bomberman {
	//Atributuak
	private int x;
	private int y;
	private static Timer timer=null;
	protected int bombaKop;
	protected String bombaMota;
	private static int pausuak=1;
	private String aurrekoNorabidea ="";
	private String norabideBerria="";
	protected String kolorea="";
	private boolean bizirik=true;
	
	//Eraikitzailea
	protected Bomberman() { 
		this.x = 0;
		this.y = 0;
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik=bizirik;
	}
	
	//Geterrak
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean getBizirik() {
		return this.bizirik;
	}
	
	public int getBombaKop() {
		return this.bombaKop;
	}
	
	public String getKolorea() {
		return this.kolorea;
	}
	
	//Metodoak
    public void eguneratuBombaKop() {
        if (bombaKop <= 0) {
            birkargatuBomba();
        }
    }
    
    public void bombaGehitu() {
        if (bombaKop == 0) { 
            bombaKop = 1; 
            Generator.getNireGenerator().getLabirintoa().abisatuObservers(new Object[]{"Bomba kop eguneratu", bombaKop});
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
            timer.scheduleAtFixedRate(timerTask, 3000, 3000); 
        }
    }
    
	public void bombaJarri() {
 		if (Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.getX(), this.getY()).bombaDago() == false && bombaKop > 0) {
 			Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.getX(), this.getY()).bombaJarri(this.bombaMota);
 			bombaKop--;
 			}	
 		Generator.getNireGenerator().getLabirintoa().abisatuObservers(new Object[] {"Bomba kop eguneratu", this.bombaKop});
 		this.eguneratuBombaKop();
 	}
	
	public void mugitu(String norabide, boolean bombaDago) {
	    int xBerria = this.x;
	    int yBerria = this.y;
	    int xZaharra = this.x;
	    int yZaharra = this.y;
	    
	    
	    switch (norabide) {
	        case "left": // Ezkerretara mugitu
	            yBerria--;
	            norabideBerria="left";
	            break;
	        case "right": // Eskuinera mugitu
	            yBerria++;
	            norabideBerria="right";
	            break;
	        case "up": // Gora mugitu
	            xBerria--;
	            norabideBerria="up";
	            break;
	        case "down": // Behera mugitu
	            xBerria++;
	            if (pausuak>=4) {
	            	pausuak=0;
	            }
	            norabideBerria="down";
	            break;
	        default:
	            return; // Norabide baliogabea bada, irten
	    }
	    
	    if (aurrekoNorabidea.equals(norabideBerria)&&aurrekoNorabidea!="") {
	    				if (pausuak>=5) {
	    					pausuak=0;
	    				}
	    				pausuak++;
	    }
	    else{
	    				pausuak=1;
	    }
	   
	    aurrekoNorabidea=norabideBerria;
	    boolean bomba=Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.x, this.y).bombaDago();
	    
	    // Egiaztatu posizio berria baliozkoa eta libre dagoen
	    if (posizioaBaliozkoaDa(xBerria, yBerria) && posizioaLibreaDa(xBerria, yBerria)) {
	        this.x = xBerria;
	        this.y = yBerria;
	        if(Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.x,this.y).getSua()!=null || Generator.getNireGenerator().getLabirintoa().etsaiaDago(x,y)) {
	        	Generator.getNireGenerator().getLabirintoa().abisatuObservers(new Object[]{"Move", x, y, norabide,pausuak, kolorea});	
	        	this.bombermanHil();
			}
				Generator.getNireGenerator().getLabirintoa().abisatuObservers(new Object[]{"Move", x, y, norabide, pausuak,kolorea});
				if(!bomba){
				Generator.getNireGenerator().getLabirintoa().abisatuObservers(new Object[]{"Bomberman kendu", xZaharra, yZaharra,this.kolorea});
	    }
				else {
					Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(xZaharra, yZaharra).bombaAldatu();
				}
				}
	    	
	    else {
	    	if(!bomba) {
	    	Generator.getNireGenerator().getLabirintoa().abisatuObservers(new Object[]{"Biratu", x, y, norabide,pausuak,kolorea});
	    	}
	    }
	   
    }

	private boolean posizioaBaliozkoaDa(int x, int y) {
	    return x >= 0 && x < 11 && y >= 0 && y < 17;
	}

	private boolean posizioaLibreaDa(int x, int y) {
	    Gelaxka gelaxka = Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(x, y);
	    return gelaxka.getBloke() == null && gelaxka.bombaDago() == false;
	}
	
	private void bombermanHil(){
		Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(this.x,this.y).suaKendu();
		Jokua.getJokua().amaituJokua(1,new Object[] {this.x, this.y,this.kolorea});
	}

}
