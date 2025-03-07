package Eredua;

import Bista.GelaxkaBista;

import Bista.LabirintoBista;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.EventQueue;
import java.util.Observable;


public abstract class Labirintoa extends Observable{
	//Atributuak
	private static Labirintoa nireLabirintoa;
	private static Gelaxka[][] labirintoa;
	protected static int errenkada = 11;
	protected static int zutabea = 17;
	protected static Bomberman bomberman;
	
	//Eraikitzailea
	public Labirintoa() {
		this.labirintoa=null;
		addObserver(LabirintoBista.getNireLabirintoBista());
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
				//Bista.Matrize_Bista.gehituLaukia(new Bista.Laukia_Bista(i, j, false));
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
			//System.out.println("MugituBombermanMatrizea");
	}
	
	public void bombaKendu(int pX, int pY) {
		this.bilatuGelaxka(pX, pY).bombaKendu();
		int[][] norabideak = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		  // Bombaren koordenatua

		for (int[] norabidea : norabideak) {
		    int berriaX = pX + norabidea[0];
		    int berriaY = pY + norabidea[1];
		    
		    if (berriaX>=0 && berriaX<=10 && berriaY>=0 && berriaY<=16)
		    this.bilatuGelaxka(berriaX, berriaY).suaJarri();
		}
		 this.bilatuGelaxka(pX,pY).suaJarri();
	}
	
	public void suaKendu(int pX, int pY) {
		this.bilatuGelaxka(pX, pY).suaKendu();
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
}
