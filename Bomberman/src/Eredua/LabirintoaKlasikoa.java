package Eredua;
import Bista.LabirintoBista;

public class LabirintoaKlasikoa extends Labirintoa {
	//Atributua
	//private static LabirintoaKlasikoa nireLabirintoKlasikoa;
	
	//Eraikitzailea
	public LabirintoaKlasikoa() {
		super();	
		System.out.println("LabirintoaKlasikoa: Osatuta");
	}
	
	//Geterra
	public  LabirintoaKlasikoa getNireLabirintoKlasikoa(){
		return this;
	}
	
	//Metodoak
	@Override
	public void labirintoaOsatu() {
		Gelaxka[][] labirintoa = this.getLabirintoa();
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				Gelaxka unekoGelaxka = labirintoa[i][j];
				//unekoGelaxka.addObserver(LabirintoBista.getNireLabirintoBista().bilatuGelaxka(i, j));
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					//Ezer ez
				} else if (1 == (i % 2) && 1 == (j % 2)) {
					//Gogorra gehitu
					unekoGelaxka.blokeaGehitu("Gogorra");
					System.out.println("Gogorra");

				} else if (Math.random() >= 0.4) {
					//Biguna gehitu
					this.blokeKop++;
					unekoGelaxka.blokeaGehitu("Biguna");
				} else if (Math.random() >= 0.9) {
					if (this.getEtsaiak().size() < 6) {
						//Etsaia gehitu
						this.etsaiak.add(new Etsaia(i,j));
					}
				}
			}
		}
		etsaiaTimer();
	}
}