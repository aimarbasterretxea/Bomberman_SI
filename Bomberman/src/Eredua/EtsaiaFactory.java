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
		System.out.println("EFactory: Sortu etsaia sartu da");
		System.out.println(pMota);

		Etsaia nireEtsaia =null;
	 
		if (pMota.equals("Normala")) {
			System.out.println("EFactory: Etsaia sortu da");
			nireEtsaia = new Etsaia();
		}
		
		return nireEtsaia;
	}
	
}
