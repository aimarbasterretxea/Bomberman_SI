package Eredua;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("deprecation")
public class Gelaxka extends Observable {
	//Atributuak
	private int x;
	private int y;
	private Bloke bloke;
	private Bomba bomba;
	private boolean sua;
	private Timer timerBomba;
	private Timer timerSua;
	private int kont;
	private boolean eztanda;
	
	
	//Eraikitzaileka
	public Gelaxka(int pX, int pY) {
		this.x=pX;
		this.y=pY;
		this.bloke=null;
		this.bomba=null;
		this.sua=false;
		this.timerBomba=null;
		this.timerSua=null;
		this.kont=1;
		this.eztanda=false;
	}

	//Geterrak
	public int getKoordenatuX() {
		return this.x;
	}
	
	public int getKoordenatuY() {
		return this.y;
	}
	
	public boolean getSua() {
		return this.sua;
	}
	
	public Bloke getBloke() {
		return this.bloke;
	}

	
	//Metodoak
	public boolean hutsaDa() {
		if (this.bloke==null&&this.bomba==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void blokeaGehitu(String pMota) {
		bloke=BlokeFactory.getNireBFactory().sortuBloke(pMota);
		setChanged();
		notifyObservers("Gogorra");
	
	}
		
	
// BOMBAren METODOAK ////////////////////////////////////////////
	
	public boolean getBomba() {
		return this.bomba instanceof Bomba;
	}	
	
	public void bombaJarri(String pMota) {
		if(this.bomba==null) {
			bomba=BombaFactory.getNireBFactory().sortuBomba(pMota);
			bombaTimer();
			setChanged();
			notifyObservers("BombaJarri");	
		}
	}
	
	private void bombaTimer() {
		TimerTask timerTask = new TimerTask() {
			int azpiKont=0;
			@Override
			public void run() {
				azpiKont++;
				if(kont<4&&!eztanda) {
					setChanged();
					notifyObservers(new Object[]{"BombaJarri",kont});
					if (azpiKont==2) {
					kont++;
					azpiKont=0;
					}
				}
				else {
					kont=1;
					bombaKendu();
					
				}
			}
			
		};
		this.timerBomba = new Timer();
		timerBomba.scheduleAtFixedRate(timerTask, 0, 500);
	}
	
	public void bombaKendu() {
		eztanda=false;
		this.timerBomba.cancel();
		this.timerBomba=null;
		setChanged();
		notifyObservers("BombaKendu");
		bomba.kalkulatuKoordenatuak(this.x, this.y);
		bomba=null;
	}
	
// SUAren METODOAK ////////////////////////////////////////////
	
	public boolean suaJarri() {
		boolean sua=false;
		if(this.sua==true&&this.timerSua!=null) {
			this.timerSua.cancel();
			this.timerSua=null;
		}
		
		this.sua=true;
		boolean blokeBiguna=bloke instanceof BlokeBiguna;
		
		if((this.bloke instanceof BlokeBiguna || this.bloke==null)) {
			this.bloke=null;
			if (this.bomba instanceof Bomba) {
				eztanda=true;
				
			} 
				
				suaTimer();
				setChanged();
				notifyObservers("SuaJarri");			
				
		}
		
		return this.sua;
	}
	
	private void suaTimer() {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				suaKendu();
			}
			
		};
		this.timerSua = new Timer();
		timerSua.scheduleAtFixedRate(timerTask, 2000, 2000);
	}
	
	public void suaKendu() {
	    System.out.println("Sua kendu da: (" + this.x + "," + this.y + ")");
		this.sua=false;
		eztanda=false;
		setChanged();
		notifyObservers("SuaKendu");
		if(this.timerSua!=null) {
			this.timerSua.cancel();
		}
		this.timerSua=null;
	}
	
}
