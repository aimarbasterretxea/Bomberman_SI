package Bista;

import Eredua.Bomberman;
import Eredua.LabirintoaKlasikoa;
import Eredua.Jokua;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

public class LabirintoBista extends JFrame implements Observer {
	
	// ATRIBUTUAK ////////////////
    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private static Panel panelMatrize;
    private static Panel panelInfo;
    private static LabirintoBista nireLabirintoBista;
    private Kontroladorea kontroladorea; // Controlador de teclado
    private static int x;
    private static int y;
    private JLabel irudia;
    private JLabel bombaKop;
    
    
    // ERAIKITZAILEA ////////////////
    
    private LabirintoBista() {
    	setTitle("BomberMan");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LabirintoBista.class.getResource("/irudiak/blackfront1.png")));
    	
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        
        panelInfo = new Panel();
        panelInfo.setLayout(null);
        panelInfo.setBounds(0, 0, 900, 50);
        this.add(panelInfo, BorderLayout.NORTH);
        
        bombaKop = new JLabel(":  10");
        bombaKop.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomb1.png")));
        bombaKop.setBounds(10, 10, 60, 50);
        panelInfo.add(bombaKop);


        panelMatrize = new Panel();
        panelMatrize.setBounds(0, 0, 900, 600);
        panelMatrize.setLayout(new GridLayout(11, 17, 0, 0));
        this.add(panelMatrize,BorderLayout.CENTER);
        
        
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
        panelMatrize.add(pLaukiaBista);
    }

    public GelaxkaBista bilatuGelaxka(int x, int y) {
        return (GelaxkaBista) panelMatrize.getComponent(x * 17 + y);
    }
    
    public void mugituBomberman(int hX, int hY, char pNorabide) {
    	bilatuGelaxka(x, y).bombermanKendu();
    	bilatuGelaxka(hX, hY).bombermanJarri(pNorabide);
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
		if (arg.equals("Matrizea sortu da")) { 
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 17; j++) {
					this.gehituGelaxka(new GelaxkaBista(i, j, false));
				}
			}
			bilatuGelaxka(0,0).bombermanJarri(' ');
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
				char norabide = (char) obj[3];
				this.mugituBomberman(i, j, norabide);;
				//System.out.println("WASD");
			}		
		} else if(arg.equals("Jokua amaitu da")) {
			//contentPane.removeAll();
			System.out.println("Jokua amaitu da");
			this.dispose(); 
	
		} else {System.out.println("BombaJarri");}
	}
	
	public void eguneratuBombaKop() {
		if (bombaKop.equals(0)) {
			bombaKop.setText("1");
		} else {
			bombaKop.setText(Integer.toString(Integer.parseInt(bombaKop.getText())-1));
		}
	}
	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}
