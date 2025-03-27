package Bista;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eredua.Jokua;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;

public class Menua extends JFrame implements Observer {

	private static Menua nireMenua;
	private Kontroladorea kontroladorea=null;
	
	//Botoiak
	private JRadioButton classicButton;
	private JRadioButton softButton;
	private JRadioButton emptyButton;
	private JRadioButton whiteBomber;
	private JRadioButton blackBomber;
	
	private JButton jolastuButton;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup;
	private final ButtonGroup buttonGroup_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menua frame = new Menua();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menua() {
		Jokua.getJokua().addObserver(this);
		buttonGroup = new ButtonGroup();
		buttonGroup_1 = new ButtonGroup();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menua.class.getResource("/irudiak/blackfront1.png")));
		setAlwaysOnTop(true);
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Laberintoa");
		lblNewLabel_1.setBounds(49, 139, 64, 13);
		contentPane.add(lblNewLabel_1);
		
		classicButton = new JRadioButton("Classic");
		buttonGroup.add(classicButton);
		classicButton.setBounds(119, 135, 57, 21);
		classicButton.addItemListener(getKontroladorea());
		contentPane.add(classicButton);
		
		softButton = new JRadioButton("Soft");
		buttonGroup.add(softButton);
		softButton.setBounds(178, 135, 43, 21);
		softButton.addItemListener(getKontroladorea());
		contentPane.add(softButton);
		
		emptyButton = new JRadioButton("Empty");
		buttonGroup.add(emptyButton);
		emptyButton.setBounds(237, 135, 57, 21);
		emptyButton.addItemListener(getKontroladorea());
		contentPane.add(emptyButton);
		
		JLabel lblNewLabel_2 = new JLabel("Bomberman");
		lblNewLabel_2.setBounds(49, 188, 90, 13);
		contentPane.add(lblNewLabel_2);
		
		whiteBomber = new JRadioButton("White");
		buttonGroup_1.add(whiteBomber);
		whiteBomber.setBounds(118, 184, 57, 21);
		whiteBomber.addItemListener(getKontroladorea());
		contentPane.add(whiteBomber);
		
		blackBomber = new JRadioButton("Black");
		buttonGroup_1.add(blackBomber);
		blackBomber.setBounds(184, 184, 57, 21);
		blackBomber.addItemListener(getKontroladorea());
		contentPane.add(blackBomber);
		
		jolastuButton = new JButton("Jolastu");
		jolastuButton.addActionListener(getKontroladorea());
		jolastuButton.setBounds(311, 215, 85, 21);
		contentPane.add(jolastuButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/title.png")));
		lblNewLabel_3.setBounds(19, 10, 397, 100);
		contentPane.add(lblNewLabel_3);
	}
	
	public static Menua getNireMenua() {
		if (nireMenua == null) {
			nireMenua = new Menua();
		}
		return nireMenua;
	}
	
	public void menuaItxi() {
		this.setVisible(false);
		this.dispose();
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	//KONTROLADOREA
	private Kontroladorea getKontroladorea() {
		if (kontroladorea == null) {
			kontroladorea = new Kontroladorea();
		}
		return kontroladorea;
	}

	private class Kontroladorea extends Observable implements ActionListener, ItemListener {
	    private String labAukera = "";
	    private String bomberAukera = "";

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        Object jatorria = e.getSource();
	        if (jatorria == jolastuButton) {
	            menuaItxi();
	            System.out.println("Jolastu botoia sakatu duzu");
	            System.out.println("Zure aukerak:");
	            System.out.println(labAukera);
	            System.out.println(bomberAukera);
	            Jokua.getJokua().jokuaHasieratu(labAukera, bomberAukera);
	        }
	    }

	    public void itemStateChanged(ItemEvent e) {
	        Object jatorria = e.getSource();
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            if (jatorria == classicButton) {
	                labAukera = "Klasikoa";
	                System.out.println("Classic selected");
	            }
	            if (jatorria == softButton) {
	                labAukera = "Biguna";
	                System.out.println("Soft selected");
	            }
	            if (jatorria == emptyButton) {
	                labAukera = "Hutsa";
	                System.out.println("Empty selected");
	            }
	            if (jatorria == blackBomber) {
	                bomberAukera = "black";
	                System.out.println("Black Bomber selected");
	            }
	            if (jatorria == whiteBomber) {
	                bomberAukera = "white";
	                System.out.println("White Bomber selected");
	            }
	        }
	    }
	}

}