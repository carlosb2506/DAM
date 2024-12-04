package ejercicioEntradas;

import java.sql.SQLException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		PersonaDAO personaDAO = new PersonaDAO();
		EventoDAO eventoDAO = new EventoDAO();
		EntradaDAO entradaDAO = new EntradaDAO();

		// ArrayList<Persona> familia = new ArrayList<>();

		Persona p1 = personaDAO.getPersona(46789123);
//		Persona p2 = personaDAO.getPersona(34567890);
//		Persona p3 = personaDAO.getPersona(89012345);
		
		System.out.println(p1);

		// familia.add(personaDAO.getPersona(46789123));
		// familia.add(personaDAO.getPersona(34567890));
		// familia.add(personaDAO.getPersona(89012345));
		
		Evento e1 = eventoDAO.getEvento(5398);
		System.out.println(e1);
//
		try {
			entradaDAO.comprarBien(p1, e1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // insertar entrada e insertar compra
//		entradaDAO.comprar(p2, e1);
//		entradaDAO.comprar(p3, e1);
		
//		personaDAO.insertPersona(
//				new Persona(26458798,"Paquillo Montgomery", "paqui69@hotmail.com"));

		
		//eventoDAO.insertEvento(new Evento(2854, "GRANADA LATINA FESTIVAL", "CORTIJO DEL CONDE", 75));
		eventoDAO.deleteEvento(2854);
		
		eventoDAO.updateEvento(e1, 0.87);
	}

}
