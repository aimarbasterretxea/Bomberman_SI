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
	private Bomba bomba;
	private Sua sua;
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
		this.sua=null;
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
	
	public Sua getSua() {
		return this.sua;
	}
	
	public Bloke getBloke() {
		return this.bloke;
	}

	
	//Metodoak
	public boolean hutsaDa(boolean inteligentea) {
		if (inteligentea) {
			if(this.sua!=null) {
				inteligentea=false;
			}
		}
		else {
			inteligentea=true;
		}
		if ((this.bloke==null&&this.bomba==null&&inteligentea)||Generator.getNireGenerator().getLabirintoa().getBomberman().getX()==this.x&&Generator.getNireGenerator().getLabirintoa().getBomberman().getY()==this.y) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void blokeaGehitu(String pMota) {
		bloke=BlokeFactory.getNireBFactory().sortuBloke(pMota);
		setChanged();
		notifyObservers(pMota);
	
	}
		
	
// BOMBAren METODOAK ////////////////////////////////////////////
	
	public boolean bombaDago() {
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
					bombaAldatu();
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
	public void bombaAldatu() {
		if(bombermanDago()) {
			setChanged();
			notifyObservers(new Object[]{"BombaAldatu",kont,Generator.getNireGenerator().getLabirintoa().getBomberman().getKolorea()});}
			else {
				setChanged();
				notifyObservers(new Object[]{"BombaJarri",kont});
			}
	}
	public boolean bombermanDago() {
		if(this.x==Generator.getNireGenerator().getLabirintoa().getBomberman().getX()&&this.y==Generator.getNireGenerator().getLabirintoa().getBomberman().getY()) {
			return true;
		}
		else {
			return false;
	}}
	public void bombaKendu() {
		eztanda=false;
		this.timerBomba.cancel();
		this.timerBomba=null;
		setChanged();
		notifyObservers("BombaKendu");
		bomba.kalkulatu(this.x, this.y);
		bomba=null;
	}
	
// SUAren METODOAK ////////////////////////////////////////////
	
	public boolean suaJarri() {	
		if(this.sua!=null&&this.timerSua!=null) {
			this.timerSua.cancel();
			this.timerSua=null;
		}
		
		this.sua=new Sua();
		
		this.bloke=null;
		if (this.bomba instanceof Bomba) {
			eztanda=true;
		}
		suaTimer();
		setChanged();
		notifyObservers("SuaJarri");			
					
		return this.sua!=null;
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
		this.sua=null;
		eztanda=false;
		setChanged();
		notifyObservers("SuaKendu");
		if(this.timerSua!=null) {
			this.timerSua.cancel();
		}
		this.timerSua=null;
	}
	
}