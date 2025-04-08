package Eredua;

import java.util.ArrayList;

public class LehertuHandia implements LehertuPortaera{

	@Override
	public ArrayList<int[]> Lehertu(int pX, int pY) {
	    ArrayList<int[]> sutea = new ArrayList<>();
	    int[][] norabideak = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	    // Bombaren erdigunea gehitu
	    sutea.add(new int[]{pX, pY});

	    // Lau norabideak gehitu
	    for (int[] norabidea : norabideak) {
	        boolean jarraitu = true;  
	        for (int i = 1; i < 20 && jarraitu; i++) {
	            int berriaX = pX + norabidea[0] * i;
	            int berriaY = pY + norabidea[1] * i;

	            // BEGIRATU KANPOALDEAN DAGOEN
	            if (berriaX < 0 || berriaX > 10 || berriaY < 0 || berriaY > 16) {
	                break;
	            }

	            // BEGIRATU HUTSA DEN
	            if (!Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(berriaX, berriaY).hutsaDa()) {
	                jarraitu = false;
	            }

	            sutea.add(new int[]{berriaX, berriaY});
	            System.out.println("koordenatuak: " + berriaX + " " + berriaY);
	        }
	    }

	    Generator.getNireGenerator().getLabirintoa().bombaKendu(sutea);
	    return sutea;		
	}
	
}
