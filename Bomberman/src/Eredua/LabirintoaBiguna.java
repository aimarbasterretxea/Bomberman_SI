
package Eredua;

public class LabirintoaBiguna extends Labirintoa{	
	
	//Eraikitzailea
	public LabirintoaBiguna() {
		super();		
	}
		
	@Override
	public void labirintoaOsatu(String pBomberMota) {
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
				} else if (Math.random() >= 0.4) {
					//Biguna gehitu
					blokeKopEguneratu();
					unekoGelaxka.blokeaGehitu("Biguna");
				} else if (Math.random() >= 0.9) {
					if (this.getEtsaiak().size() < 8) {
						//Etsaia gehitu
						gehituEtsaia(i,j,"Inteligente");
					}
				}
			}
		}
		etsaiaTimer();
	}
}
