package Eredua;

import Bista.GelaxkaBista;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Gelaxka extends Observable {
	//Atributuak
	private int x;
	private int y;
	private Bloke bloke=null;
	private Bomba bomba=null;
	private Sua sua=null;
	/*private Timer timer=null;
	private int kont=3;*/
	
	//Eraikitzaileka
	public Gelaxka(int pX, int pY) {
		this.x=pX;
		this.y=pY;
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
	public Bomba getBomba() {
		return this.bomba;
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
	
	public void blokeGogorraGehitu() {
		bloke=new BlokeGogorra();
	}
	
	public void blokeBigunaGehitu() {
		bloke=new BlokeBiguna();
	}
	
	public void bombaJarri() {
		bomba=new Bomba(x, y);
		setChanged();
		notifyObservers("BombaJarri");	
	}
	
	public void bombaKendu() {
		bomba=null;
		setChanged();
		notifyObservers("BombaKendu");
	}
	
	public void suaJarri() {
		this.sua=new Sua(x,y);
		if(this.bloke instanceof BlokeBiguna || this.bloke==null) {
			this.bloke=null;
			setChanged();
			notifyObservers("SuaJarri");
		}
	}
			
	public void suaKendu() {
		if (this.sua!=null && (this.bloke instanceof BlokeBiguna || this.bloke==null)) {
			this.sua=null;
			setChanged();
			notifyObservers("SuaKendu");
			System.out.println("Sua kendu da");
		}
	}
}
