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
    	//TODO etsaiaMota pasatzea falta zaio, menuan gehityçu ondoren
    	Generator.getNireGenerator().sortuLabirintoa(labirintoMota);
    	LabirintoBista frame2 = LabirintoBista.getNireLabirintoBista();        
    	frame2.setVisible(true);
    	Generator.getNireGenerator().getLabirintoa().labirintoaOsatu(bomberMota);
    	
    	
	}
    
	public void amaituJokua(int pMezua, Object[] koordenatuak) {
		Generator.getNireGenerator().getLabirintoa().abisatuObservers(new Object[]{"Jokua amaitu da", pMezua, koordenatuak});
	    System.exit(0);	
	}
}




