package Eredua;

public abstract class Bomberman {
	private int x;
	private int y;
	private boolean bizirik;
	
	//eraikitzailea
	public Bomberman() {
		this.x = 0;
		this.y = 0;
		this.bizirik = true;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void mugituW() {
		if (this.x != 0 && MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x, this.y - 1).getHutsaDa()) {
			this.y = this.y - 1;
		}
	}
	
	public void mugituD() {
		if (this.x != 16 && MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x + 1, this.y).getHutsaDa()) {
				this.x = this.x + 1;
		}		
	}
	
	public void mugituA() {
		if (this.x != 0 && MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x - 1, this.y).getHutsaDa()) {
				this.x = this.x - 1;
		}		
	}
	
	public void mugituS() {
		if (this.getY() != 10 && MatrizeClassic.getNireMatrizea().bilatuLaukia(this.x, this.y - 1).getHutsaDa()) {
				this.y = this.y + 1;
		}		
	}		
	
}
