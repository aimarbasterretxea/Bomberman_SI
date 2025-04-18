package Eredua;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Etsaia {
	//Atributuak
	private int x;
	private int y;
	private Timer timerEtsaia;
	
	//Eraikitzailea
	protected Etsaia() {
		
	}
	
	public void setKoordenatuak(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}
	
	//Metodoak
	public char mugitu(ArrayList<Character> pNorabidePosibleak) {
	    int xBerria = this.x;
	    int yBerria = this.y;
	    char norabide = etsaiaMugitu(pNorabidePosibleak);

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
	
	private char etsaiaMugitu(ArrayList<Character> pNorabidePosibleak) {
	    return pNorabidePosibleak.get((int) (Math.random() * pNorabidePosibleak.size()));
	}	

}