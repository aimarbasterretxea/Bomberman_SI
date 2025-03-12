package Eredua;

import java.util.Observable;

public abstract class Labirintoa extends Observable{
	//Atributuak
	private static Labirintoa nireLabirintoa;
	private static Gelaxka[][] labirintoa;
	protected static int errenkada = 11;
	protected static int zutabea = 17;
	protected static Bomberman bomberman;
	protected static int blokeKop = 0;
	
	//Eraikitzailea
	public Labirintoa() {
		this.labirintoa=null;
		addObserver(Bista.LabirintoBista.getNireLabirintoBista());
	}
	
	//Geterrak
	public Gelaxka[][] getLabirintoa() { return labirintoa; }
	
	public Bomberman getBomberman() {
		return bomberman;
	}
	
	@SuppressWarnings("deprecation")
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
	
	public void bombaKendu(int pX, int pY) {
		boolean bizirik=true;
		boolean blokeApurtu=false;
		int[][] norabideak = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		  // Bombaren koordenatua
		for (int[] norabidea : norabideak) {
		    int berriaX = pX + norabidea[0];
		    int berriaY = pY + norabidea[1];
		    
		    if (berriaX>=0 && berriaX<=10 && berriaY>=0 && berriaY<=16) {
		    	blokeApurtu=this.bilatuGelaxka(berriaX, berriaY).suaJarri();
		    	if(blokeApurtu==true) {
		    		this.blokeKop--;
		    	}
		    	if(this.bomberman.getX()==berriaX && this.bomberman.getY()==berriaY) {
		    		bizirik=false;
		    	}
		    }
		}
		
		 blokeApurtu=this.bilatuGelaxka(pX,pY).suaJarri();
		 if(blokeApurtu==true) {
			 this.blokeKop--;
		 }
		 
		 if(this.bomberman.getX()==pX && this.bomberman.getY()==pY) {
			 bizirik=false;
		 }
		 
		 if(bizirik==false) {
			 Jokua.getJokua().amaituJokua(1);}
		 else if(this.blokeKop==0) {
			 Jokua.getJokua().amaituJokua(2);
		 }
	}
	
	public void suaKendu(int pX, int pY) {
		int[][] norabideak = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		// Bombaren koordenatua
		for (int[] norabidea : norabideak) {
		    int berriaX = pX + norabidea[0];
		    int berriaY = pY + norabidea[1];
		    
		    if (berriaX>=0 && berriaX<=10 && berriaY>=0 && berriaY<=16) {
		    this.bilatuGelaxka(berriaX, berriaY).suaKendu();}
		}
		 this.bilatuGelaxka(pX,pY).suaKendu();
	}
	
	public void bombaJarriDa(int pKop) {
		setChanged();
		notifyObservers(new Object[]{"BombaJarri",pKop});
	}
}
