import dao.PersonaDao;
import impl.PersonaDaoImpl;
import modelo.Persona;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		PersonaDao p  = new PersonaDaoImpl();   
		Persona pe = new Persona();
		
		/*for(Persona pe: p.listarPersona())
		{
			System.out.println(pe.getId()+"; "+pe.getNombre());
		}*/ 
		 pe.setId(8);
		p.eliminarPersona(pe);
		

	}

}
