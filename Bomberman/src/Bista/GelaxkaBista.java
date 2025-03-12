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
	private static int w,a,s,d=1;
	// ERAIKITZAILEA //////////////////////////
	public GelaxkaBista(int pX, int pY,boolean pEgoera) {
		//setBorder(new LineBorder(new Color(77, 112, 141)));
		this.irudia = new JLabel("");
		this.add(irudia);
		this.setOpaque(false);
		
	}
	
	
	// METODOAK //////////////////////////
	public void blokeGogorra() {
		//this.setBackground(Color.BLACK);
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/hard5.png")));
		//this.pEgoera=false;
	}
	
	public void blokeBiguna() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/soft4.png")));
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
	
	public void bombermanJarri(Character pNorabide) {
		String pNorabideChar=pNorabide.toString();
	
		if (bombaDago==false) {
			if (pNorabideChar.equals("W")) {
				if(w==1) {
					a=1;
					s=1;
					d=1;
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteup1.png")));
					//img = getImg("/Irudiak/whiteup1.png");
					w++;	}
				else if(w==2) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteup2.png")));
					//img = getImg("/Irudiak/whiteup2.png");
					w++;	}
				else if(w==3) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteup3.png")));
					//img = getImg("/Irudiak/whiteup3.png");
					w++;	}
				else if(w==4) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteup4.png")));
				//	img = getImg("/Irudiak/whiteup4.png");
					w++;	}
				else if(w==5) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteup5.png")));
					//img = getImg("/Irudiak/whiteup5.png");
					w=1;	}
				else {
					w=1;}}
			else if (pNorabideChar.equals("S")) {
				
				if(s==1) {
					w=1;
					a=1;
					d=1;
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitedown1.png")));
					//img = getImg("/Irudiak/whitedown1.png");
					s++;	}
				else if(s==2) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitedown2.png")));
					//img = getImg("/Irudiak/whitedown2.png");
					s++;	}
				else if(s==3) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitedown3.png")));
					//img = getImg("/Irudiak/whitedown3.png");
					s++;	}
				else if(s==4) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitedown4.png")));
					//img = getImg("/Irudiak/whitedown4.png");
					s=1;	}
				else {
					s=1;}}
			else if (pNorabideChar.equals("A")) {
				w=1;
				s=1;
				d=1;
				if(a==1) {
					
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteleft1.png")));
					a++;	}
				else if(a==2) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteleft2.png")));
					a++;	}
				else if(a==3) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteleft3.png")));
					a++;}
				else if(a==4) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteleft4.png")));
					a++;
				}
				 if(a==5) {
						this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteleft5.png")));
						a=1;	}}
				else if (pNorabideChar.equals("D")) {
					w=1;
					s=1;
					a=1;
				 if(d==1) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteright1.png")));
					d++;	}
				else if(d==2) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteright2.png")));
					d++;	}
				else if(d==3) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteright3.png")));
					d++;	}
				else if(d==4) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteright4.png")));
					d++;	}
				else if(d==5) {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whiteright5.png")));
					d=1;	}
				else {
					d=1;}}
				else {
					this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitefront1.png")));}}	
			}
	

	public void bombermanKendu(){
		if(this.bombaDago==true) {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomb1.png")));
		}
		else {
			this.irudia.setIcon(null);
		}		
	}
	
	public void bombaJarri(){
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitewithbomb1.png")));
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
