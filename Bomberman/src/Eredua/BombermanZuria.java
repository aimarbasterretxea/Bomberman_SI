package Eredua;
import java.util.Timer;
import java.util.TimerTask;

public class BombermanZuria extends Bomberman{
	
	private int kont=0;
	

	public BombermanZuria() {
		super();
		this.bombaKop=10;
	}
	
	public void bombermanHil() {
		
	}
	
	@Override  
	public void bombaJarri() {
		if (LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.getX(), this.getY()).getBomba() == null && bombaKop > 0) {
			LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.getX(), this.getY()).bombaJarri();
			bombaKop--;
			setChanged();
			notifyObservers(new Object[]{"BombaJarri",this.getX(),this.getY()});	
			}	
		super.eguneratuBombaKop();
	}
}  

