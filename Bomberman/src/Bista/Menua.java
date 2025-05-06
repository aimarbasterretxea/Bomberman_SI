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
    private Kontroladorea kontroladorea = null;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final ButtonGroup labirintoGroup;
    private final ButtonGroup bomberGroup;
    private JButton bomberZuria;
    private JButton bomberBeltza;
    private JButton bomberRandom;
    private JButton btnKlasikoa;
    private JButton btnBiguna;
    private JButton btnHutsa;
    private JButton jolastuButton;
    private JLabel erroreMezua;
    private JButton etsaiaNormala;
    private JButton etsaiaInteligentea;

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
    private Menua() {
        setResizable(false);
        Jokua.getJokua().addObserver(this);
        labirintoGroup = new ButtonGroup();
        bomberGroup = new ButtonGroup();
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(Menua.class.getResource("/irudiak/whitewithbomb1.png")));
        setAlwaysOnTop(true);
        setTitle("BomberMan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 100, 650, 550);
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
                jolastuButton.setBackground(new Color(230, 145, 56));
            }
            public void mouseExited(MouseEvent e) {
                jolastuButton.setBackground(new Color(255, 140, 0));
            }
        });
        
        jolastuButton.setBackground(new Color(255, 140, 0));
        jolastuButton.setForeground(SystemColor.control);
        jolastuButton.setBorderPainted(false);
        jolastuButton.setSelectedIcon(new ImageIcon(Menua.class.getResource("/irudiak/whiteright2.png")));
        jolastuButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        jolastuButton.addActionListener(getKontroladorea());
        jolastuButton.setBounds(250, 430, 136, 38);
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
        bomberZuria.setBounds(167, 244, 65, 63);
        bomberZuria.setBorderPainted(false);
        bomberZuria.addActionListener(getKontroladorea());
        contentPane.add(bomberZuria);
        
        bomberBeltza = new JButton("");
        bomberBeltza.setToolTipText("B_BELTZA: bomberman honek bomba handi bat izango du 3s-ro");
        bomberBeltza.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/blackfront1.png")));
        bomberBeltza.setForeground(SystemColor.control);
        bomberBeltza.setBackground(SystemColor.control);
        bomberBeltza.setBounds(283, 244, 65, 63);
        bomberBeltza.addActionListener(getKontroladorea());
        bomberBeltza.setBorderPainted(false);
        contentPane.add(bomberBeltza);
        
        btnKlasikoa = new JButton("");
        btnKlasikoa.setToolTipText("KLASIKOA: \r\nLabirinto honetan bloke bigun eta gogorrak sortuko dira");
        btnKlasikoa.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/hard1.png")));
        btnKlasikoa.setForeground(SystemColor.desktop);
        btnKlasikoa.setBorderPainted(false);
        btnKlasikoa.setBackground(SystemColor.control);
        btnKlasikoa.setBounds(167, 147, 65, 63);
        btnKlasikoa.addActionListener(getKontroladorea());
        contentPane.add(btnKlasikoa);
        
        btnBiguna = new JButton("");
        btnBiguna.setToolTipText("BIGUNA: Labirinto honetan bloke bigunak bakarrik sortuko dira");
        btnBiguna.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/soft4.png")));
        btnBiguna.setForeground(SystemColor.desktop);
        btnBiguna.setBorderPainted(false);
        btnBiguna.setBackground(SystemColor.control);
        btnBiguna.setBounds(283, 147, 65, 63);
        btnBiguna.addActionListener(getKontroladorea());
        contentPane.add(btnBiguna);
        
        btnHutsa = new JButton("");
        btnHutsa.setToolTipText("HUTSA: Labirinto honetan ez da inongo blokerik sortuko");
        btnHutsa.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/flower2.png")));
        btnHutsa.setForeground(SystemColor.desktop);
        btnHutsa.setBorderPainted(false);
        btnHutsa.setBackground(SystemColor.control);
        btnHutsa.addActionListener(getKontroladorea());
        btnHutsa.setBounds(399, 147, 65, 63);
        contentPane.add(btnHutsa);
        
        erroreMezua = new JLabel("lehenik aukeratu Bomberman, Labirinto mota eta etsai mota jolasteko!");
        erroreMezua.setHorizontalAlignment(SwingConstants.CENTER);
        erroreMezua.setForeground(new Color(204, 0, 0));
        erroreMezua.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        erroreMezua.setBounds(120, 478, 391, 25);
        contentPane.add(erroreMezua);
        
        bomberRandom = new JButton("");
        bomberRandom.setToolTipText("B_Random: bomberman honek 20 bomba random izango ditu");
        bomberRandom.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/randomfront1.png")));
        bomberRandom.setForeground(SystemColor.control);
        bomberRandom.setBorderPainted(false);
        bomberRandom.setBackground(SystemColor.control);
        bomberRandom.addActionListener(getKontroladorea());
        bomberRandom.setBounds(399, 244, 65, 63);
        contentPane.add(bomberRandom);
        
        JLabel lblNewLabel_2_1 = new JLabel("Etsaiak:");
        lblNewLabel_2_1.setForeground(new Color(0, 0, 102));
        lblNewLabel_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        lblNewLabel_2_1.setBounds(99, 317, 126, 17);
        contentPane.add(lblNewLabel_2_1);
        
        etsaiaNormala = new JButton("");
        etsaiaNormala.setToolTipText("Etsai_1: Etsai honek arruntak izango dira");
        etsaiaNormala.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/doria2.png")));
        etsaiaNormala.setForeground(SystemColor.control);
        etsaiaNormala.setBorderPainted(false);
        etsaiaNormala.setBackground(SystemColor.control);
        etsaiaNormala.setBounds(229, 340, 65, 63);
        etsaiaNormala.addActionListener(getKontroladorea());
        contentPane.add(etsaiaNormala);
        
        etsaiaInteligentea = new JButton("");
        etsaiaInteligentea.setToolTipText("Etsai_2: Etsai honek inteligenteak izango dira\r\n");
        etsaiaInteligentea.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/baloon1.png")));
        etsaiaInteligentea.setForeground(SystemColor.control);
        etsaiaInteligentea.setBorderPainted(false);
        etsaiaInteligentea.setBackground(SystemColor.control);
        etsaiaInteligentea.setBounds(342, 340, 65, 63);
        etsaiaInteligentea.addActionListener(getKontroladorea());
        contentPane.add(etsaiaInteligentea);
        
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
        private String etsaiAukera = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            Object jatorria = e.getSource();
            if (jatorria == jolastuButton) {
                if(labAukera==""||bomberAukera==""||etsaiAukera=="") {
                    erroreMezua.setVisible(true);
                    jolastuButton.setBounds(250, 305, 136, 38);
                } else {
                    menuaItxi();
                    Jokua.getJokua().jokuaHasieratu(labAukera, bomberAukera, etsaiAukera);
                }
            }
            if(jatorria == bomberZuria) {
                bomberZuria.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/whitehappy2.png")));
                bomberZuria.setBackground(new Color(204, 204, 204));
                bomberZuria.setBounds(167, 241, 65, 63);
                
                bomberBeltza.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/blackfront1.png")));
                bomberBeltza.setBackground(SystemColor.control);
                bomberBeltza.setBounds(283, 244, 65, 63);
                
                bomberRandom.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/randomfront1.png")));
                bomberRandom.setBackground(SystemColor.control);
                bomberRandom.setBounds(399, 244, 65, 63);
                
                this.bomberAukera = "white";
            }
            if(jatorria == bomberBeltza) {
                bomberBeltza.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/blackhappy2.png")));
                bomberBeltza.setBackground(new Color(204, 204, 204));
                bomberBeltza.setBounds(283, 241, 65, 63);
                
                bomberZuria.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/whitefront1.png")));
                bomberZuria.setBackground(SystemColor.control);
                bomberZuria.setBounds(167, 244, 65, 63);
                
                bomberRandom.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/randomfront1.png")));
                bomberRandom.setBackground(SystemColor.control);
                bomberRandom.setBounds(399, 244, 65, 63);
                
                this.bomberAukera = "black";   
            }
            if(jatorria == bomberRandom) {
                bomberRandom.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/randomhappy2.png")));
                bomberRandom.setBackground(new Color(204, 204, 204));
                bomberRandom.setBounds(399, 241, 65, 63);
                
                bomberZuria.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/whitefront1.png")));
                bomberZuria.setBackground(SystemColor.control);
                bomberZuria.setBounds(167, 244, 65, 63);
                
                bomberBeltza.setIcon(new ImageIcon(Menua.class.getResource("/irudiak/blackfront1.png")));
                bomberBeltza.setBackground(SystemColor.control);
                bomberBeltza.setBounds(283, 244, 65, 63);
                
                this.bomberAukera = "random";   
            }
            if(jatorria == btnKlasikoa) {
                btnKlasikoa.setBackground(new Color(204, 204, 204));
                btnBiguna.setBackground(SystemColor.control);
                btnHutsa.setBackground(SystemColor.control);
                btnKlasikoa.setBounds(167, 144, 65, 63);
                
                btnBiguna.setBounds(283, 147, 65, 63);
                btnHutsa.setBounds(399, 147, 65, 63);
                
                this.labAukera = "Klasikoa";
            }
            if(jatorria == btnBiguna) {
                btnKlasikoa.setBackground(SystemColor.control);
                btnBiguna.setBackground(new Color(204, 204, 204));
                btnHutsa.setBackground(SystemColor.control);
                btnBiguna.setBounds(283, 144, 65, 63);
                
                btnKlasikoa.setBounds(167, 147, 65, 63);
                btnHutsa.setBounds(399, 147, 65, 63);
                
                this.labAukera = "Biguna";
            }
            if(jatorria == btnHutsa) {
                btnKlasikoa.setBackground(SystemColor.control);
                btnBiguna.setBackground(SystemColor.control);
                btnHutsa.setBackground(new Color(204, 204, 204));
                btnHutsa.setBounds(399, 144, 65, 63);
                
                btnKlasikoa.setBounds(167, 147, 65, 63);
                btnBiguna.setBounds(283, 147, 65, 63);
                
                this.labAukera = "Hutsa";
            }
            if(jatorria == etsaiaNormala) {
                etsaiaNormala.setBackground(new Color(204, 204, 204));
                etsaiaNormala.setBounds(229, 337, 65, 63);
                
                etsaiaInteligentea.setBackground(SystemColor.control);
                etsaiaInteligentea.setBounds(342, 340, 65, 63);
                
                this.etsaiAukera = "Normala";
            }
            if(jatorria == etsaiaInteligentea) {
                etsaiaInteligentea.setBackground(new Color(204, 204, 204));
                etsaiaInteligentea.setBounds(342, 337, 65, 63);
                
                etsaiaNormala.setBackground(SystemColor.control);
                etsaiaNormala.setBounds(229, 340, 65, 63);
                
                this.etsaiAukera = "Inteligente";
            }
        }

        public void itemStateChanged(ItemEvent e) {}
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(labAukera==null||bomberAukera==null||etsaiAukera==null) {
                    erroreMezua.setVisible(true);
                } else {
                    Jokua.getJokua().jokuaHasieratu(labAukera, bomberAukera, etsaiAukera);
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