package ejercicioEntradas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventoDAO {

	public EventoDAO() {

	}

	public void insertEvento(Evento evento) {
		String sql = "INSERT INTO Eventos (cod_ev, nombre, ubicacion, precio)"
				+ "VALUES (?, ?, ?, ?);";
		try (Connection con = Database.conectar();
				PreparedStatement ps = con.prepareStatement(sql)) {
			int i = 1;
			ps.setInt(i++, evento.getCodEv());
			ps.setString(i++, evento.getNombre());
			ps.setString(i++, evento.getUbicacion());
			ps.setDouble(i++, evento.getPrecio());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Evento getEvento(int codEv) {
		String sql = "SELECT * FROM Eventos WHERE cod_ev = ?;";
		try (Connection con = Database.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, codEv);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Evento(rs.getInt("cod_ev"),
						 rs.getString("nombre"),
						 rs.getString("ubicacion"),
						 rs.getDouble("precio"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateEvento(Evento evento, double nuevoPrecio) {
		int idEvento = evento.getCodEv();
		String sql = "UPDATE Eventos SET precio = ? WHERE cod_ev = ?;";
		try (Connection con = Database.conectar();
				PreparedStatement ps = con.prepareStatement(sql)) {
			int i = 1;
			ps.setDouble(i++, nuevoPrecio);
			ps.setInt(i++, idEvento);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteEvento(int codEv) {
	    String sql = "DELETE FROM Eventos WHERE cod_ev = ?;";
	    try (Connection con = Database.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, codEv); 
	        
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();  // Imprime el error si ocurre
	    }
	}

}
