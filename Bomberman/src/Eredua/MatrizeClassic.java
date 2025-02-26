package Eredua;
import java.util.Random;

public class MatrizeClassic extends Matrizea {
	public MatrizeClassic () {
		super();
		
	}

	@Override
	public void matrizeaOsatu() {
		Laukia[][] matrizea = Matrizea.getNireMatrizea().getMatrix();
		for (int i = 0; i < errenkada; i++) {
			for (int j = 0; j < zutabea; j++) {
				Laukia unekoaLaukia = matrizea[i][j];
				if((i == 0 && j == 0) || (i==1 && j == 0) || (i == 0&& j == 1)) {}
				else if (1 == (i % 2) && 1 == (j % 2)) {
					//bloke gogorra da
					
				}
				else if(Math.random() >= 0.7) {
					//sortu bloke biguna
				}
				Bista.Matrize_Bista.gehituLaukia(new Bista.Laukia_Bista(i, j, false));
			}
		}
	}
		
}
