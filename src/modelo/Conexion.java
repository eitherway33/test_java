package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
   private static String usuario ; 
   private static String pass; 
   private static  Connection  cn; 
   private  static String url ;
	
	public Conexion() { 
		
		usuario="root"; 
		pass=""; 
		cn = null; 
		url="jdbc:mysql://localhost:3306/tienda?useSSL=false"; 
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			cn= DriverManager.getConnection(url,usuario,pass); 
			System.out.println("Conexión exitosa");
		}catch(Exception e)
		{
			System.out.println("Ocurrió un error"+e);
		} 
	
	} 
	public static Connection getConnection()
	{ 
		if(cn==null)
		{
			new Conexion();
		}
		return cn;
	} 
	
	public void closeConection() throws SQLException
	{
		if(cn!=null)
		{
			cn.close();
		}
	}
	
    public static void main(String qrgs[]) 
    {
    	Conexion.getConnection();
    	 
    }
}
