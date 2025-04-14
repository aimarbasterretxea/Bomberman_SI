package Eredua;
import Bista.LabirintoBista;

public class LabirintoaKlasikoa extends Labirintoa {
	
	
	//Eraikitzailea
	public LabirintoaKlasikoa(String pBomberMota) {
		super(pBomberMota);	
	}	
	
	//Metodoak
	@Override
	public void labirintoaOsatu() {
		setChanged();
		notifyObservers("Matrizea sortu da");
		
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				Gelaxka unekoGelaxka = this.bilatuGelaxka(i, j);
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					if (i == 0 && j == 0) {
						//Bombermana gehitu
						sortuBomberman(getBombermanMota());
					}
				} else if (1 == (i % 2) && 1 == (j % 2)) {
					//Gogorra gehitu
					unekoGelaxka.blokeaGehitu("Gogorra");
				} else if (Math.random() >= 0.4) {
					//Biguna gehitu
					blokeKopEguneratu();
					unekoGelaxka.blokeaGehitu("Biguna");
				} else if (Math.random() >= 0.9) {
					if (this.getEtsaiak().size() < 6) {
						//Etsaia gehitu
						gehituEtsaia(i,j,"Inteligente");
						
					}
				}
			}
		}
		etsaiaTimer();
	}
	
}