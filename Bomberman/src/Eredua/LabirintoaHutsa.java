package Eredua;

import java.util.ArrayList;

public class LabirintoaHutsa extends Labirintoa{
	
	//Eraikitzailea
	public LabirintoaHutsa() {
		super();		
	}	
	
	@Override
	public void labirintoaOsatu(String pBomberMota,String pEtsaiaMota) {
		setChanged();
		notifyObservers("Matrizea sortu da");
		
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					if (i == 0 && j == 0) {
						//Bombermana gehitu
						sortuBomberman(pBomberMota);
					}
				} else if (Math.random() >= 0.95) {
					if (this.getEtsaiak().size() < 10) {
						//Etsaia gehitu
						gehituEtsaia(i,j,pEtsaiaMota);
					}
				}
			}
		}
		etsaiaTimer();
	}
	@Override
	public Object[] biderikMotzenaKalkulatu(int xEtsaia, int yEtsaia, int pLuzera, Character lehenNorabidea, boolean[][] bisitatuak) {
			ArrayList<Character> aukera = new ArrayList<Character>();
			aukera=this.kalkulatuNorabidePosibleak(xEtsaia, yEtsaia);
			Character norabiderikHoberena = ' ';
	        if (this.getBomberman().getX() < xEtsaia && aukera.contains('W')) {
	        	norabiderikHoberena = 'W';
	        } else if (this.getBomberman().getX() > xEtsaia && aukera.contains('S')) {
	            norabiderikHoberena = 'S';
	        } else if (this.getBomberman().getY() < yEtsaia && aukera.contains('A')) {
	            norabiderikHoberena = 'A';
	        } else if (this.getBomberman().getY() > yEtsaia && aukera.contains('D')) {
	            norabiderikHoberena = 'D';
	        }
	       
	        // Ez bada zuzeneanadd joaterik, ausaz bat
	        if (aukera.isEmpty()) {
	            int randomIndex = (int) (Math.random() * aukera.size());
	            norabiderikHoberena = aukera.get(randomIndex);
	        }
	       
	    
	return new Object[]{norabiderikHoberena, 0};
	}
	@Override
	public ArrayList<Character> kalkulatuNorabidePosibleak(int x, int y){
		ArrayList<Character> norabidePosibleak = new ArrayList<Character>();
		boolean intelijentea=this.getEtsaiak().get(0) instanceof EtsaiaInteligentea;
		//boolean intelijentea=true;
		if (x-1>=0  && !this.etsaiaDago(x-1,y)) {
			norabidePosibleak.add('W');
		}
		if(x+1<11  && !this.etsaiaDago(x+1,y)) {
			norabidePosibleak.add('S');
		}
		if(y-1>=0 &&!this.etsaiaDago(x,y-1)) {
			norabidePosibleak.add('A');
		}
		if(y+1<17 && !this.etsaiaDago(x,y+1) ) {
			norabidePosibleak.add('D');
		}
		if(norabidePosibleak.isEmpty()) {
			norabidePosibleak.add(' ');
		}
		return norabidePosibleak;
	}
}
