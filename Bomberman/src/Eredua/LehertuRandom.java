package Eredua;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LehertuRandom implements LehertuPortaera{

	@Override
	public ArrayList<int[]> Lehertu(int pX, int pY) {
	    ArrayList<int[]> sutea = new ArrayList<>();
        Set<String> bisitatuak = new HashSet<>();
        Random rand = new Random();

	    int[][] norabideak = {{-1, -1}, {-1, 0}, {-1, 1},{0, -1},  {0, 1}, {1, -1},  {1, 0},  {1, 1}};

	    // Bombaren erdigunea gehitu
	    sutea.add(new int[]{pX, pY});
	   
	    // Lau norabideak gehitu
	    for (int i=0; i< 5; i++) {
            int indizea = rand.nextInt(norabideak.length);
            int berriaX = pX + norabideak[indizea][0];
            int berriaY = pY + norabideak[indizea][1];
            
            String gakoa = berriaX + "," + berriaY;
            
            if (!bisitatuak.contains(gakoa)) {
            	bisitatuak.add(gakoa);
            	if(berriaX >= 0 && berriaX <= 10 && berriaY >= 0 && berriaY <= 16 && 
        	        !(Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(berriaX, berriaY).getBloke() instanceof BlokeGogorra)) {
    	            sutea.add(new int[]{berriaX, berriaY});
            	}
            }
	    }

	    Generator.getNireGenerator().getLabirintoa().bombaKendu(sutea);
	    return sutea;		
	}
	
}