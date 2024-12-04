package bicicleta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class biciclista {

	public static void main(String[] args) 
	{
		try {
//			Connection con = DriverManager.getConnection(
//					"jdbc:postgresql://localhost:5432/PruebaAcceso",
//					"postgres","1234");
//			
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("SELECT * FROM ciclista");
//			
//			while (rs.next()) {
//				System.out.print(rs.getString("NOMBRE") + " ");
//				System.out.println(rs.getInt("EDAD"));
//			}
//			
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
			//Conexión
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Ficheritos\\Ciclistas.db");
			
			Statement st = con.createStatement();
			
			//System.out.println("Dime el nombre, la edad, el kilometraje que aguanta y el color del culotte para añadir el ciclista a mi"
					//+ "base de datos dame los datos separados por espacio: ");
			
			//String datos = System.console().readLine();
			
			//String[] inserccion = datos.split(" ");
			
			//String sql = "INSERT INTO Ciclista "
					//+ "(NOMBRE, EDAD, AGUANTA, CULOTTE)"
					//+ "VALUES ('" + inserccion[0] + "'," + inserccion[1] + "," + inserccion[2] + ",'" + inserccion[3] + "')";
			//int nf = st.executeUpdate(sql);
			//System.out.println(nf + "registros insertados");
			 
			ResultSet rs = st.executeQuery("SELECT * FROM ciclista");
			
			while (rs.next()) {
				System.out.print(rs.getString("NOMBRE") + " ");
				System.out.println(rs.getInt("EDAD"));
			}
			
			//Inserccion con prepared statement
			
			
			System.out.println("Dime el nombre, la edad, el kilometraje que aguanta y el color del culotte para añadir el ciclista a mi"
					+ "base de datos dame los datos separados por comas: ");
			
			String datos = System.console().readLine();
			
			String[] val = datos.split(","); 
			
			String sql = "INSERT INTO Ciclista (NOMBRE, EDAD, AGUANTA, CULOTTE) VALUES (?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
					
			//Primera Inserccion
//			pst.setString(1, val[0]);
//			pst.setString(2, val[1]);
//			pst.setString(3, val[2]);
//			pst.setString(4, val[3]);
			
			int i = 1;
			pst.setString(i++, val[(i - 1)]);
			//i++;
			pst.setString(i++, val[(i - 1)]);
			//i++;
			pst.setString(i++, val[(i - 1)]);
			//i++;
			pst.setString(i++, val[(i - 1)]);
			
//			pst.setString(1, "Manolín");
//			pst.setInt(2, 66);
//			pst.setInt(3, 30);
//			pst.setString(4, "Verde");
			
			int nf = pst.executeUpdate();
			
			System.out.println(nf + "registros insertados");
			System.out.println();
			
			while (rs.next()) {
				System.out.print(rs.getString("NOMBRE") + " ");
				System.out.println(rs.getInt("EDAD"));
			}
			
			//Borrado
			//sql = "DELETE FROM ciclista where NOMBRE='Pepon'";
			
			//nf = st.executeUpdate(sql);
			//System.out.println(nf + "registros borrados");
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
