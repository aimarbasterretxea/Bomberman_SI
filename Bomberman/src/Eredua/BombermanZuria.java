package Eredua;

public class BombermanZuria extends Bomberman{
	//Eraikitzailea
	public BombermanZuria() {
		super();
		this.bombaKop=10;
	}
	
	//Metodoak
	public void bombermanHil() {
		
	}
	
	@Override  
	public void bombaJarri() {
		if (LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.getX(), this.getY()).getBomba() == false && bombaKop > 0) {
			LabirintoaKlasikoa.getNireLabirintoKlasikoa().bilatuGelaxka(this.getX(), this.getY()).bombaJarri();
			bombaKop--;
	        //LabirintoaKlasikoa.getNireLabirintoKlasikoa().setChanged("BombaJarri", this.x, this.y, ' ',false);

			}	
		LabirintoaKlasikoa.getNireLabirintoKlasikoa().bombaJarriDa(this.bombaKop);
		super.eguneratuBombaKop();
	}
}  

