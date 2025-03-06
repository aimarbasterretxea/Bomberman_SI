package Bista;

import Eredua.Bomberman;
import Eredua.MatrizeClassic;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

public class Matrize_Bista extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private static Matrize_Bista nireMatrizea;
    private BombermanController controller; // Controlador de teclado
    private static int x;
    private static int y;

    public static Matrize_Bista getNireMatrizea() {
        if (nireMatrizea == null) {
            nireMatrizea = new Matrize_Bista();
        }
        return nireMatrizea;
    }

    private Matrize_Bista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(1, 1, 5, 5));
        contentPane.setLayout(new GridLayout(11, 17, 0, 0));
        setContentPane(contentPane);

        // Agregar el controlador de teclado
        controller = new BombermanController();
        addKeyListener(controller);
        requestFocusInWindow(); // Asegurar que la ventana tenga el foco
    }

    public static void gehituLaukia(Laukia_Bista pLaukiaBista) {
        contentPane.add(pLaukiaBista);
    }

    public Laukia_Bista bilatuLaukia(int x, int y) {
        return (Laukia_Bista) contentPane.getComponent(x * 17 + y);
    }
    
    public void mugituBomberman(int hX, int hY){
    	bilatuLaukia(x, y).bombermanKendu();
    	bilatuLaukia(hX, hY).bombermanJarri();
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
    private class BombermanController extends Observable implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_W:
                    //System.out.println("parriba");
                    Eredua.MatrizeClassic.getNireMatrizea().mugituBomberman('W');
                    break;
                case KeyEvent.VK_S:
                    //System.out.println("pabajo");
                    Eredua.MatrizeClassic.getNireMatrizea().mugituBomberman('S');
                    break;
                case KeyEvent.VK_A:
                    //System.out.println("paizda");
                    Eredua.MatrizeClassic.getNireMatrizea().mugituBomberman('A');
                    break;
                case KeyEvent.VK_D:
                    //System.out.println("padcha");
                    Eredua.MatrizeClassic.getNireMatrizea().mugituBomberman('D');
                    break;
                case KeyEvent.VK_SPACE:
					Eredua.MatrizeClassic.getNireMatrizea().getBomberman().bombaJarri();
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
		MatrizeClassic matrizea = MatrizeClassic.getNireMatrizea();
		if (arg.equals("Matrizea sortu da")) {
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 17; j++) {
					this.gehituLaukia(new Laukia_Bista(i, j, false))
					;
				}
			}
			bilatuLaukia(0,0).bombermanJarri();
			this.x = 0;
			this.y = 0;
		}
		else if (arg instanceof Object[]) {
			Object[] obj = (Object[]) arg;
			if (obj[0].equals("Bloke gogorra gehitu da")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.bilatuLaukia(i, j).blokeGogorra();
			}
			else if (obj[0].equals("Bloke biguna gehitu da")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.bilatuLaukia(i, j).blokeBiguna();
			}
			else if (obj[0].equals("Move")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.mugituBomberman(i, j);;
				
				//System.out.println("WASD");
			}
			/*else if (obj[0].equals("BombaJarri")) {
				int i = (int) obj[1];
				int j = (int) obj[2];
				this.bilatuLaukia(i, j).bombaJarri();
								
			}*/
			
		}
		else if(arg.equals("Jokua amaitu da")) {
			//contentPane.removeAll();
			System.out.println("Jokua amaitu da");
			this.dispose(); 
	
		}
		else {System.out.println("BombaJarri");}
		
	}
	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}*/
}
