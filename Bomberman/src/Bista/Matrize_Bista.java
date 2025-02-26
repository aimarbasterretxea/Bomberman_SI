package Bista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eredua.MatrizeClassic;
import Eredua.Matrizea;

import java.awt.GridLayout;

public class Matrize_Bista extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		});
	}

	/**
	 * Create the frame.
	 */
	public Matrize_Bista() {
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
		
}
