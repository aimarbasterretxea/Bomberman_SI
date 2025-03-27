package Eredua;

public class BombermanFactory {
	private BombermanFactory nirebombermanFactory;
	
	private BombermanFactory() {
	}
	
	public BombermanFactory getbombermanFactory() {
		if (nirebombermanFactory == null) {
			nirebombermanFactory = new BombermanFactory();
		}
		return nirebombermanFactory;
	}
	
	public Bomberman sortuBomberman(String pMota) {
		Bomberman nireBomberman = null;
		if(pMota.equals("BombermanBeltza")) {
			nireBomberman = new BombermanBeltza();
		}
		else if(pMota.equals("BombermanGorria")) {
			nireBomberman = new BombermanZuria();
		}
		
		return nireBomberman;
		
	}
}
