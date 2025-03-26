package Eredua;

public class BlokeFactory {
	private static BlokeFactory nBFactory=null;
	
	private BlokeFactory() {
	}
	
	public static BlokeFactory getNireBFactory() {
		if (nBFactory == null) {
			nBFactory = new BlokeFactory();
		}
		return nBFactory;
	}
	public Bloke sortuBloke(String pMota) {
        Bloke nireBloke = null;
        if (pMota.equals("Biguna")) {
			nireBloke = new BlokeBiguna();
		}
		else if (pMota.equals("Gogorra")) {
			nireBloke = new BlokeGogorra();
		}
		return nireBloke;
	}
}

