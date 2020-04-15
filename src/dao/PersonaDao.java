package dao;

import java.util.List;

import modelo.Persona;

public interface PersonaDao { 
	
	public List<Persona>  listarPersona(); 
	public void registrarPersona(Persona per); 
	public void actualizarPersona(Persona per); 
	public void eliminarPersona(Persona per);

}
