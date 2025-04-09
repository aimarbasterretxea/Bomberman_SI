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
    	
    	Generator.getNireGenerator().sortuLabirintoa(labirintoMota,bomberMota);
    	LabirintoBista frame2 = LabirintoBista.getNireLabirintoBista();        
    	frame2.setVisible(true);
    	Generator.getNireGenerator().getLabirintoa().labirintoaOsatu();
    	
	}
    
	public void amaituJokua(int pMezua) {
		Generator.getNireGenerator().getLabirintoa().abisatuObservers(new Object[]{"Jokua amaitu da", pMezua});
	    System.exit(0);	
	}
}




