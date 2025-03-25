package Eredua;

public class BFactory {
	private static BFactory nBFactory=null;
	
	private BFactory() {
	}
	
	public static BFactory getNireBFactory() {
		if (nBFactory == null) {
			nBFactory = new BFactory();
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

