package Eredua;

public class EtsaiaFactory {
	private static EtsaiaFactory nEFactory=null;
	
	private EtsaiaFactory() {
	}
	
	public static EtsaiaFactory getNireLFactory() {
		if (nEFactory == null) {
			nEFactory = new EtsaiaFactory();
		}
		return nEFactory;
	}
	
}
