package Bista;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Eredua.Jokua;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;

public class Menua extends JFrame implements Observer {

	private static Menua nireMenua;
	private Kontroladorea kontroladorea;
	
	//Botoiak
	private JRadioButton classicButton;
	private JRadioButton softButton;
	private JRadioButton emptyButton;
	private JRadioButton whiteBomber;
	private JRadioButton blackBomber;
	
	private JButton jolastuButton;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

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
		kontroladorea = new Kontroladorea();
	
		
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
		classicButton.addActionListener(kontroladorea);
		contentPane.add(classicButton);
		
		softButton = new JRadioButton("Soft");
		buttonGroup.add(softButton);
		softButton.setBounds(178, 135, 43, 21);
		softButton.addActionListener(kontroladorea);
		contentPane.add(softButton);
		
		emptyButton = new JRadioButton("Empty");
		buttonGroup.add(emptyButton);
		emptyButton.setBounds(237, 135, 57, 21);
		emptyButton.addActionListener(kontroladorea);
		contentPane.add(emptyButton);
		
		JLabel lblNewLabel_2 = new JLabel("Bomberman");
		lblNewLabel_2.setBounds(49, 188, 90, 13);
		contentPane.add(lblNewLabel_2);
		
		whiteBomber = new JRadioButton("White");
		buttonGroup_1.add(whiteBomber);
		whiteBomber.setBounds(118, 184, 57, 21);
		whiteBomber.addActionListener(kontroladorea);
		contentPane.add(whiteBomber);
		
		blackBomber = new JRadioButton("Black");
		buttonGroup_1.add(blackBomber);
		blackBomber.setBounds(184, 184, 57, 21);
		blackBomber.addActionListener(kontroladorea);
		contentPane.add(blackBomber);
		
		JButton jolastuButton = new JButton("Jolastu");
		jolastuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	private class Kontroladorea extends Observable implements ActionListener {
       
       	@Override
		public void actionPerformed(ActionEvent e) {
       		Object jatorria = e.getSource();
       		String labAukera = "";
       		String bomberAukera = "";
       		
       		if(jatorria == classicButton) {
       			labAukera = "Classic";
       		}
       		if(jatorria == softButton) {
       			labAukera = "Soft";
       		}
       		if(jatorria == emptyButton) {
       			labAukera = "Empty";
       		}
       		if(jatorria == blackBomber) {
       			bomberAukera = "Black";
	   		}
       		if(jatorria == whiteBomber) {
       			bomberAukera = "White";
	   		}
       		
       		if(jatorria == jolastuButton) {
	   			Jokua.getJokua().Hasieraketa();
	   		}
			// TODO Auto-generated method stub
			
		}
    }




}