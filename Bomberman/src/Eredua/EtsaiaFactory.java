package Eredua;

public class EtsaiaFactory {
	private static EtsaiaFactory nEFactory=null;
	
	private EtsaiaFactory() {
	}
	
	public static EtsaiaFactory getNireEFactory() {
		if (nEFactory == null) {
			nEFactory = new EtsaiaFactory();
		}
		return nEFactory;
	}
	public Etsaia sortuEtsaia(String pMota) {

		Etsaia nireEtsaia =null;
	 
		if (pMota.equals("Normala")) {
			nireEtsaia = new EtsaiaNormala();
		}
		else if (pMota.equals("Inteligente")) {
			nireEtsaia = new EtsaiaInteligentea();
		}
		return nireEtsaia;
	}
	
}
