package Eredua;
 
public class Matrizea {
	private Laukia[][] matrix;
	private static int errenkada = 11;
	private static int zutabea = 17;
	//private laukiZerrenda Iterator<Laukia>;
		
		//eraiki classic
		
		//eraiki soft
		
		//eraiki empty
	private static Matrizea nireMatrizea;
	protected Matrizea() {
		
	}
	
	public static Matrizea getNireMatrizea() {
		if (nireMatrizea == null) {
			nireMatrizea = new Matrizea();
		}
		return nireMatrizea;
	}
	
	public void matrizeaOrokorraSortu(int pModo) {
		matrix = new Laukia[errenkada][zutabea];
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				matrix[i][j]= new Laukia(i,j,false,null);
			}
		}
	}
	
	public Laukia bilatuLaukia(int x, int y) {
		return matrix[x][y];
	}
	
	
}
