package Bista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

public class GelaxkaBista extends JPanel implements Observer {
	
	// ATRIBUTUAK //////////////////////////
	private int x;
	private int y;
	private JLabel irudia;
	//private boolean pEgoera;
	private static final long serialVersionUID = 1L;
	
	// ERAIKITZAILEA //////////////////////////
	public GelaxkaBista(int pX, int pY,boolean pEgoera) {
		//setForeground(SystemColor.window);
		setBorder(new LineBorder(new Color(77, 112, 141)));
		setBackground(new Color(53, 77, 96));
		this.setBounds(pX*300, pY*300, 300, 300);
		this.irudia = new JLabel("");
		this.add(irudia);
		irudia.resize(300,300);
		
	}
	
	
	// METODOAK //////////////////////////
	public void blokeGogorra() {
		//this.setBackground(Color.BLACK);
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/hard1.png")));
		//this.pEgoera=false;
	}
	
	public void blokeBiguna() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/soft1.png")));
		//this.pEgoera=false;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//Object[] obj = (Object[]) arg;
		if (arg.equals("BombaKendu")) {
			//int i = (int) obj[1];
			//int j = (int) obj[2];
			this.elementuaKendu();
			
		} else if (arg.equals("BombaJarri")) {
			this.bombaJarri();
			
		} else if(arg.equals("SuaJarri")) {
			this.suaJarri();
			
		} else if(arg.equals("SuaKendu")) {
			this.elementuaKendu();
		}
	}
	
	public void bombermanJarri(){
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomber1.png")));
	}
	
	public void bombermanKendu(){
		if (!(this.irudia.equals(LabirintoBista.class.getResource("/irudiak/bomb1.png")))) {
			this.irudia.setIcon(null);
		}
	}
	
	public void bombaJarri(){
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomb1.png")));
		System.out.println("Bomba jarri da");
	}
	
	public void suaJarri() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/kaBomb5.png")));
	}
	
	public void elementuaKendu(){
		this.irudia.setIcon(null);
	}

	/*public void norabideBomberman() {
	}*/
}
