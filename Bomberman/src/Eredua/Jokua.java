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
    	LabirintoBista frame2 = LabirintoBista.getNireLabirintoBista();
        LabirintoaKlasikoa matrizeKlasikoa = LabirintoaKlasikoa.getNireLabirintoKlasikoa();
        matrizeKlasikoa.labirintoOrokorraSortu();
        // Hemen Labirinto Orokorra sortuta dago 
        
        matrizeKlasikoa.labirintoaOsatu();
        frame2.setVisible(true);
    	
	}
    
	public void amaituJokua(int pY) {
        LabirintoaKlasikoa.getNireLabirintoKlasikoa().setChanged("Jokua amaitu da", pY, -1, ' ', false);
	    System.exit(0);
		//System.out.println("Hil da");
	
	}
}




