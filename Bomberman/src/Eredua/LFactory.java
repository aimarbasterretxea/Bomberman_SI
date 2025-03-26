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
        	nireLabirintoa = LabirintoaKlasikoa.getNireLabirintoKlasikoa();
		}
		else if (pMota.equals("Biguna")) {
			nireLabirintoa = LabirintoaBiguna.getNireLabirintoaBiguna();
		}
		else if (pMota.equals("Hutsa")) {
			nireLabirintoa = LabirintoaHutsa.getNireLabirintoaHutsa();
		}
		return nireLabirintoa;
	}
}
