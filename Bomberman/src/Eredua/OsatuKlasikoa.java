package Eredua;

public class OsatuKlasikoa implements OsatuPortaera{

	@Override
	public void osatu() {
		Labirintoa labirintoa = Generator.getNireGenerator().getLabirintoa();
		labirintoa.setChanged("Matrizea sortu da", -1, -1, ' ', false);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				Gelaxka unekoGelaxka = labirintoa.bilatuGelaxka(i, j);
				//unekoGelaxka.addObserver(LabirintoBista.getNireLabirintoBista().bilatuGelaxka(i, j));
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					//Ezer ez
				} else if (1 == (i % 2) && 1 == (j % 2)) {
					//Gogorra gehitu
					unekoGelaxka.blokeaGehitu("Gogorra");
				} else if (Math.random() >= 0.4) {
					//Biguna gehitu
					labirintoa.blokeKop++;
					unekoGelaxka.blokeaGehitu("Biguna");
				} else if (Math.random() >= 0.9) {
					if (labirintoa.getEtsaiak().size() < 6) {
						//Etsaia gehitu
						labirintoa.etsaiak.add(new Etsaia(i,j));
					}
				}
			}
		}
		labirintoa.etsaiaTimer();
	}
	/*
	public void osatu() {
		Labirintoa labirintoa = Generator.getNireGenerator().getLabirintoa();
		labirintoa.setChanged("Matrizea sortu da", -1, -1, ' ', false);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				Gelaxka unekoGelaxka = labirintoa.bilatuGelaxka(i, j);
				//unekoGelaxka.addObserver(LabirintoBista.getNireLabirintoBista().bilatuGelaxka(i, j));
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					//Ezer ez
				} else if (1 == (i % 2) && 1 == (j % 2)) {
					//Gogorra gehitu
					unekoGelaxka.blokeaGehitu("Gogorra");
				} else if (Math.random() >= 0.4) {
					//Biguna gehitu
					this.labirintoa.blokeKop++;
					unekoGelaxka.blokeaGehitu("Biguna");
				} else if (Math.random() >= 0.9) {
					if (this.labirintoa.getEtsaiak().size() < 6) {
						//Etsaia gehitu
						this.labirintoa.etsaiak.add(new Etsaia(i,j));
					}
				}
			}
		}
		labirintoa.etsaiaTimer();
	}*/

}
