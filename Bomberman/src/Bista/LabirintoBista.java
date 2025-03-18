package Bista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class LabirintoBista extends JFrame implements Observer {
	
	// ATRIBUTUAK ////////////////
    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private static JPanel panelMatrize;
    private static JPanel panelInfo;
    private static LabirintoBista nireLabirintoBista;
    private Kontroladorea kontroladorea; // Controlador de teclado
    private static int x;
    private static int y;
    private JLabel irudia;
    private JLabel bombaKop;
    private Image argazkia; 

    
    // ERAIKITZAILEA ////////////////
    private LabirintoBista() {
        setTitle("BomberMan");
        setIconImage(Toolkit.getDefaultToolkit().getImage(LabirintoBista.class.getResource("/irudiak/blackfront1.png")));
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        argazkia = new ImageIcon(LabirintoBista.class.getResource("/irudiak/stageback3.png")).getImage();
        
        irudia = new JLabel();
        irudia.setLayout(new BorderLayout()); 
        argazkiTamainaBerritu(); 
        contentPane.add(irudia, BorderLayout.CENTER); 

        // panelInfo
        panelInfo = new JPanel();
        panelInfo.setLayout(null); 
        panelInfo.setOpaque(false); 
        panelInfo.setPreferredSize(new Dimension(900, 50)); 
        irudia.add(panelInfo, BorderLayout.NORTH); 

        
        bombaKop = new JLabel(":" + 10);
        bombaKop.setIcon(new ImageIcon(LabirintoBista.class.getResource("/irudiak/bomb1.png")));
        bombaKop.setBounds(10, 10, 60, 50);
        panelInfo.add(bombaKop);
        panelInfo.setOpaque(true);

        // panelMatrizea
        panelMatrize = new JPanel();
        panelMatrize.setOpaque(false); 
        panelMatrize.setLayout(new GridLayout(11, 17, 0, -5)); 
        irudia.add(panelMatrize, BorderLayout.CENTER); 

        //Kontroladorea
        kontroladorea = new Kontroladorea();
        addKeyListener(kontroladorea);
        requestFocusInWindow(); 
        }
     
    private void argazkiTamainaBerritu() {
        int zabalera = getWidth();
        int altuera = getHeight();
        if (zabalera > 0 && altuera > 0) {
            Image argazkiBerria = argazkia.getScaledInstance(zabalera, altuera, Image.SCALE_SMOOTH);
            irudia.setIcon(new ImageIcon(argazkiBerria));
        }
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
    
    public void mugituBomberman(int hX, int hY, Character pNorabide, boolean mugitu) {
    	if (mugitu==true){
    	bilatuGelaxka(x, y).bombermanKendu();
    	}
    	
    	bilatuGelaxka(hX, hY).bombermanJarri(pNorabide);
    	this.x=hX;
    	this.y=hY;
    }

    // Controlador de teclado separado de "Controler"
    private class Kontroladorea extends Observable implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            Eredua.LabirintoaKlasikoa labirintoa = Eredua.LabirintoaKlasikoa.getNireLabirintoKlasikoa();
            switch (keyCode) {
                case KeyEvent.VK_W:
                    labirintoa.mugituBomberman('W');
                    break;
                case KeyEvent.VK_S:
                	labirintoa.mugituBomberman('S');
                    break;
                case KeyEvent.VK_A:
                	labirintoa.mugituBomberman('A');
                    break;
                case KeyEvent.VK_D:
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
		GelaxkaBista gelaxka;
		
		if (arg.equals("Matrizea sortu da")) { 
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 17; j++) {
					gelaxka=new GelaxkaBista(i,j,false);
					this.gehituGelaxka(gelaxka);
				}
			}
			bilatuGelaxka(0,0).bombermanJarri('H');
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
				boolean mugitu = (boolean) obj[4];
				this.mugituBomberman(i, j, norabide,mugitu);;
			} else if (obj[0].equals("BombaJarri")) {
				int i = (int) obj[1];
				this.eguneratuBombaKop(i);
			} else if(obj[0].equals("Jokua amaitu da")) {
				String izenburua;
				String mezua;
				if (obj[1].equals(2)) {
					izenburua="Zorionak";
					mezua="Jokua irabazi duzu, sakatu 'Ados' irteteko.";
				}
				else {
					izenburua="Game Over";
					mezua="Bomberman hil egin da sakatu 'Ados' irteteko.";
				}
				Object[] opciones = {"Ados"};
			    JOptionPane.showOptionDialog(
			            Bista.LabirintoBista.getNireLabirintoBista(),
			            mezua,
			            izenburua,
			            JOptionPane.DEFAULT_OPTION,
			            JOptionPane.INFORMATION_MESSAGE,
			            null,
			            opciones,
			            null); 
			}
			else if (obj[0].equals("Biratu")){
				this.mugituBomberman(x, y, (char) obj[3],false);
			}
		} 

		
	}
	
	public void eguneratuBombaKop(int pKop) {
		bombaKop.setText(":  "+ pKop);
		
	}
		
}
