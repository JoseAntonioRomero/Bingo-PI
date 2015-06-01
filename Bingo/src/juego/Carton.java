package juego;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import Modelo.modeloCorredores;

public class Carton<setBounds> extends JPanel{
	
	private int numeroCarton=(int) (Math.random()*19+1);
	private int cont=0;
	private ArrayList<String> numerosCarton;
	private String numeros;
	private String[] secuenciaNumeros;
	private JLabel[] dibujoNumerosCarton=new JLabel[28];
	static final String NUMEROS="SELECT NUMEROS FROM CARTONES WHERE NUM_CARTON =";
	private modeloCorredores mu;
	private Connection conexion = null;// maneja la conexión
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;

	public Carton() {
		setNumeroCarton(numeroCarton);
		setBorder(new TitledBorder(null, "carton n\u00BA:"+numeroCarton, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(236, 233, 216));
		setBounds(10,10,275,120);
		setLayout(new MigLayout("", "[25.00px]", "[25.00px]"));
		
		mu=new modeloCorredores();
		numeros=mu.getNumeros(numeroCarton);
		System.out.println(numeros);
		secuenciaNumeros=numeros.split(",");
		System.out.println(secuenciaNumeros);
			for (int k=0;k<3;k++){
				for (int j=0;j<9;j++){
					cont=cont+1;
					dibujoNumerosCarton[cont]=new JLabel();	
					dibujoNumerosCarton[cont].setIcon(new ImageIcon((getClass().getResource("/numerosCarton/"+secuenciaNumeros[cont-1]+".png"))));
					this.add(dibujoNumerosCarton[cont], "cell "+j+" "+k+",alignx center,aligny center");
				}
			}
				
		
	}
	public void setNumeroCarton(int numeroCarton){
		if (numeroCarton<20){
			numeroCarton=numeroCarton+1;
		}else{numeroCarton=1;}	
		System.out.println(numeroCarton+"\n");

		}
	}


