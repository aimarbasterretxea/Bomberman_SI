package Eredua;

public class LabirintoaHutsa extends Labirintoa{
	
	//Eraikitzailea
	public LabirintoaHutsa() {
		super();		
	}	
	
	@Override
	public void labirintoaOsatu(String pBomberMota,String pEtsaiaMota) {
		setChanged();
		notifyObservers("Matrizea sortu da");
		
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				Gelaxka unekoGelaxka = this.bilatuGelaxka(i, j);
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					if (i == 0 && j == 0) {
						//Bombermana gehitu
						sortuBomberman(pBomberMota);
				 		//setChanged();
				 		//notifyObservers(new Object[] {"BombermanSortu",this.getBomberman().getKolorea(),this.getBomberman().getBombaKop()});
					}
				} else if (Math.random() >= 0.95) {
					if (this.getEtsaiak().size() < 10) {
						//Etsaia gehitu
						gehituEtsaia(i,j,pEtsaiaMota);
					}
				}
			}
		}
		etsaiaTimer();
	}
}