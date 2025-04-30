package Eredua;

public class BombermanFactory {
	private static BombermanFactory nireBombermanFactory;
	
	private BombermanFactory() {
	}
	
	public static BombermanFactory getBombermanFactory() {
		if (nireBombermanFactory == null) {
			nireBombermanFactory = new BombermanFactory();
		}
		return nireBombermanFactory;
	}
	
	public Bomberman sortuBomberman(String pMota) {
		Bomberman nireBomberman = null;
		if(pMota.equals("black")) {
			nireBomberman = new BombermanBeltza();
		}
		else if(pMota.equals("white")) {
			nireBomberman = new BombermanZuria();
		}
		else if (pMota.equals("random")) {
			nireBomberman = new BombermanRandom();
		}
		
		return nireBomberman;
		
	}
}
