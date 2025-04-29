package Eredua;
import Bista.LabirintoBista;

public class LabirintoaKlasikoa extends Labirintoa {
	
	
	//Eraikitzailea
	public LabirintoaKlasikoa() {
		super();	
	}	
	
	//Metodoak
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
	/*
	 * public void labirintoaOsatu(String pBomberMota) {
    setChanged();
    notifyObservers("Matrizea sortu da");

    IntStream.range(0, 11).forEach(i ->
        IntStream.range(0, 17).forEach(j -> {
            Gelaxka unekoGelaxka = this.bilatuGelaxka(i, j);

            if ((i == 0 && j == 0) || (i == 1 && j == 0) || (i == 0 && j == 1)) {
                if (i == 0 && j == 0) {
                    sortuBomberman(pBomberMota);
                    // notifyObservers(new Object[] {"BombermanSortu", ...}); // 若需恢复通知，可解除注释
                }
            } else if (i % 2 == 1 && j % 2 == 1) {
                unekoGelaxka.blokeaGehitu("Gogorra");
            } else {
                double random = Math.random();
                if (random >= 0.4) {
                    blokeKopEguneratu();
                    unekoGelaxka.blokeaGehitu("Biguna");
                } else if (random >= 0.9 && this.getEtsaiak().size() < 6) {
                    gehituEtsaia(i, j, "Inteligente");
                }
            }
        })
    );

    etsaiaTimer();
}

	 */
	
}