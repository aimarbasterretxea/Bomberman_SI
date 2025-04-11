package Eredua;

public class BombermanFactory {
	private static BombermanFactory nirebombermanFactory;
	
	private BombermanFactory() {
	}
	
	public static BombermanFactory getBombermanFactory() {
		if (nirebombermanFactory == null) {
			nirebombermanFactory = new BombermanFactory();
		}
		return nirebombermanFactory;
	}
	
	public Bomberman sortuBomberman(String pMota) {
		Bomberman nireBomberman = null;
		if(pMota.equals("black")) {
			nireBomberman = new BombermanBeltza();
		}
		else if(pMota.equals("white")) {
			nireBomberman = new BombermanZuria();
		}
		else if (pMota.equals("Random")) {
			nireBomberman = new BombermanRandom();
		}
		
		return nireBomberman;
		
	}
}
