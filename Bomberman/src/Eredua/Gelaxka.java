package Eredua;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("deprecation")
public class Gelaxka extends Observable {
	//Atributuak
	private int x;
	private int y;
	private Bloke bloke;
	private Etsaia etsaia;
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
		bloke=BFactory.getNireBFactory().sortuBloke(pMota);
		setChanged();
		notifyObservers(pMota);
	
	}
	
	public void etsaiaGehitu() {
		etsaia=new Etsaia();
		setChanged();
		notifyObservers("Etsaia");
	
	}
	
	
	
// BOMBAren METODOAK ////////////////////////////////////////////
	
	public boolean getBomba() {
		return this.bomba instanceof Bomba;
	}	
	
	public void bombaJarri() {
		if(this.bomba==null) {
			bomba=new Bomba();
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
		bomba=null;
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
			if (this.bomba instanceof Bomba) {
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
