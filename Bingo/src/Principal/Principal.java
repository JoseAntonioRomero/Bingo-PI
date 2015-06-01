package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuBar;

import java.awt.Button;

import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import java.awt.List;

import javax.swing.JRadioButton;
import javax.swing.JTree;
import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;

import java.awt.Color;

import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import Modelo.ModeloVerificacion;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import juego.Cartones;
import juego.Player;


public class Principal extends JFrame {

	private JPanel pantalla;
    private JLabel marcador[]=new JLabel[91];
    private JLabel SacaBolas=new JLabel();
    private int a=0;
    private int cont=0;
    private int numeroCartones;
    private int numero[]= new int [91];





	public Principal(int numeroJugadores, ArrayList nombreJugadores) {
		setResizable(false);

		setEnabled(true);


		setIconImage(new ImageIcon(getClass().getResource("../Principal/icono.png")).getImage());
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 90, 900, 600);
		pantalla = new Fondo("/Principal/imagenes/fondoPrincipal.jpg");
		pantalla.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla);
		pantalla.setLayout(null);

		setTitle("Bingo twist");
		
		// Añade marcador de bolas salidas
		for (int i=0;i<=8;i++){
			for (int j=0;j<=9;j++){
				cont=cont+1;
		marcador[cont]=new JLabel();	
		marcador[cont].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Rojos/"+cont+".png"))));
		marcador[cont].setBounds(10+j*60, 10+i*45, 38, 38);
		pantalla.add(marcador[cont]);
		SacaBolas=new JLabel();
		SacaBolas.setBounds(140,450, 100, 100);
		}}
		
		
		JButton Salir = new JButton("Salir");
		Salir.setBackground(Color.ORANGE);
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				Principal.this.dispose();						
			}
		});	
		
		Salir.setBounds(470, 494, 126, 56);
		pantalla.add(Salir);
		

		JButton PartidaNueva = new JButton("Partida Nueva");
		PartidaNueva.setBackground(Color.CYAN);
		PartidaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal VentPrinc = new Principal(numeroJugadores, nombreJugadores);
				VentPrinc.setVisible (true);
				Principal.this.dispose();
				reiniciar();			
			}
		});
		PartidaNueva.setBounds(470, 424, 126, 56);
		pantalla.add(PartidaNueva);
		
		JButton BolaNueva = new JButton("Bola Nueva");
		BolaNueva.setForeground(Color.WHITE);
		BolaNueva.setBackground(Color.MAGENTA);
		BolaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				SacaBolas.setVisible(true);
				if (cont>=90){cont=0;};
				do
				a=(int)(Math.random()*90+1);
				while (numero[a]!=0);
				cont=cont+1;
				if (SacaBolas!=null){SacaBolas.removeAll();}
				pantalla.repaint();
				marcador[a].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Azules/"+a+".png"))));
				SacaBolas.setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Bolas/bolaBingo"+a+".png"))));
				pantalla.add(SacaBolas);
				pantalla.repaint();
				if (cont==90){
					cont=0;
					for (int i=1;i<91;i++){numero[i]=0;
					marcador[i].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Rojos/"+i+".png"))));
					pantalla.repaint();}
					for (int i=1;i<91;i++){numero[i]=0;}
					}else{numero[a]=1;}
			}}
		);
		
		
		
		BolaNueva.setBounds(351, 424, 109, 126);
		pantalla.add(BolaNueva);
		
		JButton Linea = new JButton("");
		Linea.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/btnLinea.png")));
		
		Linea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				JOptionPane.showMessageDialog(null, "Han cantado Linea!!!!!", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));			
			}
		});	
		Linea.setBounds(606, 11, 109, 50);
		pantalla.add(Linea);
		
		JButton Bingo = new JButton("");
		Bingo.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/btnBingo.png")));
		Bingo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
			
				JOptionPane.showMessageDialog(null, "Han cantado Bingo!!!!!", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));	
				
			}
		});	
		Bingo.setBounds(765, 11, 109, 50);
		pantalla.add(Bingo);
		
		JTabbedPane panelPestaña = new JTabbedPane(JTabbedPane.TOP);

		panelPestaña.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		panelPestaña.setBounds(606, 75, 270, 475);
		panelPestaña.setBounds(606, 75, 268, 475);
		
		//panelPestaña.setLayout(new BoxLayout(panelPestaña, BoxLayout.Y_AXIS));
		pantalla.add(panelPestaña);

		
		Player jugador[]=new Player[numeroJugadores];
		for (int i=0;i<numeroJugadores;i++){
		JPanel panel[] = new JPanel[numeroJugadores];
		
		numeroCartones=(int)(Math.random()*3+1);
		Cartones carton=new Cartones(numeroCartones);
		panel[i]=new JPanel();
		panel[i].add(carton);
		panelPestaña.addTab((String)nombreJugadores.get(i), null, panel[i], null);
		pantalla.add(panelPestaña);
		}
	}
	public void reiniciar(){
		for (int i=1;i<91;i++){numero[i]=0;
		marcador[i].setIcon(new ImageIcon((getClass().getResource("/Principal/imagenes/Botones Rojos/"+i+".png"))));
		}

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(32, 53, 157, -26);
		pantalla.add(layeredPane);
		layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 89, 23);
		panel.add(btnNewButton);
		for (int i=1;i<91;i++){numero[i]=0;}
		SacaBolas.setVisible(false);
		pantalla.repaint();
	}
	}

