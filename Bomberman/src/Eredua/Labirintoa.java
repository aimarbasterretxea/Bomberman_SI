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
	private static int errenkada = 11;
	private static int zutabea = 17;
	private static Bomberman bomberman;
	private static ArrayList<Etsaia> etsaiak = new ArrayList<Etsaia>();
	private static int blokeKop = 0;
	private Timer timerEtsaia;
	private static String pBomberMota;
	
	//Eraikitzailea
 	public Labirintoa(String pBomberMota) {
 		
 		labirintoa = new Gelaxka[errenkada][zutabea];
 		for (int i = 0; i < errenkada; i++) {
 			for (int j = 0; j < zutabea; j++) {
 				labirintoa[i][j]= new Gelaxka(i,j);
 			}
 		}
 		System.out.println("Labirintoa: Labirinto hutsa sortu da");
		//setChanged();
		//notifyObservers("Matrizea sortu da");
 		this.pBomberMota = pBomberMota;
 	}
 	
 	// Getterak ///////////////////////////////
 	
      public static void blokeKopEguneratu() {
		  blokeKop++;
	  }
      
      public static void gehituEtsaia(int i, int j) {
    	  etsaiak.add(new Etsaia(i,j));
      }
 	
      public static String getBombermanMota() {
    	  return pBomberMota;
      }
 	
 	
 	
 	
 	
 	public void sortuBomberman(String pMota) {
 		this.bomberman = BombermanFactory.getBombermanFactory().sortuBomberman(pMota);
 		setChanged();
 		notifyObservers(new Object[] {"BombermanSortu",pMota});
 		
 	}
	
	//Geterrak
	private Iterator<Etsaia> getItr() {
		return etsaiak.iterator();
	}
	
	public Gelaxka[][] getLabirintoa() { return labirintoa; }
	
	public Bomberman getBomberman() {
		return bomberman;
	}
	
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
		ArrayList<Etsaia> etsaiak = this.getEtsaiak(); // Suponiendo que tienes un método que devuelve la lista de enemigos
	    for (int i = 0; i < etsaiak.size(); i++) {
	        Etsaia etsaia = etsaiak.get(i);
	        int xZaharra = etsaia.getX();
	        int yZaharra = etsaia.getY();

	        // Calcular posiciones posibles
	        ArrayList<Character> norabidePosibleak = this.kalkulatuNorabidePosibleak(etsaia.getX(), etsaia.getY());
	        char norabide = etsaia.mugitu(norabidePosibleak);

	        if (this.bilatuGelaxka(etsaia.getX(), etsaia.getY()).getSua() != null) {
	            etsaiak.remove(i); // Eliminar el enemigo de la lista
	            i--; // Ajustar el índice debido a la eliminación
	            setChanged();
	            notifyObservers(new Object[]{"EtsaiaHil", xZaharra, yZaharra, norabide, false, xZaharra, yZaharra});
	        } else {
	            setChanged();
	            notifyObservers(new Object[]{"MoveEtsaia", etsaia.getX(), etsaia.getY(), norabide, true, xZaharra, yZaharra});

	            if (etsaia.getX() == this.bomberman.getX() && etsaia.getY() == this.bomberman.getY()) {
	                Jokua.getJokua().amaituJokua(1);
	            }
	        }
	    }
	}
	
	protected ArrayList<Character> kalkulatuNorabidePosibleak(int x, int y){
		ArrayList<Character> norabidePosibleak = new ArrayList<Character>();
		if (x-1>=0 && this.bilatuGelaxka(x-1, y).hutsaDa() && !this.etsaiaDago(x-1,y)) {
			norabidePosibleak.add('W');
		}
		if(x+1<errenkada && this.bilatuGelaxka(x+1, y).hutsaDa() && !this.etsaiaDago(x+1,y)) {
			norabidePosibleak.add('S');
		}
		if(y-1>=0 && this.bilatuGelaxka(x, y-1).hutsaDa() && !this.etsaiaDago(x,y-1)) {
			norabidePosibleak.add('A');
		}
		if(y+1<zutabea && this.bilatuGelaxka(x, y+1).hutsaDa() && !this.etsaiaDago(x,y+1)) {
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
	
	
	public void abisatuObservers(Object[] pArg) {
		setChanged();
        notifyObservers(pArg);
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
	
	public boolean etsaiaDago(int pX, int pY) {
		Iterator<Etsaia> itr = this.getItr();
		boolean badago=false;
		while (itr.hasNext() && !badago) {
			Etsaia etsaia = itr.next();
			if (etsaia.getX()==pX && etsaia.getY()==pY) {
				badago=true;
			}
		}
		return badago;
	}
}