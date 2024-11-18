package ejercicioEntradas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static Connection conectar() throws SQLException {
		try {
			return DriverManager.getConnection("jdbc:sqlite:C:\\Ficheritos\\Entradas.db");
		} catch (SQLException e) {
			throw new SQLException("Error de conexión: ", e);
		}
	}

}
