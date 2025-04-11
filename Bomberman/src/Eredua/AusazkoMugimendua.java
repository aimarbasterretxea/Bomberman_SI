package Eredua;

import java.util.ArrayList;

public class AusazkoMugimendua implements MugimenduPortaera{
    @Override
    public char aukeratuNorabidea(ArrayList<Character> aukera, int x, int y, int bomberX, int bomberY) {
        if (!aukera.isEmpty()) {
            return aukera.get((int)(Math.random() * aukera.size()));
        }
        return ' ';
    }
}
