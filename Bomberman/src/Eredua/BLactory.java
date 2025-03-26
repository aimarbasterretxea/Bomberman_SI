package Eredua;

public class BLactory {
	private static BLactory nBFactory=null;
	
	private BLactory() {
	}
	
	public static BLactory getNireBFactory() {
		if (nBFactory == null) {
			nBFactory = new BLactory();
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

