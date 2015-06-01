package Principal;

import java.awt.BorderLayout;
import java.applet.AudioClip;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;






import Modelo.ModeloVerificacion;
import Modelo.modeloCorredores;


public class Primera extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel pantalla;
	public static JPasswordField CampoContra;
	modeloCorredores usuarios;
	ModeloVerificacion verificacion;
	AudioClip sonido;
	

	public Primera() {

		setEnabled(true);


		setResizable(false);
		sonido= java.applet.Applet.newAudioClip(getClass().getResource("../Principal/imagenes/primeraVentana.mp3"));
		sonido.play();
		
		
		setIconImage(new ImageIcon(getClass().getResource("../Principal/icono.png")).getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 90, 900, 600);
		pantalla = new Fondo("/Principal/imagenes/fondoPrimera.png");
		pantalla.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pantalla);
		pantalla.setLayout(null);
		setTitle("Bingo twist");
		
		JComboBox Desplegable = new JComboBox();
		Desplegable.setEditable(false);
		
		
		Desplegable.setBounds(443, 431, 147, 17);
		pantalla.add(Desplegable);
		

		
		CampoContra = new JPasswordField();
		CampoContra.setBounds(443, 460, 147, 18);
		pantalla.add(CampoContra);
		
		
		JButton Entrar = new JButton("Enter");
		Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				verificacion=new ModeloVerificacion();
		
				String Seleccion = (String) Desplegable.getSelectedItem();
				String contrasena=verificacion.Verificacion(Seleccion);
				System.out.println(Seleccion); 
				
				if(CampoContra.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Please Enter a Password", "Bingo Twist", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/Principal/imagenes/iconoJOption.jpg"));
					jugadores VentPrinc = new jugadores();
					VentPrinc.setVisible (false);

						
					}
				
				else{
					
					//verificacion.Verificacion();
					char[] Contra = CampoContra.getPassword(); 
					
					
					
					if  (contrasena.equals(String.valueOf(Contra)))
					{
						//System.out.println("Contraseña correcta");
						
						JOptionPane.showMessageDialog (null, "Bienvenido, ya puedes jugar "
								+ "\n YA PUEDES JUGAR", "CONECTADO", JOptionPane.INFORMATION_MESSAGE);
						Primera.this.dispose();
						jugadores VentPrinc1 = new jugadores();		
						VentPrinc1.setVisible (true);
					}else{
						
						JOptionPane.showMessageDialog(null, "La contraseña no es correcta"
								+ "\n No puedes acceder al juego", "CONTRASEÑA INCORRECTA", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
								
					
					
						//System.out.println("Debes introducir la contraseña correcta"); 
						
					}
				
					
				}

				
			}
			
			
		});	
		Entrar.setBounds(357, 503, 89, 23);
		pantalla.add(Entrar);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(getClass().getResource("/Principal/imagenes/logoBingoNuevo.png")));
		logo.setBounds(77, 43, 700, 294);
		pantalla.add(logo);
	

		JLabel Username = new JLabel("Username");
		Username.setForeground(Color.WHITE);
		Username.setBounds(373, 434, 60, 14);
		pantalla.add(Username);
	

		
		JLabel Password = new JLabel("Password");
		Password.setForeground(Color.WHITE);
		Password.setBounds(373, 462, 63, 14);
		pantalla.add(Password);
		
	
		
		JButton Salir = new JButton("Leave");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				Primera.this.dispose();							
			}
		});	
		
		Salir.setBounds(501, 503, 89, 23);
		pantalla.add(Salir);
		
		
		
		
		//Rellenamos JComboBox
		
				usuarios=new modeloCorredores();
				
				Iterator<String> it=usuarios.getusuarios().iterator();
				while(it.hasNext()){
					Desplegable.addItem((String)it.next());

					
				}
				
				
				
				

	}
	
	

}
