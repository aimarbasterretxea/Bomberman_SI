package Bista;

import javax.swing.JPanel;

public class Laukia_Bista extends JPanel {
	private int x;
	private int y;
	private boolean pEgoera;

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	public Laukia_Bista(int pX, int pY,boolean pEgoera) {
		this.setBounds(pX*50, pY*50, 50, 50);
	}
 
}
