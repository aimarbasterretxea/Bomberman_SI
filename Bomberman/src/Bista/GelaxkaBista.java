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
	private static final long serialVersionUID = 1L;
	
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
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof Object[]) {
			Object[] obj = (Object[]) arg;
			if(obj[0].equals("BombaAldatu")) {
				this.bombaAldatu((int) obj[1], (String) obj[2]);
				
			}
			else if(obj[0].equals("BombaJarri")) {
				this.bombaJarri((int) obj[1]);
			}
			
		if (arg.equals("BombaKendu")) {
			this.elementuaKendu();}
		} else if(arg.equals("SuaJarri")) {
			this.suaJarri();
			
		} else if(arg.equals("SuaKendu")) {
			this.elementuaKendu();
		}
		else if(arg.equals("Gogorra")) {
			this.blokeGogorra();
		}
		else if(arg.equals("Biguna")) {
			this.blokeBiguna();
		}
		/*else if(arg.equals("BombermanJarri")) {
			this.bombaJarri(bombaDenbora);
		}*/
		
	}

	public void bombermanJarri(String pNorabide, String pKolorea, int pausuak) {
		//this.bombermanDago=true;
		//this.bombermanKolorea=pKolorea;
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/"+pKolorea+pNorabide+pausuak+".png")));
		}
	
			
	

	public void bombermanKendu(String pKolorea) {
			this.irudia.setIcon(null);
	}
	
	public void bombaJarri(int pDenbora) {
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomb"+pDenbora+".png")));
		
	}
		public void bombaAldatu(int kont, String bombermanKolorea) {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/"+bombermanKolorea+"withbomb"+kont+".png")));
		}
	
	public void suaJarri() {
	//	this.suaDago=true;
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/kaBomb5.png")));
	}
	
	
	public void elementuaKendu(){
			this.irudia.setIcon(null);		
	}
	




	public void etsaiaJarri(Character pNorabide) {

		if (pNorabide.equals('D')) {
			this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/doria1.png")));}
		else {
	   
		this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/doria2.png")));
	}}
}