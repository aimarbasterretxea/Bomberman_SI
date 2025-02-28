package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eredua.Laukia;
import Eredua.MatrizeClassic;
import Eredua.Matrizea;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

public class Matrize_Bista extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static Matrize_Bista nireMatrizea;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				  try {
	                    Matrize_Bista frame = new Matrize_Bista();
	                    frame.setVisible(true);

	                    // Crear una instancia de la subclase específica
	                    Eredua.Matrizea.matrizeaOrokorraSortu();
	                  

	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
			}
		});*/
	
	/**
	 * Create the frame.
	 */
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(11, 17, 0, 0));
	}

	
	public static void gehituLaukia(Laukia_Bista pLaukiaBista) {
		contentPane.add(pLaukiaBista);
	}
	public Laukia_Bista bilatuLaukia(int x, int y) {
		return (Laukia_Bista) contentPane.getComponent(x*17+y);
	}
	@Override
	public void update(Observable o, Object arg) {
		MatrizeClassic matrizea = MatrizeClassic.getNireMatrizea();
		if (arg.equals("Matrizea sortu da")) {
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 17; j++) {
					this.gehituLaukia(new Laukia_Bista(i, j, false));
				}
			}
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
		}
		else {System.out.println("Ez da ezer gertatu");}
		
	}
		
}
