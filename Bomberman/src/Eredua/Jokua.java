package Eredua;

import java.util.Observable;
import Bista.LabirintoBista;

public class Jokua extends Observable{
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
        	LabirintoBista frame = LabirintoBista.getNireLabirintoBista();
            LabirintoaKlasikoa matrizeKlasikoa = LabirintoaKlasikoa.getNireLabirintoKlasikoa();
            matrizeKlasikoa.labirintoOrokorraSortu();
            matrizeKlasikoa.labirintoaOsatu();
            frame.setVisible(true);
            this.addObserver(frame);
    }
    
	public void amaituJokua(int Py) {
		setChanged();
		notifyObservers(new Object[]{"Jokua amaitu da",Py});
	    System.exit(0);
		//System.out.println("Hil da");
	
	}
}




