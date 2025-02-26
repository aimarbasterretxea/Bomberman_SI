package Eredua;

public abstract class Bomberman {
	private int x;
	private int y;
	private boolean bizirik;
	
	//eraikitzailea
	public Bomberman(int pX, int pY, boolean pBizirik) {
		this.x = pX;
		this.y = pY;
		this.bizirik = pBizirik;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	/*
	public Laukia mugitu() {
		int unekoPosizioaX = this.getX();
		int unekoPosizioaY = this.getY();
		if (OBSERVER ARRIBA) {
			if (this.getY() != 0 && Matrizea.getNireMatrizea().bilatuLaukia(unekoPosizioaX, unekoPosizioaY-1).getHutsaDa()) {
				this.y = unekoPosizioaY-1;
			}
			
		}
		else if (OBSERVER DCHA) {
			if (this.getX() != 16 && Matrizea.getNireMatrizea().bilatuLaukia(unekoPosizioaX+1, unekoPosizioaY).getHutsaDa()) {
				this.x = unekoPosizioaX+1;
			}
		}
		else if (OBSERVER IZDA) {
			if (this.getX() != 0 && Matrizea.getNireMatrizea().bilatuLaukia(unekoPosizioaX-1, unekoPosizioaY).getHutsaDa()) {
				this.x = unekoPosizioaX-1;
			}
		}
		else {
			if (this.getY() != 10 && Matrizea.getNireMatrizea().bilatuLaukia(unekoPosizioaX, unekoPosizioaY-1).getHutsaDa()) {
				this.y = unekoPosizioaX+1;
			}
		}
		return Laukia;
	}
	*/
}
