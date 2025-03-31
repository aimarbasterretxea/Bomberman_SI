package Eredua;

public class LabirintoaKlasikoa extends Labirintoa {
	
	//Eraikitzailea
	public LabirintoaKlasikoa(String pBombermanMota) {
		super(pBombermanMota);	
		//bombermanMota=pBomberMota
		osatu();
		System.out.println("LabirintoaKlasikoa: Osatuta");
	}
	
	@Override
	public void osatu() {
		//Labirintoa labirintoa = Generator.getNireGenerator().getLabirintoa();
		setChanged(new Object[]{"Matrizea sortu da", -1, -1, ' ', false});
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				Gelaxka unekoGelaxka = bilatuGelaxka(i, j);
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					if (i==0 && j==0) {
						sortuBomberman(this.getBombermanMota());
					}
				} else if (1 == (i % 2) && 1 == (j % 2)) {
					//Gogorra gehitu
					unekoGelaxka.blokeaGehitu("Gogorra");
				} else if (Math.random() >= 0.4) {
					//Biguna gehitu
					blokeKopEguneratu();
					unekoGelaxka.blokeaGehitu("Biguna");
				} else if (Math.random() >= 0.9) {
					if (getEtsaiak().size() < 6) {
						//Etsaia gehitu
						getEtsaiaLista().add(new Etsaia(i,j));
					}
				}
			}
		}
		etsaiaTimer();
	}

}