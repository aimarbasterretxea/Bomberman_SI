package Eredua;

public class Laukia {
	private int x;
	private int y;
	private boolean egoera;
	private Bloke bloke;
	
	public Laukia(int pX, int pY, boolean pEgoera, Bloke pBloke) {
		this.x=pX;
		this.y=pY;
		this.egoera=pEgoera;
		this.bloke=pBloke;
			
	}
	
	public int getKoordenatuX() {
		return this.x;
	}
	
	public int getKoordenatuY() {
		return this.y;
	}
	
	public boolean getEgoera() {
		return this.egoera;
	}
	
	public Bloke getBloke() {
		return this.bloke;
	}
	
}
