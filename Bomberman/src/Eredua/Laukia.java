package Eredua;

public class Laukia {
	private int x;
	private int y;
	private boolean hutsaDa;
	private Bloke bloke;
	private Bomba bomba;
	
	public Laukia(int pX, int pY, boolean pHutsaDa, Bloke pBloke) {
		this.x=pX;
		this.y=pY;
		this.hutsaDa=pHutsaDa;
		this.bloke=pBloke;
			
	}
	
	public int getKoordenatuX() {
		return this.x;
	}
	
	public int getKoordenatuY() {
		return this.y;
	}
	
	public boolean getHutsaDa() {
		return this.hutsaDa;
	}
	
	public Bloke getBloke() {
		return this.bloke;
	}
	
}
