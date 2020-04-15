package bean;

import java.util.List;

import dao.PersonaDao;
import impl.PersonaDaoImpl;
import modelo.Persona;

public class BeanPersona {
    private List<Persona> listPersona=null; 
    private Persona persona;
	public BeanPersona() {
	} 
	
	
	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public List<Persona> getListPersona() {
		PersonaDao pDao = new PersonaDaoImpl();
		listPersona=pDao.listarPersona();
		return listPersona;
	}

	public void preaparaPersona()
	{
		persona= new Persona();
	}
	
	public void registrarPersona()
	{
		PersonaDao pDao = new PersonaDaoImpl(); 
		pDao.registrarPersona(persona);
	} 
	
	public void actualizarPersona()
	{
		PersonaDao pDao = new PersonaDaoImpl(); 
		pDao.actualizarPersona(persona);
	} 
	
	public void eliminarPersona()
	{
		PersonaDao pDao = new PersonaDaoImpl(); 
		pDao.eliminarPersona(persona);
	}


}