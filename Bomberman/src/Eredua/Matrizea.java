package Eredua;

import Bista.Laukia_Bista;
import Bista.Matrize_Bista;

import java.util.Observer;
import java.awt.EventQueue;
import java.util.Observable;


public abstract class Matrizea extends Observable{
	private static Matrizea nireMatrizea;
	private static Laukia[][] matrix;
	protected static int errenkada = 11;
	protected static int zutabea = 17;
	//private laukiZerrenda Iterator<Laukia>;
		
		//eraiki classic
		
		//eraiki soft
		
		//eraiki empty
	public Matrizea() {
		this.matrix=null;
		addObserver(Matrize_Bista.getNireMatrizea());
	}
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Matrize_Bista frame = Matrize_Bista.getNireMatrizea();
                    MatrizeClassic matrizeKlasikoa = MatrizeClassic.getNireMatrizea();
                    matrizeKlasikoa.matrizeaOrokorraSortu();
                    matrizeKlasikoa.matrizeaOsatu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });}
	
	@SuppressWarnings("deprecation")
	public  void matrizeaOrokorraSortu() {
		matrix = new Laukia[errenkada][zutabea];
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				matrix[i][j]= new Laukia(i,j,false,null);
				
				//Bista.Matrize_Bista.gehituLaukia(new Bista.Laukia_Bista(i, j, false));
			}
			
		}
		setChanged();
		notifyObservers("Matrizea sortu da");
	}
	public abstract void matrizeaOsatu();
	
	public Laukia bilatuLaukia(int x, int y) {
		return matrix[x][y];
	}

	public Laukia[][] getMatrix() { return matrix; }

	
	
	
}
