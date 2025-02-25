package Eredua;
 
public class Matrizea {
		private Laukia[][] matrix;
		private static int errenkada = 11;
		private static int zutabea = 17;
		
		//eraiki classic
		
		//eraiki soft
		
		//eraiki empty
	private static Matrizea nireMatrizea;
	private Matrizea() {
		
	}
	
	public static Matrizea getMatrizea() {
		if (nireMatrizea == null) {
			nireMatrizea = new Matrizea();
		}
		return nireMatrizea;
	}
	
	public void matrizeaSortu(int pModo) {
		matrix = new Laukia[errenkada][zutabea];
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				
			}
		}
	}
}
