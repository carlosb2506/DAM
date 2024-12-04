package estudiantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudiantesDAO {

	public static void mostrarEstudiantePorId(Connection con, int estudianteId) {
		try {
			String sql = "SELECT estudiante_id, nombre, correo FROM Estudiantes WHERE estudiante_id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, estudianteId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				System.out.println("ID: " + rs.getString("estudiante_id"));
				System.out.println("Nombre: " + rs.getString("nombre"));
				System.out.println("Correo: " + rs.getString("correo"));
			} else {
				System.out.println("No se encontró un estudiante con ese ID.");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void mostrarEstudiantePorId(Connection con, String estudianteId) {
		try {
			String sql = "SELECT estudiante_id, nombre, correo FROM Estudiantes WHERE estudiante_id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, estudianteId);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				System.out.println("ID: " + rs.getString("estudiante_id"));
				System.out.println("Nombre: " + rs.getString("nombre"));
				System.out.println("Correo: " + rs.getString("correo"));
			} else {
				System.out.println("No se encontró un estudiante con ese ID.");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
