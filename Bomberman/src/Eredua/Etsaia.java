package Eredua;

import java.util.ArrayList;


public abstract class Etsaia {
	//Atributuak
	private int x;
	private int y;
	//private Timer timerEtsaia;
	private MugimenduPortaera portaera;
	//Eraikitzailea
	public Etsaia(MugimenduPortaera pPortaera) {
		this.portaera=pPortaera;
	}
	
	public void setKoordenatuak(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}
	
	//Metodoak
	public char mugitu(ArrayList<Character> pNorabidePosibleak, int bombermX, int bombermY) {
	    int xBerria = this.x;
	    int yBerria = this.y;
        char norabide = portaera.aukeratuNorabidea(pNorabidePosibleak, xBerria, yBerria, bombermX, bombermY);

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
	        	return ' ';
	    }
    	this.x = xBerria;
        this.y = yBerria;
	    return norabide;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}


}