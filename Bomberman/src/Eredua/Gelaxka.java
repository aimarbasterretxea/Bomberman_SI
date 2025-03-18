package Eredua;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Gelaxka extends Observable {
	//Atributuak
	private int x;
	private int y;
	private Bloke bloke=null;
	private boolean bomba;
	private boolean sua;
	private Timer timerBomba=null;
	private Timer timerSua=null;
	private int kont =1;
	private boolean eztanda=false;
	
	
	//Eraikitzaileka
	public Gelaxka(int pX, int pY) {
		this.x=pX;
		this.y=pY;
		this.bomba=false;
		this.sua=false;
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
		if (this.bloke==null&&this.bomba==false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void blokeGogorraGehitu() {
		bloke=new BlokeGogorra();
	}
	
	public void blokeBigunaGehitu() {
		bloke=new BlokeBiguna();
	}
	
	
	
// BOMBAren METODOAK ////////////////////////////////////////////
	
	public boolean getBomba() {
		return this.bomba;
	}	
	
	public void bombaJarri() {
		if(this.bomba==false) {
			bomba=true;
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
		bomba=false;
		setChanged();
		notifyObservers("BombaKendu");
		LabirintoaKlasikoa.getNireLabirintoKlasikoa().bombaKendu(this.x, this.y);
		
	}
	
// SUAren METODOAK ////////////////////////////////////////////
	
	public boolean suaJarri() {
		
		if(this.sua==true&&this.timerSua!=null) {
			this.timerSua.cancel();
			this.timerSua=null;
		}
		
		this.sua=true;
		boolean blokeBiguna=bloke instanceof BlokeBiguna;
		
		if((this.bloke instanceof BlokeBiguna || this.bloke==null)) {
			this.bloke=null;
			if (this.bomba==true) {
				eztanda=true;
			}
			else {
			suaTimer();
			setChanged();
			notifyObservers("SuaJarri");			
		}}
		
		return blokeBiguna;
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
		this.sua=false;
		setChanged();
		notifyObservers("SuaKendu");
		if(this.timerSua!=null) {
			this.timerSua.cancel();
		}
		this.timerSua=null;
	}
	
}
