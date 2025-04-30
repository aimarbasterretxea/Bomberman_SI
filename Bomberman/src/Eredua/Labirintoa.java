package Eredua;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;
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
	private int etsaiaDelay=1;
	private Timer timerEtsaia;
	
	//Eraikitzailea
 	protected Labirintoa() {
 		
 		labirintoa = new Gelaxka[errenkada][zutabea];
 		
 		for (int i = 0; i < errenkada; i++) {
 			for (int j = 0; j < zutabea; j++) {
 				labirintoa[i][j]= new Gelaxka(i,j);
 			}
 		}
 	}
 	 
	public abstract void labirintoaOsatu(String pBomberMota, String pEtsaiaMota);

 	// Getterak ///////////////////////////////
	private Iterator<Etsaia> getItr() {
		return etsaiak.iterator();
	}
		
	public Bomberman getBomberman() {
		return bomberman;
	}
	
	public ArrayList<Etsaia> getEtsaiak() {
		return etsaiak;
	}
	
	//Metodoak////////////////////////////////
	public void abisatuObservers(Object[] pArg) {
		setChanged();
        notifyObservers(pArg);
	}
	
	public static void blokeKopEguneratu() {
		blokeKop++;
	}
	
	public Gelaxka bilatuGelaxka(int pX, int pY) {
		return labirintoa[pX][pY];
	}
    
	//BOMBERMANren METODOAK////////////////////////////////////////	
 	public void sortuBomberman(String pMota) {
 		int bombaKop;
 		this.bomberman = BombermanFactory.getBombermanFactory().sortuBomberman(pMota);
 		if (pMota.equals("white")) {
 			bombaKop=10;
 			}
 		else {
 			bombaKop=1;
 			}
 		setChanged();
 		notifyObservers(new Object[] {"BombermanSortu",pMota,bombaKop});
 		
 	}
	
	public void mugituBomberman(String pNorabidea) {
		bomberman.mugitu(pNorabidea,this.bilatuGelaxka(bomberman.getX(), bomberman.getY()).bombaDago());
	}
	
	//ETSAIAren METODOAK////////////////////////////////////////
	public static void gehituEtsaia(int i, int j,String pMota) {
		Etsaia etsaia = EtsaiaFactory.getNireEFactory().sortuEtsaia(pMota);
		etsaiak.add(etsaia);
		etsaia.setKoordenatuak(i, j);
	}
	
	public void mugituEtsaiak() {
	    char norabide = ' ';
	    ArrayList<Etsaia> etsaiak = this.getEtsaiak();

	    for (int i = 0; i < etsaiak.size(); i++) {
	        Etsaia etsaia = etsaiak.get(i);
	        int xZaharra = etsaia.getX();
	        int yZaharra = etsaia.getY();

	        // Atsedenik ez badago eta Bomberman bizirik badago, etsaia mugitzen da
	        if (etsaiaDelay == 0 && this.bomberman.getBizirik()) {
	            ArrayList<Character> norabidePosibleak = this.kalkulatuNorabidePosibleak(etsaia.getX(), etsaia.getY());
	            norabide = etsaia.mugitu(norabidePosibleak, this.bomberman.getX(), this.bomberman.getY());
	        }

	        int xBerria = etsaia.getX();
	        int yBerria = etsaia.getY();

	        // Sua duen gelaxkan sartuz gero, etsaia hil egiten da
	        if (this.bilatuGelaxka(xBerria, yBerria).getSua() != null) {
	            etsaiak.remove(i);
	            i--;
	            setChanged();
	            notifyObservers(new Object[]{"EtsaiaHil", xZaharra, yZaharra});
	            if (etsaiak.isEmpty()) {
	                Jokua.getJokua().amaituJokua(2, new Object[]{this.bomberman.getX(), this.bomberman.getY(), this.bomberman.getKolorea()});
	            }
	            continue; // Etsaia hil da, ez da beharrezkoa jarraitzea
	        }

	        // Etsaia Bombermanekin talka egiten badu
	        if (xBerria == this.bomberman.getX() && yBerria == this.bomberman.getY()) {
	            this.bomberman.setBizirik(false);
	            Jokua.getJokua().amaituJokua(1, new Object[]{this.bomberman.getX(), this.bomberman.getY(), this.bomberman.getKolorea()});
	        }

	        // Etsaia bizirik badago, mugimenduaren berri eman
	        setChanged();
	        notifyObservers(new Object[]{"MoveEtsaia", xBerria, yBerria, norabide, true, xZaharra, yZaharra,etsaia instanceof EtsaiaInteligentea});
	    }

	    etsaiaDelay = 0;
	}


	
	public ArrayList<Character> kalkulatuNorabidePosibleak(int x, int y){
		ArrayList<Character> norabidePosibleak = new ArrayList<Character>();
		boolean intelijentea=this.etsaiak.get(0) instanceof EtsaiaInteligentea;
		//boolean intelijentea=true;
		if (x-1>=0 && this.bilatuGelaxka(x-1, y).hutsaDa(intelijentea) && !this.etsaiaDago(x-1,y)) {
			norabidePosibleak.add('W');
		}
		if(x+1<errenkada && this.bilatuGelaxka(x+1, y).hutsaDa(intelijentea) && !this.etsaiaDago(x+1,y)) {
			norabidePosibleak.add('S');
		}
		if(y-1>=0 && this.bilatuGelaxka(x, y-1).hutsaDa(intelijentea) && !this.etsaiaDago(x,y-1)) {
			norabidePosibleak.add('A');
		}
		if(y+1<zutabea && this.bilatuGelaxka(x, y+1).hutsaDa(intelijentea) && !this.etsaiaDago(x,y+1) ) {
			norabidePosibleak.add('D');
		}
		if(norabidePosibleak.isEmpty()) {
			norabidePosibleak.add(' ');
		}
		return norabidePosibleak;
	}

	public void etsaiaTimer() {
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
	
	// SUAren METODOAK ////////////////////////////////////////////
	public void bombaKendu(ArrayList<int[]> sutea) {
	    boolean bizirik = true;
	    int size = etsaiak.size();
	    for (int[] pos : sutea) {
	        int x = pos[0];
	        int y = pos[1];

	        if (this.bilatuGelaxka(x, y).suaJarri()) {
	            this.blokeKop--;
	        }
	        if (this.bomberman.getX() == x && this.bomberman.getY() == y) {
	            bizirik = false;
	        }
	        
	        if (this.etsaiaDago(x, y)) {
	        	for (int i=0; i<size; i++) {
	        		Etsaia etsaia= etsaiak.get(i);
	        		if(etsaia.getX() == x && etsaia.getY() == y) {
	        			this.etsaiak.remove(i);
	        			size--;
	        			if(etsaiak.isEmpty()|| size==0) {
	        				Jokua.getJokua().amaituJokua(2,new Object[] {this.bomberman.getX(), this.bomberman.getY(),this.bomberman.getKolorea()});
	        			}
	        		}
	        	}	
	        }
	    }

	    if (!bizirik) {
	        Jokua.getJokua().amaituJokua(1,new Object[] {this.bomberman.getX(), this.bomberman.getY(),this.bomberman.getKolorea()});
	    } else if (this.blokeKop == 0) {
	        Jokua.getJokua().amaituJokua(2,new Object[] {this.bomberman.getX(), this.bomberman.getY(),this.bomberman.getKolorea()});
	    }
	}
	public Object[] biderikMotzenaKalkulatu(int xEtsaia, int yEtsaia, int pLuzera, Character lehenNorabidea, boolean[][] bisitatuak) {
	    if (this.bomberman.getX() == xEtsaia && this.bomberman.getY() == yEtsaia) {
	        return new Object[]{lehenNorabidea, pLuzera};
	    }
	    if (bisitatuak[xEtsaia][yEtsaia]) {
	        return new Object[]{' ', Integer.MAX_VALUE};
	    }
	    bisitatuak[xEtsaia][yEtsaia] = true;
	    ArrayList<Character> aukerak = this.kalkulatuNorabidePosibleak(xEtsaia, yEtsaia);
	    if (aukerak.isEmpty()) {
	        return new Object[]{' ', Integer.MAX_VALUE}; 
	    }
	    Character norabiderikHoberena = ' ';
	    int biderikMotzena = Integer.MAX_VALUE;

	    for (Character norabidea : aukerak) {
	        int lagX = xEtsaia, lagY = yEtsaia;
	        switch (norabidea) {
	            case 'W': 
	            	lagX--;
	            	break;
	            case 'A':
	            	lagY--;
	            	break;
	            case 'S':
	            	lagX++;
	            	break;
	            case 'D':
	            	lagY++;
	            	break;
	        }
	        Object[] emaitza = this.biderikMotzenaKalkulatu(lagX, lagY, pLuzera + 1, 
	                                                       lehenNorabidea == ' ' ? norabidea : lehenNorabidea,
	                                                       bisitatuak);
	        int emaitzaBideLuzera = (int) emaitza[1];
	        if (emaitzaBideLuzera < biderikMotzena) {
	            biderikMotzena = emaitzaBideLuzera;
	            norabiderikHoberena = (Character) emaitza[0];
	        }
	    }
	    bisitatuak[xEtsaia][yEtsaia] = false;

	    return new Object[]{norabiderikHoberena, biderikMotzena};
	}
}