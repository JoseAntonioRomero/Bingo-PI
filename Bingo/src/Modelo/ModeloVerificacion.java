package Modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Principal.Primera;

import com.mysql.jdbc.ResultSetMetaData;


public class ModeloVerificacion {
	
	Primera nombre;

	
	private static String CONTRA_SEL="SELECT contrasena FROM Jugadores where nombre=";
	
	
	//Conexion
	private static Connection conexion = null; //maneja la conexión
	static Statement instruccion = null;
	ResultSet resultado=null;
	String contrasena=null;
	
	
	
	public ModeloVerificacion() {
		conexion=ConexionDB.getConexion();
	}
	
	
	
	public String Verificacion(String nombre){
		
		try{
			instruccion = conexion.createStatement();
			resultado = instruccion.executeQuery(CONTRA_SEL+"'"+nombre+"'");
			if(resultado.next()){
				contrasena=resultado.getString("contrasena");
			}
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			
		}
		finally{
			try{
				//conjuntoResultados.close();
				instruccion.close();
				//conexion.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
		return contrasena;
	}
	
	

}