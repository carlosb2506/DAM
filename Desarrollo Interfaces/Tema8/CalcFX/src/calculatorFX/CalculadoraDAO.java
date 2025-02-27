package calculatorFX;

import java.sql.*;

public class CalculadoraDAO {
    private Connection conn;

    public CalculadoraDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:calculadora.db");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS historial (operacion TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveOperation(String operation) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO historial(operacion) VALUES(?)");
            pstmt.setString(1, operation);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
