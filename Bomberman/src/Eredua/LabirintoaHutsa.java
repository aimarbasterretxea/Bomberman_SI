package Eredua;

public class LabirintoaHutsa extends Labirintoa{
	//Atributua
	
	//Eraikitzailea
	public LabirintoaHutsa(String pBomberMota) {
		super(pBomberMota);		
		osatu();
	}
	
	@Override
	public void osatu() {
		//Labirintoa labirintoa = Generator.getNireGenerator().getLabirintoa();
		setChanged(new Object[]{"Matrizea sortu da", -1, -1, ' ', false});
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				Gelaxka unekoGelaxka = bilatuGelaxka(i, j);
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					if(i==0 && j==0) {
						this.sortuBomberman(getBombermanMota());
					}
				} else if (Math.random() >= 0.95) {
					if (getEtsaiak().size() < 10) {
						//Etsaia gehitu
						getEtsaiaLista().add(new Etsaia(i,j));
					}
				}
			}
		}
		etsaiaTimer();
	}
}