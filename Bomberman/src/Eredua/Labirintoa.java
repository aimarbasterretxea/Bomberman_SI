package Eredua;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("deprecation")
public abstract class Labirintoa extends Observable{
	//Atributuak
	private static Gelaxka[][] labirintoa;
	protected static int errenkada = 11;
	protected static int zutabea = 17;
	protected static Bomberman bomberman;
	protected static ArrayList<Etsaia> etsaiak = new ArrayList<Etsaia>();
	protected static int blokeKop = 0;
	private Timer timerEtsaia;
	
	//Eraikitzailea
	public Labirintoa() {
		//labirintoa = new Gelaxka[errenkada][zutabea];
		Gelaxka[][] labirintoa= this.getLabirintoa();
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				labirintoa[i][j]= new Gelaxka(i,j);
			}
		}
		this.bomberman=new BombermanZuria();
		System.out.println("Labirintoa: Labirinto hutsa sortu da");
	}
	
	//Geterrak
	private Iterator<Etsaia> getItr() {
		return etsaiak.iterator();
	}
	
	public Gelaxka[][] getLabirintoa() { return labirintoa; }
	
	public Bomberman getBomberman() {
		return bomberman;
	}
	
	/*public  void labirintoOrokorraSortu() {
		labirintoa = new Gelaxka[errenkada][zutabea];
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				labirintoa[i][j]= new Gelaxka(i,j);
			}
		}
		this.bomberman=new BombermanZuria();
		setChanged();
		notifyObservers("Matrizea sortu da");
	}*/
	
	public ArrayList<Etsaia> getEtsaiak() {
		return etsaiak;
	}
	public abstract void labirintoaOsatu();
	
	public Gelaxka bilatuGelaxka(int x, int y) {
		return labirintoa[x][y];
	}
	
	public void mugituBomberman(char pKey) {
			bomberman.mugitu(pKey);
	}
	
	public void mugituEtsaiak() {
		Iterator<Etsaia> itr = this.getItr();
		while (itr.hasNext()) {
			Etsaia etsaia = itr.next();
			int xZaharra=etsaia.getX();
			int yZaharra=etsaia.getY();
			//calcular posiciones posibles
			ArrayList<Character> norabidePosibleak = this.kalkulatuNorabidePosibleak(etsaia.getX(), etsaia.getY());
			char norabide=etsaia.mugitu(norabidePosibleak);
			setChanged();
			notifyObservers(new Object[]{"MoveEtsaia",etsaia.getX(),etsaia.getY(),norabide,true,xZaharra,yZaharra});
		}
		
	}
	
	protected ArrayList<Character> kalkulatuNorabidePosibleak(int x, int y){
		ArrayList<Character> norabidePosibleak = new ArrayList<Character>();
		if (x-1>=0 && this.bilatuGelaxka(x-1, y).hutsaDa()) {
			norabidePosibleak.add('W');
		}
		if(x+1<errenkada && this.bilatuGelaxka(x+1, y).hutsaDa()) {
			norabidePosibleak.add('S');
		}
		if(y-1>=0 && this.bilatuGelaxka(x, y-1).hutsaDa()) {
			norabidePosibleak.add('A');
		}
		if(y+1<zutabea && this.bilatuGelaxka(x, y+1).hutsaDa()) {
			norabidePosibleak.add('D');
		}
		if(norabidePosibleak.isEmpty()) {
			norabidePosibleak.add(' ');
		}
		return norabidePosibleak;
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
	
	// ETSAIAren METODOAK ////////////////////////////////////////////
	protected void etsaiaTimer() {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				mugituEtsaiak();
			}	
		};
		this.timerEtsaia = new Timer();
		timerEtsaia.scheduleAtFixedRate(timerTask, 0, 1000);
	}
}