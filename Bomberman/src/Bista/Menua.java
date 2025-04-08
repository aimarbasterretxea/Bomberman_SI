package Bista;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eredua.Jokua;

import javax.swing.JLabel;
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
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Menua extends JFrame implements Observer {

	private static Menua nireMenua;
	private Kontroladorea kontroladorea=null;
	
	private JButton bomberZuria;
	
	private JButton jolastuButton;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup;
	private final ButtonGroup buttonGroup_1;
	private JButton bomberBeltza;
	private JButton btnKlasikoa;
	private JButton btnBiguna;
	private JButton btnHutsa;
	private JLabel erroreMezua;
	


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
		setResizable(false);
		Jokua.getJokua().addObserver(this);
		buttonGroup = new ButtonGroup();
		buttonGroup_1 = new ButtonGroup();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menua.class.getResource("/irudiak/whitewithbomb1.png")));
		setAlwaysOnTop(true);
		setTitle("BomberMan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 650, 420);
		contentPane = new JPanel(); 
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Labirintoa:");
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(99, 124, 103, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bomberman:");
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(99, 220, 126, 17);
		contentPane.add(lblNewLabel_2);
		
		jolastuButton = new JButton("JOLASTU");
		jolastuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jolastuButton.setBounds(246, 311, 142, 46);
			}
			public void mouseExited(MouseEvent e) {
				jolastuButton.setBounds(250, 315, 136, 38);
			}
		});
		
		jolastuButton.setBackground(new Color(255, 140, 0));
		jolastuButton.setForeground(SystemColor.control);
		jolastuButton.setBorderPainted(false);
		jolastuButton.setSelectedIcon(new ImageIcon(Menua.class.getResource("/irudiak/whiteright2.png")));
		jolastuButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		jolastuButton.addActionListener(getKontroladorea());
		jolastuButton.setBounds(250, 315, 136, 38);
		contentPane.add(jolastuButton);
		
		JLabel izenburuaIrudia = new JLabel("");
		izenburuaIrudia.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/title.png")));
		izenburuaIrudia.setBounds(120, 10, 397, 100);
		contentPane.add(izenburuaIrudia);
		
		bomberZuria = new JButton("");
		bomberZuria.setToolTipText("B_ZURIA: bomberman honek 10 bomba txiki izango ditu ");
		bomberZuria.setBackground(SystemColor.control);
		bomberZuria.setForeground(SystemColor.control);
		bomberZuria.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/whitefront1.png")));
		bomberZuria.setSelectedIcon(new ImageIcon(Menua.class.getResource("/irudiak/whitehappy2.png")));
		bomberZuria.setBounds(235, 220, 65, 71);
		bomberZuria.setBorderPainted(false);
		bomberZuria.addActionListener(getKontroladorea());
		contentPane.add(bomberZuria);
		
		bomberBeltza = new JButton("");
		bomberBeltza.setToolTipText("B_BELTZA: bomberman honek bomba handi bat izango du 3s-ro");
		bomberBeltza.setSelectedIcon(new ImageIcon(Menua.class.getResource("/irudiak/blackdown3.png")));
		bomberBeltza.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/blackfront1.png")));
		bomberBeltza.setForeground(SystemColor.control);
		bomberBeltza.setBackground(SystemColor.control);
		bomberBeltza.setBounds(343, 220, 65, 71);
		bomberBeltza.addActionListener(getKontroladorea());
		bomberBeltza.setBorderPainted(false);
		contentPane.add(bomberBeltza);
		
		btnKlasikoa = new JButton("\r\n");
		btnKlasikoa.setToolTipText("KLASIKOA: \r\nLabirinto honetan bloke bigun eta gogorrak sortuko dira");
		btnKlasikoa.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/hard1.png")));
		btnKlasikoa.setForeground(SystemColor.desktop);
		btnKlasikoa.setBorderPainted(false);
		btnKlasikoa.setBackground(SystemColor.control);
		btnKlasikoa.setBounds(159, 147, 80, 63);
		btnKlasikoa.addActionListener(getKontroladorea());
		contentPane.add(btnKlasikoa);
		
		btnBiguna = new JButton("\r\n");
		btnBiguna.setToolTipText("BIGUNA: Labirinto honetan bloke bigunak bakarrik sortuko dira");
		btnBiguna.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/soft4.png")));
		btnBiguna.setForeground(SystemColor.desktop);
		btnBiguna.setBorderPainted(false);
		btnBiguna.setBackground(SystemColor.control);
		btnBiguna.setBounds(276, 147, 80, 63);
		btnBiguna.addActionListener(getKontroladorea());
		contentPane.add(btnBiguna);
		
		btnHutsa = new JButton("\r\n");
		btnHutsa.setToolTipText("HUTSA: Labirinto honetan ez da inongo blokerik sortuko");
		btnHutsa.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/flower2.png")));
		btnHutsa.setForeground(SystemColor.desktop);
		btnHutsa.setBorderPainted(false);
		btnHutsa.setBackground(SystemColor.control);
		btnHutsa.addActionListener(getKontroladorea());
		btnHutsa.setBounds(393, 147, 80, 63);
		contentPane.add(btnHutsa);
		
		erroreMezua = new JLabel("lehenik aukeratu Bomberman eta Labirinto mota jolasteko!");
		erroreMezua.setHorizontalAlignment(SwingConstants.CENTER);
		erroreMezua.setForeground(new Color(204, 0, 0));
		erroreMezua.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		erroreMezua.setBounds(139, 348, 391, 25);
		contentPane.add(erroreMezua);
		
		JButton btnKlasikoa_1 = new JButton("\r\n");
		btnKlasikoa_1.setToolTipText("KLASIKOA: Labirinto honetan bloke bigun eta gogorrak sortuko dira");
		btnKlasikoa_1.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/hard1.png")));
		btnKlasikoa_1.setForeground(SystemColor.desktop);
		btnKlasikoa_1.setBorderPainted(false);
		btnKlasikoa_1.setBackground(SystemColor.control);
		btnKlasikoa_1.setBounds(159, 147, 80, 63);
		contentPane.add(btnKlasikoa_1);
		erroreMezua.setVisible(false);
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

	private class Kontroladorea extends Observable implements ActionListener, ItemListener, KeyListener {
	    private String labAukera = "";
	    private String bomberAukera = "";

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        Object jatorria = e.getSource();
	        if (jatorria == jolastuButton) {
	            if(labAukera==""||bomberAukera=="") {
	            	erroreMezua.setVisible(true);
	            	jolastuButton.setBounds(250, 305, 136, 38);
	            }else {
	            	         	
	            	menuaItxi();
		            System.out.println("Jolastu botoia sakatu duzu");
		            System.out.println("Zure aukerak:");
		            System.out.println(labAukera);
		            System.out.println(bomberAukera);
		            Jokua.getJokua().jokuaHasieratu(labAukera, bomberAukera);
	            }
	        }
	        if(jatorria == bomberZuria) {
	        	bomberZuria.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/whitehappy2.png")));
	        	bomberZuria.setBackground(new Color(204, 204, 204));
	        	bomberZuria.setBounds(235, 217, 65, 71);
	        	
	        	bomberBeltza.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/blackfront1.png")));
	        	bomberBeltza.setBackground(SystemColor.control);
	        	bomberBeltza.setBounds(343, 220, 65, 71);
	        	
	        	this.bomberAukera = "white";
	        }
	        if(jatorria == bomberBeltza) {
	        	bomberBeltza.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/blackdown3.png")));
	        	bomberBeltza.setBackground(new Color(204, 204, 204));
	        	bomberBeltza.setBounds(343, 217, 65, 71);
	        	
	        	bomberZuria.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/whitefront1.png")));
	        	bomberZuria.setBackground(SystemColor.control);
	        	bomberZuria.setBounds(235, 220, 65, 71);
	        	this.bomberAukera = "black";	 	
	        }
	        if(jatorria == btnKlasikoa) {
	        	btnKlasikoa.setBackground(new Color(204, 204, 204));
	        	btnBiguna.setBackground(SystemColor.control);
	        	btnHutsa.setBackground(SystemColor.control);
	        	btnKlasikoa.setBounds(159, 144, 80, 63);
	        	
	        	btnBiguna.setBounds(276, 147, 80, 63);
	        	btnHutsa.setBounds(393, 147, 80, 63);
	        	
	        	this.labAukera = "Klasikoa";
	        }
	        if(jatorria == btnBiguna) {
	        	btnKlasikoa.setBackground(SystemColor.control);
	        	btnBiguna.setBackground(new Color(204, 204, 204));
	        	btnHutsa.setBackground(SystemColor.control);
	        	btnBiguna.setBounds(276, 144, 80, 63);
	        	
	        	btnKlasikoa.setBounds(159, 147, 80, 63);
	        	btnHutsa.setBounds(393, 147, 80, 63);
	        	
	        	this.labAukera = "Biguna";
	        }
	        if(jatorria == btnHutsa) {
	        	btnKlasikoa.setBackground(SystemColor.control);
	        	btnBiguna.setBackground(SystemColor.control);
	        	btnHutsa.setBackground(new Color(204, 204, 204));
	        	btnHutsa.setBounds(393, 144, 80, 63);
	        	
	        	btnKlasikoa.setBounds(159, 147, 80, 63);
	        	btnBiguna.setBounds(276, 147, 80, 63);
	        	
	        	this.labAukera = "Hutsa";
	        }
        	
	    }

	    
	    
	    public void itemStateChanged(ItemEvent e) {
	              	
	        }
	    @Override
	    public void keyPressed(KeyEvent e) {
	    	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	    		if(labAukera==null||bomberAukera==null) {
	    			erroreMezua.setVisible(true);
	    			
	    		}else {
	    				Jokua.getJokua().jokuaHasieratu(labAukera, bomberAukera);
	    			}
	    			
	    	}
	    }



		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	    }
}