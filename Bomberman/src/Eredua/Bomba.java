package Eredua;

import java.util.ArrayList;

public class Bomba{
	private LehertuPortaera lPortaera;
	
	protected Bomba(LehertuPortaera pLPort) {
		this.lPortaera=pLPort;
	}
	
	public ArrayList<int[]> kalkulatu(int pX, int pY) {
		return lPortaera.Lehertu(pX, pY);
	}
	
	/*public ArrayList<int[]> kalkulatuKoordenatuak(int pX, int pY) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}


