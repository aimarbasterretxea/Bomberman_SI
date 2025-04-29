package Eredua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LehertuHandia implements LehertuPortaera{

	@Override	  
	public ArrayList<int[]> lehertu(int pX, int pY) {
	    ArrayList<int[]> sutea = new ArrayList<>();
	    ArrayList<int[]> norabideak = new ArrayList<>(Arrays.asList(
	        new int[]{-1, 0},
	        new int[]{1, 0},
	        new int[]{0, -1},
	        new int[]{0, 1}
	    ));
	
	    sutea.add(new int[]{pX, pY});
	
	    norabideak.stream().forEach(norabidea -> gehituNorabidekoSutea(sutea, norabidea, pX, pY));
	
	    Generator.getNireGenerator().getLabirintoa().bombaKendu(sutea);
	    return sutea;
	}
	
	private void gehituNorabidekoSutea(List<int[]> sutea, int[] norabidea, int pX, int pY) {
	    for (int i = 1; i < 20; i++) {
	        int berriaX = pX + norabidea[0] * i;
	        int berriaY = pY + norabidea[1] * i;
	
	        if (berriaX < 0 || berriaX > 10 || berriaY < 0 || berriaY > 16) break;
	
	        Gelaxka g = Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(berriaX, berriaY);
	        if (g.getBloke() instanceof BlokeGogorra) break;
	
	        sutea.add(new int[]{berriaX, berriaY});
	    }
	}

	 
}
