package Eredua;

import Bista.Laukia_Bista;
import java.util.Observer;
import java.util.Observable;


public abstract class Matrizea {
	
	private static Laukia[][] matrix;
	protected static int errenkada = 11;
	protected static int zutabea = 17;
	//private laukiZerrenda Iterator<Laukia>;
		
		//eraiki classic
		
		//eraiki soft
		
		//eraiki empty
	public Matrizea() {
		this.matrix=null;
	}
	
	
	
	public static void matrizeaOrokorraSortu() {
		matrix = new Laukia[errenkada][zutabea];
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				matrix[i][j]= new Laukia(i,j,false,null);
				Bista.Matrize_Bista.gehituLaukia(new Bista.Laukia_Bista(i, j, false));
			}
		}
	}
	public abstract void matrizeaOsatu();
	
	public Laukia bilatuLaukia(int x, int y) {
		return matrix[x][y];
	}

	public Laukia[][] getMatrix() { return matrix; }

	
	
	
}
