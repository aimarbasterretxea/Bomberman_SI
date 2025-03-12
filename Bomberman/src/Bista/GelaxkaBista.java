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
	private boolean bombaDago=false;
	private static final long serialVersionUID = 1L;
	private static int pausuak=1;
	private static String aurrekoNorabidea="";
	// ERAIKITZAILEA //////////////////////////
	public GelaxkaBista(int pX, int pY,boolean pEgoera) {
		this.irudia = new JLabel("");
		this.add(irudia);
		this.setOpaque(false);
		
	}
	
	
	// METODOAK //////////////////////////
	public void blokeGogorra() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/hard5.png")));
	}
	
	public void blokeBiguna() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/soft4.png")));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Object[]) {
			Object[] obj = (Object[]) arg;
			if(obj[0].equals("BombaJarri")) {
				this.bombaJarri((int) obj[1]);
				
			}
		}
		if (arg.equals("BombaKendu")) {
			this.elementuaKendu();
			
		} else if (arg.equals("BombaJarri")) {
			this.bombaJarri(1);
			
			
		} else if(arg.equals("SuaJarri")) {
			this.suaJarri();
			
		} else if(arg.equals("SuaKendu")) {
			this.elementuaKendu();
		}
	}
	
	public void bombermanJarri(Character pNorabide) {
		String pNorabideChar=pNorabide.toString();
		String norabideBerria;
		if(bombaDago==false) {
			if (pNorabideChar.equals("W")) {
				norabideBerria="up";
			}
			else if (pNorabideChar.equals("S")) {
				if (pausuak>4) {
					pausuak=1;
				}
				norabideBerria="down";
			}
			else if (pNorabideChar.equals("A")) {
				norabideBerria="left";
			}
			else if (pNorabideChar.equals("D")) {
				norabideBerria="right";
			}
			else {
				norabideBerria="front";
			}
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/white"+norabideBerria+pausuak+".png")));
			
			if (aurrekoNorabidea.equals(norabideBerria)) {
				if (pausuak>4) {
					pausuak=1;
				}
				else {
					pausuak++;
				}
			}
			else {
				pausuak=1;
			}
			aurrekoNorabidea=norabideBerria;
		}
	
			}
	

	public void bombermanKendu(){
		if(this.bombaDago==true) {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomb1.png")));
		}
		else {
			this.irudia.setIcon(null);
		}		
	}
	
	public void bombaJarri(int kont){
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitewithbomb"+kont+".png")));
		this.bombaDago=true;
	}
	
	public void suaJarri() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/kaBomb5.png")));
	}
	
	
	public void elementuaKendu(){
		if (this.bombaDago==true) {
			
			bombaKendu();
		}
		else{
			this.irudia.setIcon(null);
		}

	}
	
	public void bombaKendu() {
		this.bombaDago=false;
	}

	/*public void norabideBomberman() {
	}*/
}
