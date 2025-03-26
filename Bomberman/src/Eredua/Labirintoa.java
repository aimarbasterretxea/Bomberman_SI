package Eredua;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@SuppressWarnings("deprecation")
public abstract class Labirintoa extends Observable{
	//Atributuak
	private static Gelaxka[][] labirintoa;
	protected static int errenkada = 11;
	protected static int zutabea = 17;
	protected static Bomberman bomberman;
	protected static int blokeKop = 0;
	protected static int etsaiKop = 0;
	
	//Eraikitzailea
	public Labirintoa() {
		this.labirintoa=null;
		//addObserver(Bista.LabirintoBista.getNireLabirintoBista());
	}
	
	//Geterrak
	public Gelaxka[][] getLabirintoa() { return labirintoa; }
	
	public Bomberman getBomberman() {
		return bomberman;
	}
	
	public  void labirintoOrokorraSortu() {
		labirintoa = new Gelaxka[errenkada][zutabea];
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				labirintoa[i][j]= new Gelaxka(i,j);
			}
		}
		this.bomberman=new BombermanZuria();
		setChanged();
		notifyObservers("Matrizea sortu da");
	}
	
	public abstract void labirintoaOsatu();
	
	public Gelaxka bilatuGelaxka(int x, int y) {
		return labirintoa[x][y];
	}
	
	public void mugituBomberman(char pKey) {
			bomberman.mugitu(pKey);
	}

	public void bombaKendu(ArrayList<int[]> sutea) {
	    boolean bizirik = true;

	    for (int[] pos : sutea) {
	        int x = pos[0];
	        int y = pos[1];

	        if (this.bilatuGelaxka(x, y).suaJarri()) {
	            this.blokeKop--;
	        }
	        if (this.bomberman.getX() == x && this.bomberman.getY() == y) {
	            bizirik = false;
	        }
	    }

	    if (!bizirik) {
	        Jokua.getJokua().amaituJokua(1);
	    } else if (this.blokeKop == 0) {
	        Jokua.getJokua().amaituJokua(2);
	    }
	}
	
	public void bombaJarriDa(int pKop) {
		setChanged();
		notifyObservers(new Object[]{"BombaJarri",pKop});
	}
	
	public void setChanged(String pMezua, int pX, int pY, char pC, boolean pEgia) {
		setChanged();
        notifyObservers(new Object[]{pMezua, pX, pY, pC,pEgia});
	}
}
