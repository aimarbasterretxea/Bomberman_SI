package Eredua;

public class LabirintoaBiguna extends Labirintoa{
	//Atributua
	private static LabirintoaBiguna nireLabirintoaBiguna;
	
	//Eraikitzailea
	private LabirintoaBiguna() {
		super();		
	}
	
	//Geterra
	public static LabirintoaBiguna getNireLabirintoaBiguna(){
		if(nireLabirintoaBiguna==null) {
			nireLabirintoaBiguna=new LabirintoaBiguna();
		}
		return nireLabirintoaBiguna;
	}
	
	//Metodoak
	@Override
	public void labirintoaOsatu() {
		Gelaxka[][] labirintoa = this.getLabirintoa();
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				Gelaxka unekoGelaxka = labirintoa[i][j];
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0 && j == 1)) {
					//Ezer ez
				} else if (Math.random() >= 0.4) {
					this.blokeKop++;
					unekoGelaxka.blokeaGehitu("Biguna");
					//Biguna gehitu
				}
				else if (Math.random() >= 0.9) {
					if (etsaiKop < 8) {
						unekoGelaxka.etsaiaGehitu();
						//Etsaia gehitu
						etsaiKop++;
					}
				}
				
			}
		}
	}
}
