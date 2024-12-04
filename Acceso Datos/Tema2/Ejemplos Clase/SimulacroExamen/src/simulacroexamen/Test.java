package simulacroexamen;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		
		Usuario u1 = DatosDAO.getUsuario("Juampi25");
		
		ArrayList<Juegos> juegos = DatosDAO.getJuegosUser(u1.getUserid());
	}

}
