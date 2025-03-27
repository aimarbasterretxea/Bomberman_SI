package Eredua;

public class LFactory {
	private static LFactory nLFactory=null;
	
	private LFactory() {
	}
	
	public static LFactory getNireBFactory() {
		if (nLFactory == null) {
			nLFactory = new LFactory();
		}
		return nLFactory;
	}
	public Labirintoa sortuLabirintoa(String pMota) {
		Labirintoa nireLabirintoa = null;
        if (pMota.equals("Klasikoa")) {
        	nireLabirintoa = new LabirintoaKlasikoa();
		}
		else if (pMota.equals("Biguna")) {
			nireLabirintoa = new LabirintoaBiguna();
		}
		else if (pMota.equals("Hutsa")) {
			nireLabirintoa = new LabirintoaHutsa();
		}
		return nireLabirintoa;
	}
}
