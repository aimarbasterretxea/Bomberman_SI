package Eredua;

public class LabirintoaHutsa extends Labirintoa{
	//Atributua
	private static LabirintoaHutsa nireLabirintoaHutsa;
	
	//Eraikitzailea
	private LabirintoaHutsa() {
		super();		
	}
	
	//Geterra
	public static LabirintoaHutsa getNireLabirintoaHutsa(){
		if(nireLabirintoaHutsa==null) {
			nireLabirintoaHutsa=new LabirintoaHutsa();
		}
		return nireLabirintoaHutsa;
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
				}
				else if (Math.random() >= 0.95) {
					if (etsaiKop < 10) {
						//Etsaia gehitu
						unekoGelaxka.etsaiaGehitu();
						etsaiKop++;
					}
				}
			}
		}
	}
}
