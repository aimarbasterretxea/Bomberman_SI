package Bista;

import Eredua.Bomberman;
import Eredua.LabirintoaKlasikoa;
import Eredua.Jokua;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

public class LabirintoBista extends JFrame implements Observer {
	
	// ATRIBUTUAK ////////////////
    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private static LabirintoBista nireLabirintoBista;
    private Kontroladorea kontroladorea; // Controlador de teclado
    private static int x;
    private static int y;
    private JLabel irudia;
    
    
    // ERAIKITZAILEA ////////////////
    
    private LabirintoBista() {
    	setTitle("BomberMan");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LabirintoBista.class.getResource("/irudiak/blackfront1.png")));
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 810, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(1, 1, 5, 5));
        contentPane.setLayout(new GridLayout(11, 17, 0, 0));
        setContentPane(contentPane);
        
        

        this.irudia = new JLabel("");
        this.irudia.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/back.png")));
        
        // Agregar el controlador de teclado
        kontroladorea = new Kontroladorea();
        addKeyListener(kontroladorea);
        requestFocusInWindow(); // Asegurar que la ventana tenga el foco
    }
    
    
    // GETERRAK ////////////////
   
    public static LabirintoBista getNireLabirintoBista() {
        if (nireLabirintoBista == null) {
            nireLabirintoBista = new LabirintoBista();
        }
        return nireLabirintoBista;
    }

    //Metodoak
    public static void gehituGelaxka(GelaxkaBista pLaukiaBista) {
        contentPane.add(pLaukiaBista);
    }

    public GelaxkaBista bilatuGelaxka(int x, int y) {
        return (GelaxkaBista) contentPane.getComponent(x * 17 + y);
    }
    
    public void mugituBomberman(int hX, int hY){
    	bilatuGelaxka(x, y).bombermanKendu();
    	bilatuGelaxka(hX, hY).bombermanJarri();
    	this.x=hX;
    	this.y=hY;
    }
/*
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update recibido: " + arg);
    }
*/
    // Controlador de teclado separado de "Controler"
    private class Kontroladorea extends Observable implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            LabirintoaKlasikoa labirintoa = Eredua.LabirintoaKlasikoa.getNireLabirintoKlasikoa();
            switch (keyCode) {
                case KeyEvent.VK_W:
                    //System.out.println("parriba");
                    labirintoa.mugituBomberman('W');
                    break;
                case KeyEvent.VK_S:
                    //System.out.println("pabajo");
                	labirintoa.mugituBomberman('S');
                    break;
                case KeyEvent.VK_A:
                    //System.out.println("paizda");
                	labirintoa.mugituBomberman('A');
                    break;
                case KeyEvent.VK_D:
                    //System.out.println("padcha");
                	labirintoa.mugituBomberman('D');
                    break;
                case KeyEvent.VK_SPACE:
                	labirintoa.getBomberman().bombaJarri();
					break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

	@Override
	public void update(Observable o, Object arg) {
		LabirintoaKlasikoa matrizea = LabirintoaKlasikoa.getNireLabirintoKlasikoa();
		if (arg.equals("Matrizea sortu da")) {
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 17; j++) {
					this.gehituGelaxka(new GelaxkaBista(i, j, false));
				}
			}
			bilatuGelaxka(0,0).bombermanJarri();
			this.x = 0;
			this.y = 0;
		} else if (arg instanceof Object[]) {
			Object[] obj = (Object[]) arg;
			if (obj[0].equals("Bloke gogorra gehitu da")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.bilatuGelaxka(i, j).blokeGogorra();
			} else if (obj[0].equals("Bloke biguna gehitu da")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.bilatuGelaxka(i, j).blokeBiguna();
			} else if (obj[0].equals("Move")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.mugituBomberman(i, j);;
				//System.out.println("WASD");
			}		
		} else if(arg.equals("Jokua amaitu da")) {
			//contentPane.removeAll();
			System.out.println("Jokua amaitu da");
			this.dispose(); 
	
		} else {System.out.println("BombaJarri");}
	}
	
	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}
