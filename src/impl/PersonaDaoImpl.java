package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import dao.PersonaDao;
import modelo.Conexion;
import modelo.Persona;

public class PersonaDaoImpl  implements PersonaDao{

	public PersonaDaoImpl() { 
	}

	@Override
	public List<Persona> listarPersona() {
		List<Persona> lstPersona=null;
		PreparedStatement ps;
		ResultSet rs;
		try
		{
			Connection cn=Conexion.getConnection();   
			String sql = "Select *from  persona";
			ps = cn.prepareStatement(sql); 
			rs = ps.executeQuery(); 
			lstPersona=new LinkedList<>(); 
			while(rs.next())
			{ 
				
				Persona p = new Persona(); 
				p.setId(rs.getInt(1)); 
				p.setNombre(rs.getString(2)); 
				p.setApellido(rs.getString(3)); 
				lstPersona.add(p);
			}
			//cn.close();
		}catch(Exception e)
		{
			System.out.println("Ocurrio un error en la lista"+e);
		}
		return lstPersona;
	}

	@Override
	public void registrarPersona(Persona per) {
		PreparedStatement ps; 
		String sql;
		try
		{
			 Connection cn  = Conexion.getConnection();
			 sql ="insert into persona(nombre, apellido) values(?,?)";  
			 ps=cn.prepareStatement(sql); 
			 ps.setString(1, per.getNombre());
			 ps.setString(2, per.getApellido());
			 ps.executeUpdate();
			 //cn.close();
		}catch(Exception e)
		{
			System.out.println("Ocurrio un error al registrar"+e);
			
		}
		
	}

	@Override
	public void actualizarPersona(Persona per) {
		PreparedStatement ps; 
		String sql; 
		try
		{
			   Connection cn = Conexion.getConnection(); 
			   sql = "update persona set nombre=?, apellido=? where id =?"; 
			   ps = cn.prepareStatement(sql); 
			   ps.setString(1, per.getNombre());
			   ps.setString(2, per.getApellido()); 
			   ps.setInt(3,per.getId()); 
			   ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("Ocurrió un error al actualizar"+e);
		}
		
	}

	@Override
	public void eliminarPersona(Persona per) {
	   PreparedStatement ps;
	   String sql; 
	   try
	   {
		     Connection  cn = Conexion.getConnection();  
		     sql ="delete from  persona where id =?"; 
		     ps = cn.prepareStatement(sql);
		     ps.setInt(1, per.getId()); 
		     ps.executeUpdate();
	   }catch(Exception e)
	   {
		   System.out.println("Ocurrió un errror al eliminar"+e);
	   }
		
	}



}
