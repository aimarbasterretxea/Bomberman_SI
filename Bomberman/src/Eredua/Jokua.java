package Eredua;

import java.util.Observable;

import Bista.LabirintoBista;
import Bista.Menua;

public class Jokua extends Observable {
	//Atributua
    private static Jokua nireJokua=null; 
    
    //Eraikitzailea
    private Jokua() {
    }

    //Geterra
    public static Jokua getJokua() {
        if (nireJokua == null) {
            nireJokua = new Jokua();
        }
        return nireJokua;
    }
    
    //Metodoa
    public void Hasieraketa() {
        	Menua frame1 = Menua.getNireMenua();
        	frame1.setVisible(true);
    }
    
    public void jokuaHasieratu(String labirintoMota, String bomberMota) {
		//Labirintoa.getNireLabirintoa().labirintoaOsatu(labirintoMota, bomberMota);
    	System.out.println("Jokua: Jokua hasieratzen saiatu da");
    	
    	Generator.getNireGenerator().sortuLabirintoa(labirintoMota);
    	LabirintoBista frame2 = LabirintoBista.getNireLabirintoBista();
    	Generator.getNireGenerator().getLabirintoa().sortuBomberman(bomberMota);
    	
        // Hemen Labirinto Orokorra sortuta dago 
        
    	frame2.setVisible(true);
    	Generator.getNireGenerator().getLabirintoa().labirintoaOsatu();
    	
	}
    
	public void amaituJokua(int pY) {
		Generator.getNireGenerator().getLabirintoa().setChanged("Jokua amaitu da", pY, -1, ' ', false);
	    System.exit(0);
		//System.out.println("Hil da");
	
	}
}




