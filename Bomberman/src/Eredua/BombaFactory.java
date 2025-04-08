package Eredua;

public class BombaFactory {
	private static BombaFactory nBFactory=null;
	
	private BombaFactory() {
	}
	
	public static BombaFactory getNireBFactory() {
		if (nBFactory == null) {
			nBFactory = new BombaFactory();
		}
		return nBFactory;
	}
	
	public Bomba sortuBomba(String pMota) {
        Bomba nireBomba = null;
        if (pMota.equals("Txikia")) {
			nireBomba = new BombaHandia();
		}
		else if (pMota.equals("Handia")) {
			nireBomba = new BombaHandia();
		}
		return nireBomba;
	}
}

