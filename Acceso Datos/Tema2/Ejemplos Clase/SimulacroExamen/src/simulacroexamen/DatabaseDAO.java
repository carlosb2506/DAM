package simulacroexamen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDAO {
	
	public static Connection conectar() throws SQLException {
		try {
			return DriverManager.getConnection("jdbc:sqlite:Simulacroexamen.db");
		} catch (SQLException e) {
			throw new SQLException("Error de conexión: ", e);
		}
	}
}