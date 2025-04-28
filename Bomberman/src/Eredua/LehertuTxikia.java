package Eredua;

import java.util.ArrayList;
import java.util.Arrays;

public class LehertuTxikia implements LehertuPortaera{

	@Override
	public ArrayList<int[]> Lehertu(int pX, int pY) {
		ArrayList<int[]> sutea = new ArrayList<>();
		ArrayList<int[]> norabideak = new ArrayList<>(Arrays.asList(
			    new int[]{-1, 0},
			    new int[]{1, 0},
			    new int[]{0, -1},
			    new int[]{0, 1}
			));
	    // Bombaren erdigunea gehitu
	    sutea.add(new int[]{pX, pY});

	    // Lau norabideak gehitu
	     norabideak.stream()
    .map(norabidea -> new int[]{pX + norabidea[0], pY + norabidea[1]})
    .filter(pos -> pos[0] >= 0 && pos[0] <= 10 && pos[1] >= 0 && pos[1] <= 16)
    .filter(pos -> !(Generator.getNireGenerator().getLabirintoa().bilatuGelaxka(pos[0], pos[1]).getBloke() instanceof BlokeGogorra))
    .forEach(pos -> sutea.add(new int[]{pos[0], pos[1]}));

	     
	    Generator.getNireGenerator().getLabirintoa().bombaKendu(sutea);
	    return sutea;
	}

}
