package Bista;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class Laukia_Bista extends JPanel implements Observer {
	private int x;
	private int y;
	//private boolean pEgoera;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public Laukia_Bista(int pX, int pY,boolean pEgoera) {
		setForeground(SystemColor.window);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(SystemColor.activeCaption);
		this.setBounds(pX*50, pY*50, 100, 100);
	}
	public void blokeGogorra() {
		this.setBackground(Color.RED);
		//this.pEgoera=false;
	}
	public void blokeBiguna() {
		this.setBackground(Color.GREEN);
		//this.pEgoera=false;
	}
	@Override
	public void update(Observable o, Object arg) {
		//Object[] obj = (Object[]) arg;
		if (arg.equals("BombaKendu")) {
			//int i = (int) obj[1];
			//int j = (int) obj[2];
			this.bombaKendu();
		}else if (arg.equals("BombaJarri")) {
			this.bombaJarri();
		}else if(arg.equals("SuaJarri")) {
			this.suaJarri();
		}else if(arg.equals("SuaKendu")) {
			this.bombaKendu();
		}
	}
	public void bombermanJarri(){
		this.setBackground(Color.yellow);
	}
	
	public void bombermanKendu(){
		if (!(this.getBackground()==Color.BLACK)) {
			this.setBackground(SystemColor.activeCaption);
		}
	}
	public void bombaJarri(){
		this.setBackground(Color.BLACK);
		System.out.println("Bomba jarri daNEGRO");
	}
	public void bombaKendu(){
		this.setBackground(SystemColor.activeCaption);
	}
	
	public void suaJarri() {
		this.setBackground(Color.ORANGE);
	}
	/*public void norabideBomberman() {
	}*/
}
