package Eredua;

public class LFactory {
	private static LFactory nLFactory=null;
	
	private LFactory() {
	}
	
	public static LFactory getNireLFactory() {
		if (nLFactory == null) {
			nLFactory = new LFactory();
		}
		return nLFactory;
	}
	public Labirintoa sortuLabirintoa(String pMota) {
    	System.out.println("LFactory: Sortu labirintoa sartu da");
    	System.out.println(pMota);

		Labirintoa nireLabirintoa =null;
     
		if (pMota.equals("Klasikoa")) {
        	System.out.println("LFactory: Klasikoa sortu da");
        	nireLabirintoa = new LabirintoaKlasikoa();
		}
		else if (pMota.equals("Biguna")) {
			//nireLabirintoa = new LabirintoaBiguna();
		}
		else if (pMota.equals("Hutsa")) {
			//nireLabirintoa = new LabirintoaHutsa();
		}
		return nireLabirintoa;
	}
}
