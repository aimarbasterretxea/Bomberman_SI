package Eredua;

import java.util.ArrayList;

public class BombaTxikia extends Bomba{
	@Override
	public ArrayList<int[]> kalkulatuKoordenatuak(int pX, int pY) {
		ArrayList<int[]> sutea = new ArrayList<>();
	    int[][] norabideak = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	    // Bombaren erdigunea gehitu
	    sutea.add(new int[]{pX, pY});

	    // Lau norabideak gehitu
	    for (int[] norabidea : norabideak) {
	        int berriaX = pX + norabidea[0];
	        int berriaY = pY + norabidea[1];

	        if (berriaX >= 0 && berriaX <= 10 && berriaY >= 0 && berriaY <= 16) {
	            sutea.add(new int[]{berriaX, berriaY});
	        }
	    }
	    LabirintoaKlasikoa.getNireLabirintoKlasikoa().bombaKendu(sutea);
	    return sutea;
	}
}


