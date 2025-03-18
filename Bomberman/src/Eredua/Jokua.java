package Eredua;

import Bista.LabirintoBista;

public class Jokua {
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
    }
    
	public void amaituJokua(int pY) {
        LabirintoaKlasikoa.getNireLabirintoKlasikoa().setChanged("Jokua amaitu da", pY, -1, ' ', false);
	    System.exit(0);
		//System.out.println("Hil da");
	
	}
}




