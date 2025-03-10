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
	private boolean bomba=false;
	//private boolean pEgoera;
	private static final long serialVersionUID = 1L;
	
	// ERAIKITZAILEA //////////////////////////
	public GelaxkaBista(int pX, int pY,boolean pEgoera) {
		//setForeground(SystemColor.window);
		setBorder(new LineBorder(new Color(77, 112, 141)));
		setBackground(new Color(53, 77, 96));
		this.setBounds(pX*250, pY*200, 200, 200);
		this.irudia = new JLabel("");
		this.add(irudia);
		
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
	
	public void bombermanJarri(char pNorabide) {
		if (pNorabide=='S') {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitedown1.png")));
		} 
		else if (pNorabide=='W') {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteup1.png")));
		}
		else if (pNorabide=='A') {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteleft1.png")));
		}
		else if (pNorabide=='D') {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteright1.png")));
		}
		else {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitefront1.png")));
		}
	
	}
	

	public void bombermanKendu(){
		if(this.bomba==true) {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomb1.png")));
		}
		else {
			this.irudia.setIcon(null);
		}		
	}
	
	public void bombaJarri(){
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitewithbomb1.png")));
		this.bomba=true;
		System.out.println("Bomba jarri da");
	}
	
	public void suaJarri() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/kaBomb2.png")));
		
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/kaBomb5.png")));
		}
	
	
	public void elementuaKendu(){
		if (this.bomba==true) {
			bombaKendu();
		}
		else{
			this.irudia.setIcon(null);
		}

	}
	
	public void bombaKendu() {
		suaJarri();
		this.bomba=false;
		System.out.println("Bomba kendu da");
	}

	/*public void norabideBomberman() {
	}*/
}
