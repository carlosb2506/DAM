package simulacroexamen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatosDAO {
	
	public static ArrayList<Juegos> getJuegosUser(String u) {
	    ArrayList<Juegos> juegos = new ArrayList<Juegos>();

	    try (Connection con = DatabaseDAO.conectar()) {
	        String sql = "SELECT * FROM Biblioteca WHERE userid = ?;";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, u);   
	        ResultSet rs = ps.executeQuery();
	        boolean juegosEncontrados = false;

	        while (rs.next()) 
	        { 
	        	juegosEncontrados = true;
	        	String aniadir = (rs.getString("juego")); 
	        	juegos.add(aniadir);
	        }

	        if (!juegosEncontrados) {
	            System.out.println("No se encontraron juegos para ese usuario.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return juegos;
	}

	
	public static Usuario getUsuario(String userId) {
		return null;
	}
	
	
	
	
	
	public static void mostrarUserJuego() {
		System.out.println("DIME EL NOMBRE DEL JUEGO PARA MOSTRARTE QUIEN LOS TIENE: ");
		String nomJuego = System.console().readLine();
		
	    try (Connection con = DatabaseDAO.conectar()) {
	        String sql = "SELECT userid FROM Biblioteca WHERE juego = ?;";
	        
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, nomJuego);
	        
	        ResultSet rs = ps.executeQuery();
	        boolean juegosEncontrados = false;
	        
	        while (rs.next()) {
	            juegosEncontrados = true;
	            System.out.println("Usuario: " + rs.getString("userid"));
	        }
	        
	        if (!juegosEncontrados) {
	            System.out.println("No se encontraron usuarios que jueguen a ese juego.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void recargaSaldo(String usuario, double saldo) {
				
	    try (Connection con = DatabaseDAO.conectar()) {
			String sql = "UPDATE Usuario SET saldo = ? WHERE userid = ?;";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setDouble(1, saldo);
			pst.setString(2, usuario);

			pst.execute();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}

