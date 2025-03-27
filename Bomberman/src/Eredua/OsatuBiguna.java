package Eredua;

public class OsatuBiguna implements OsatuPortaera{
	
	@Override
	public void osatu() {
		Labirintoa labirintoa = Generator.getNireGenerator().getLabirintoa();
		labirintoa.setChanged(new Object[]{"Matrizea sortu da", -1, -1, ' ', false});
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				Gelaxka unekoGelaxka = labirintoa.bilatuGelaxka(i, j);
				//unekoGelaxka.addObserver(LabirintoBista.getNireLabirintoBista().bilatuGelaxka(i, j));
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					//Ezer ez
				} else if (Math.random() >= 0.4) {
					//Biguna gehitu
					labirintoa.blokeKop++;
					unekoGelaxka.blokeaGehitu("Biguna");
				} else if (Math.random() >= 0.9) {
					if (labirintoa.getEtsaiak().size() < 8) {
						//Etsaia gehitu
						labirintoa.etsaiak.add(new Etsaia(i,j));
					}
				}
			}
		}
		labirintoa.etsaiaTimer();
		labirintoa.setChanged(new Object[]{"BombermanSortu", labirintoa.bombermanMota});
	}
}
