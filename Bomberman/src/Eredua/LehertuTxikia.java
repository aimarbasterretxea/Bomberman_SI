package Eredua;

import java.util.ArrayList;

public class LehertuTxikia implements LehertuPortaera{

	@Override
	public ArrayList<int[]> Lehertu(int pX, int pY) {
		// TODO Auto-generated method stub
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
	    Generator.getNireGenerator().getLabirintoa().bombaKendu(sutea);
	    return sutea;
	}

}
