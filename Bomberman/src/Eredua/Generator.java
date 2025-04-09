package Eredua;

public class Generator {
	
	private static Generator nireGenerator;
	private static Labirintoa egungoLabirintoa;
	
	private Generator() {};
	
	public static Generator getNireGenerator(){
		if(nireGenerator == null) {
			nireGenerator = new Generator(); 
		}
		return nireGenerator;
		}
	
	public void sortuLabirintoa(String pMota, String pBomberMota) {
		 egungoLabirintoa=LFactory.getNireLFactory().sortuLabirintoa(pMota, pBomberMota);
	}
	
	public Labirintoa getLabirintoa() {
		return egungoLabirintoa;
	}
}
