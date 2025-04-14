package Eredua;

import java.util.ArrayList;

public class BombermanJarraitu implements MugimenduPortaera{

	@Override
    public char aukeratuNorabidea(ArrayList<Character> aukera, int x, int y, int bomberX, int bomberY) {
      /*  if (bomberX < x && aukera.contains('W')) return 'W';
        if (bomberX > x && aukera.contains('S')) return 'S';
        if (bomberY < y && aukera.contains('A')) return 'A';
        if (bomberY > y && aukera.contains('D')) return 'D';

        // Ez bada zuzenean joaterik, ausaz bat
        if (!aukera.isEmpty()) {
            return aukera.get((int)(Math.random() * aukera.size()));
        }
        return ' ';
    }
	*/
		
			boolean[][] bisitatuak = new boolean[11][17];
		Object[] arg=Generator.getNireGenerator().getLabirintoa().biderikMotzenaKalkulatu(x, y, 0, ' ',bisitatuak);
		char norabidea = (char) arg[0];
		if (norabidea == ' ') {
		 return aukera.get((int)(Math.random() * aukera.size()));
		}
		else {
		 return norabidea;
		}
	}

}
