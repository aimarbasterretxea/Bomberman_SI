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
		this.setBounds(pX*50, pY*50, 50, 50);
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
		// TODO Auto-generated method stub
		
	}
}
