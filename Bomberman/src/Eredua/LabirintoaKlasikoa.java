package Eredua;
import Bista.LabirintoBista;

public class LabirintoaKlasikoa extends Labirintoa {
	//Atributua
	private static LabirintoaKlasikoa nireLabirintoKlasikoa;
	
	//Eraikitzailea
	private LabirintoaKlasikoa() {
		super();
		addObserver(LabirintoBista.getNireLabirintoBista());
		
	}
	
	//Geterra
	public static LabirintoaKlasikoa getNireLabirintoKlasikoa(){
		if(nireLabirintoKlasikoa==null) {
			nireLabirintoKlasikoa=new LabirintoaKlasikoa();
		}
		return nireLabirintoKlasikoa;
	}
	
	//Metodoak
	@Override
	public void labirintoaOsatu() {
		Gelaxka[][] labirintoa = this.getLabirintoa();
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				Gelaxka unekoGelaxka = labirintoa[i][j];
				unekoGelaxka.addObserver(LabirintoBista.getNireLabirintoBista().bilatuGelaxka(i, j));
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					//Ezer ez
				} else if (1 == (i % 2) && 1 == (j % 2)) {
					unekoGelaxka.blokeGogorraGehitu();
					setChanged();
					notifyObservers(new Object[]{"Bloke gogorra gehitu da",i,j});
				} else if (Math.random() >= 0.4) {
					this.blokeKop++;
					unekoGelaxka.blokeBigunaGehitu();
					setChanged();
					notifyObservers(new Object[]{"Bloke biguna gehitu da", i, j});
				}
			}
		}
	}
}
