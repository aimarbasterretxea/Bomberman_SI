package Eredua;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Bomba extends Observable {
	private int x;
	private int y;
	private int kont = 4;
	private Timer timer=null;
	
	public Bomba(int pX, int pY) {
		this.x=pX;
		this.y=pY;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				updateKont();
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	private void updateKont() {
		kont--;
		System.out.println("Kont: "+kont);
		if (kont == 0) {
			MatrizeClassic.getNireMatrizea().bombaKendu(x, y);
			
			
			//kont=4; // 3, 2, 1, explota
			timer.cancel();
		}
		
		}
	
	}


