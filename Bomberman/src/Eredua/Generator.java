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
	
	public void sortuLabirintoa(String pMota ) {
		 egungoLabirintoa=LFactory.getNireLFactory().sortuLabirintoa(pMota);
	}
	
	public Labirintoa getLabirintoa() {
		return egungoLabirintoa;
	}
}
