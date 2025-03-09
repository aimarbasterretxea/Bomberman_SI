package Eredua;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import Bista.LabirintoBista;

public class Jokua extends Observable{
    private static Jokua nireJokua=null; 
    private boolean jokuaAktibatu=true;

    private Jokua() {
    }

    public static Jokua getJokua() {
        if (nireJokua == null) {
            nireJokua = new Jokua();
        }
        return nireJokua;
    }
    
    public void Hasieraketa() {
        	Teklatua teklatua = Teklatua.getNireTeklatua();
        	LabirintoBista frame = LabirintoBista.getNireLabirintoBista();
            LabirintoaKlasikoa matrizeKlasikoa = LabirintoaKlasikoa.getNireLabirintoKlasikoa();
            matrizeKlasikoa.labirintoOrokorraSortu();
            matrizeKlasikoa.labirintoaOsatu();
            frame.setVisible(true);
            this.addObserver(frame);
    }
    
	public void amaituJokua() {
		Object[] opciones = {"Ados"};
	    int seleccion = JOptionPane.showOptionDialog(
	            Bista.LabirintoBista.getNireLabirintoBista(),
	            "Bomberman hil egin da sakatu 'Ados' irteteko.",
	            "Game Over",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.INFORMATION_MESSAGE,
	            null,
	            opciones,
	            null); 
	    System.exit(0);
		//System.out.println("Hil da");
		//setChanged();
		//notifyObservers("Jokua amaitu da");
	}
	}
	
	/*
	 *  public void checkGameStatus() {
        if (gameOver) {
            showMessage("Galdu: Bomberman-a bere bonba batek edo etsairen batek hil du.", "Jogoaren Amaiera", JOptionPane.ERROR_MESSAGE);
        } else {
            showMessage("Irabazi: Bonberman-ak etsai guztiak suntsitu ditu.", "Jogoaren Amaiera", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 显示消息框
    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }

	 */
    
    /*public void hautatu() {
        boolean ondo = false;
        String num;

        do {
            num = Teklatua.getTeklatua().irakurriString("Jokalarien kontra (1) edo CPUren kontra (2)?");
            if (num.equals("1")) {
                this.jokalariZerrenda.jokalariBerriak();
                ondo = true;
            } else if (num.equals("2")) {
                this.jokalariZerrenda.botBerriak();
                ondo = true;
            } else {
                System.out.println("1 edo 2 idatzi soilik!\n");
            }
        } while (!ondo);
    }*/



