package Bista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class GelaxkaBista extends JPanel implements Observer {
	
	// ATRIBUTUAK //////////////////////////
	private JLabel irudia;
	private boolean bombaDago=false;
	private boolean bombermanDago=false;
	private static final long serialVersionUID = 1L;
	private static int pausuak=1;
	private int bombaDenbora=1;
	private static String aurrekoNorabidea="";
	private String norabideBerria="";
	private boolean etsaiaDago;
	// ERAIKITZAILEA //////////////////////////
	public GelaxkaBista(boolean pEgoera) {
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
	private void etsaia() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/doria1.png")));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Object[]) {
			Object[] obj = (Object[]) arg;
			if(obj[0].equals("BombaJarri")) {
				this.bombaJarri((int) obj[1]);
				
			}
		}
		else {
		if (arg.equals("BombaKendu")) {
			this.elementuaKendu();
			
		} else if (arg.equals("BombaJarri")) {
			this.bombaJarri(bombaDenbora);
			
			
		} else if(arg.equals("SuaJarri")) {
			this.suaJarri();
			
		} else if(arg.equals("SuaKendu")) {
			this.elementuaKendu();
		}
		else if(arg.equals("Gogorra")) {
			this.blokeGogorra();
			System.out.println("Bistan: bloke gogorra jarri da");
		}
		else if(arg.equals("Biguna")) {
			this.blokeBiguna();
		}
		else if(arg.equals("Etsaia")) {
			this.etsaia();
		}
		}
		
	}

	public void bombermanJarri(Character pNorabide) {
		this.bombermanDago=true;
		String pNorabideChar=pNorabide.toString();
		if(bombaDago==false) {
			if (pNorabideChar.equals("W")) {
				norabideBerria="up";
			}
			else if (pNorabideChar.equals("S")) {
				if (pausuak>=4) {
					pausuak=0;
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
			if (aurrekoNorabidea.equals(norabideBerria)&&aurrekoNorabidea!="") {
				if (pausuak>=5) {
					pausuak=0;
				}
					pausuak++;
				}
			else{
				pausuak=1;
			}
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/white"+norabideBerria+pausuak+".png")));
			aurrekoNorabidea=norabideBerria;}
		}
	
			
	

	public void bombermanKendu(){
		if(this.bombaDago==true) {
			this.bombermanDago=false;
			this.bombaJarri(bombaDenbora);
			
		}
		else {
			this.irudia.setIcon(null);
			this.bombermanDago=false;
		}		
	}
	
	public void bombaJarri(int kont){
		bombaDenbora=kont;
		if (this.bombermanDago){
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/whitewithbomb"+bombaDenbora+".png")));
		this.bombaDago=true;}
		else{
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomb"+bombaDenbora+".png")));
			this.bombaDago=true;
		}
	}
	
	public void suaJarri() {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/kaBomb5.png")));
	}
	
	
	public void elementuaKendu(){
		if (this.bombaDago==true) {
			
			bombaKendu();
		}
		else {
			if (this.bombermanDago==true) {
			this.bombermanDago=false;}
			this.irudia.setIcon(null);
			
		}

	}
	
	public void bombaKendu() {
		this.bombaDago=false;
		this.irudia.setIcon(null);
	}


	public void etsaiaKendu() {
		this.irudia.setIcon(null);
		this.etsaiaDago=false;
	}
	
	public void etsaiaJarri(Character pNorabide) {
		this.etsaiaDago=true;
		String pNorabideChar=pNorabide.toString();
	    norabideBerria="1";
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/doria"+norabideBerria+".png")));
		aurrekoNorabidea=norabideBerria;
	}
}