package ejercicioEntradas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonaDAO {

	public PersonaDAO() {

	}

	public void insertPersona(Persona persona) {
		String sql = "INSERT INTO Personas (dni, nombre, email)"
				+ "VALUES (?, ?, ?);";
		try (Connection con = Database.conectar();
				PreparedStatement ps = con.prepareStatement(sql)) {
			int i = 1;
			ps.setInt(i++, persona.getDni());
			ps.setString(i++, persona.getNombre());
			ps.setString(i++, persona.getEmail());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Persona getPersona(int dni) {
		String sql = "SELECT * FROM Personas WHERE dni = ?;";
		try (Connection con = Database.conectar();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, dni);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Persona(rs.getInt("dni"),
						rs.getString("nombre"), rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updatePersona(Persona persona) {

	}

	public void deletePersona(int dni) {

	}

}
