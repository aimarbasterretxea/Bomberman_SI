package Eredua;

public class bombermanFactory {
	private bombermanFactory nirebombermanFactory;
	
	private bombermanFactory() {
	}
	
	public bombermanFactory getbombermanFactory() {
		if (nirebombermanFactory == null) {
			nirebombermanFactory = new bombermanFactory();
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
