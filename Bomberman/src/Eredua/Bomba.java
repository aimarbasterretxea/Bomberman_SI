package Eredua;

import java.util.ArrayList;

public abstract class Bomba{
	private LehertuPortaera lPortaera;
	
	protected Bomba(LehertuPortaera pLPort) {
		this.lPortaera=pLPort;
	}
	
	public ArrayList<int[]> kalkulatu(int pX, int pY) {
		return lPortaera.Lehertu(pX, pY);
	}
	
}


