package Bista;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Laukia_Bista extends JPanel {
	private int x;
	private int y;
	private boolean pEgoera;

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
	}
	public void blokeBiguna() {
		this.setBackground(Color.GREEN);
	}
}
