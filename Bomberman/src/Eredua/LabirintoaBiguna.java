
package Eredua;

public class LabirintoaBiguna extends Labirintoa{
	//Atributua
	
	//Eraikitzailea
	public  LabirintoaBiguna(String pBomberMota) {
		super(pBomberMota);		
		osatu();
	}
	
	@Override
	public void osatu() {
		this.setChanged(new Object[]{"Matrizea sortu da", -1, -1, ' ', false});
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 17; j++) {
				Gelaxka unekoGelaxka = this.bilatuGelaxka(i, j);
				//unekoGelaxka.addObserver(LabirintoBista.getNireLabirintoBista().bilatuGelaxka(i, j));
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					//Ezer ez
					if(i==0 && j==0) {
						this.sortuBomberman(getBombermanMota());
					}
				} else if (Math.random() >= 0.4) {
					//Biguna gehitu
					blokeKopEguneratu();
					unekoGelaxka.blokeaGehitu("Biguna");
				} else if (Math.random() >= 0.9) {
					if (getEtsaiak().size() < 8) {
						//Etsaia gehitu
						getEtsaiaLista().add(new Etsaia(i,j));
					}
				}
			}
		}
		etsaiaTimer();
	}

}
