package Eredua;

import java.util.ArrayList;

public class BombermanJarraitu implements MugimenduPortaera{

	@Override
    public char aukeratuNorabidea(ArrayList<Character> aukera, int pX, int pY, int bomberX, int bomberY) {
		boolean[][] bisitatuak = new boolean[11][17];
		Object[] arg=Generator.getNireGenerator().getLabirintoa().biderikMotzenaKalkulatu(pX, pY, 0, ' ',bisitatuak);
		char norabidea = (char) arg[0];
		
		if (norabidea == ' ') {
			return aukera.get((int)(Math.random() * aukera.size()));
		} else {
			return norabidea;
		}
	}

}
