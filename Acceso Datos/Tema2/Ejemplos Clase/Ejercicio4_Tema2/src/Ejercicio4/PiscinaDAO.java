package Ejercicio4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PiscinaDAO {
	
	private Connection conexion;
	Database database = new Database();
	
	public void desconectar() throws SQLException{
		conexion.close();
	}
	
	public void TraerPiscina() {
		try(Connection con = database.conectar()) {
			//SQL para traer las piscinas de una fecha concreta
			String sql = "SELECT id, modelo, capacidad, strftime('%d-%m-%Y', fechafab) AS fechafab FROM Piscina;";
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs_fechaFab = pst.executeQuery();
			
			while (rs_fechaFab.next()) {
				System.out.println(rs_fechaFab.getString("fechafab"));
			}
			System.out.println(" ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void TraerPiscinaConcreta(String fecha) {
		try(Connection con = database.conectar()) {
			//SQL para traer las piscinas pasandole el mes.
			String sql = "SELECT id, modelo, capacidad, strftime('%d-%m-%Y', fechafab) AS fechafab " + 
			"FROM Piscina WHERE strftime ('%Y', fechafab) = ?;";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, fecha);
			
			ResultSet rs_fechaFab = pst.executeQuery();
			
			while (rs_fechaFab.next()) {
				System.out.print(rs_fechaFab.getString("id") + " ");
				System.out.print(rs_fechaFab.getString("modelo") + " ");
				System.out.print(rs_fechaFab.getString("capacidad") + " ");
				System.out.println(rs_fechaFab.getString("fechafab") + " ");
			}
			System.out.println(" ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DiferenciaAnios(String fecha) {
		try(Connection con = database.conectar()) {
			//SQL para traer las piscinas de una fecha concreta
			String sql = "SELECT id, modelo, capacidad, strftime('%d-%m-%Y', fechafab) AS fechafab " + 
			"FROM Piscina WHERE fechafab = date(?, '-20 months') OR fechafab = date(?, '+20 months')";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, fecha);
			pst.setString(2, fecha);
			
			ResultSet rs_fechaFab = pst.executeQuery();
			
			while (rs_fechaFab.next()) {
				System.out.println(rs_fechaFab.getInt("id")+"\t"+
												rs_fechaFab.getString("modelo")+"\t"+
												rs_fechaFab.getInt("capacidad")+"\t"+
												rs_fechaFab.getString("fechafab"));
				
			}
			System.out.println(" ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void InsertarBatch() {
		
		try(Connection con = database.conectar()){
			//SQL para insertar con el batch
			String sql = "INSERT INTO Piscina (modelo, capacidad, fechafab) VALUES (?, ?, ?);";
			
			try(PreparedStatement pst = con.prepareStatement(sql)){
				//Desactivamos el autocommit
				con.setAutoCommit(false);
				
				//Insertar 3 registros utilizando batch
				pst.setString(1, "Piscina1");
				pst.setInt(2, 20000);
				pst.setString(3, "2024-01-20");
				pst.addBatch();
				
				pst.setString(1, "Piscina2");
				pst.setInt(2, 25000);
				pst.setString(3, "2024-04-10");
				pst.addBatch();
				
				pst.setString(1, "Piscina3");
				pst.setInt(2, 30000);
				pst.setString(3, "2019-06-25");
				pst.addBatch();
				
				//Ejecutamos el batch de inserciones
				int[] result = pst.executeBatch();
				
				//Hacemos commit de las transacciones
				con.commit();
				System.out.println(result.length + " registros insertados existosamente.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void OrdenarRegistrosFecha() {
		try(Connection con = database.conectar()){
			
			ArrayList<Piscina> listaPiscinas = new ArrayList<>();
			
			//SQL para traernos todas las piscinas ordenadas por ASC(Desde la fecha mas pequenia a la mas grande).
			String sql = "SELECT * FROM Piscina ORDER BY fechafab ASC";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String modelo = rs.getString("modelo");
				int capacidad = rs.getInt("capacidad");
				String fechafab = rs.getString("fechafab");
				
				Piscina piscina = new Piscina(id, modelo, capacidad, fechafab);
				listaPiscinas.add(piscina);
				
			}
			
			// Iniciar transacción
			con.setAutoCommit(false);
			
			try {
				
				//SQL para eliminar los datos de la tabla.
				String sql2 = "DELETE FROM Piscina";
				
				try(PreparedStatement pst2 = con.prepareStatement(sql2)){
					pst2.executeUpdate();
					System.out.println("Todos los datos eliminados");
				} 
				
				
				
				//SQL para agrgar los datos del ArrayList a la tabla nuevamente.
				String sql3 = "INSERT INTO Piscina (id, modelo, capacidad, fechafab) VALUES (?, ?, ?, ?);";
				
				try(PreparedStatement pst3 = con.prepareStatement(sql3);){
					for (Piscina piscina : listaPiscinas) {
						pst3.setInt(1, piscina.getId());
						pst3.setString(2, piscina.getModelo());
						pst3.setInt(3, piscina.getCapacidad());
						pst3.setString(4, piscina.getFechafab());
						pst3.executeUpdate();
					}
					System.out.println("Datos insertados correctamente.");
				}
				
				// Confirmar transacción
				con.commit();

				
			} catch (Exception e) {
				// Revertir transacción en caso de error
				con.rollback();
				e.printStackTrace();
				System.out.println("Transacción fallida y revertida.");
			}
			finally {
				// Asegurarse de restablecer el autocommit
				con.setAutoCommit(true);
			}
				

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void OrdenarRegistrosFecha2() {
		try(Connection con = database.conectar()){
			
			ArrayList<Piscina> listaPiscinas = new ArrayList<>();
			
			//SQL para traernos todas las piscinas ordenadas por ASC(Desde la fecha mas pequenia a la mas grande).
			String sql = "SELECT * FROM Piscina ORDER BY fechafab ASC";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String modelo = rs.getString("modelo");
				int capacidad = rs.getInt("capacidad");
				String fechafab = rs.getString("fechafab");
				
				Piscina piscina = new Piscina(id, modelo, capacidad, fechafab);
				listaPiscinas.add(piscina);
				
			}
			
			
			//SQL para eliminar los datos de la tabla.
			String sql2 = "DELETE FROM Piscina";
			
			try(Statement st = con.createStatement()) {
				int filasEliminadas = st.executeUpdate(sql2);
				System.out.println("Filas eliminadas: " + filasEliminadas);
			}
			
			
			
			//SQL para agrgar los datos del ArrayList a la tabla nuevamente.
			String sql3 = "INSERT INTO Piscina (id, modelo, capacidad, fechafab) VALUES (?, ?, ?, ?);";
			
			try(PreparedStatement pst2 = con.prepareStatement(sql3);) {
				
				con.setAutoCommit(false); // Iniciar transacción
				
				for (Piscina piscina : listaPiscinas) {
					pst2.setInt(1, piscina.getId());
					pst2.setString(2, piscina.getModelo());
					pst2.setInt(3, piscina.getCapacidad());
					pst2.setString(4, piscina.getFechafab());
					pst2.addBatch();;
				}
				
				int[] result = pst2.executeBatch();
				
				con.commit(); // Confirmar transacción
				
				System.out.println(result.length + " registros insertados correctamente.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void OrdenarRegistrosFecha3() {
		try(Connection con = database.conectar()){
			
			ArrayList<Piscina> listaPiscinas = new ArrayList<>();
			
			//SQL para traernos todas las piscinas ordenadas por ASC(Desde la fecha mas pequenia a la mas grande).
			String sql = "SELECT modelo, capacidad, fechafab FROM Piscina ORDER BY fechafab ASC";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String modelo = rs.getString("modelo");
				int capacidad = rs.getInt("capacidad");
				String fechafab = rs.getString("fechafab");
				
				Piscina piscina = new Piscina(modelo, capacidad, fechafab);
				listaPiscinas.add(piscina);
				
			}
			
			
			//SQL para eliminar los datos de la tabla.
			String sql2 = "DELETE FROM Piscina";
			
			try(Statement st = con.createStatement()) {
				int filasEliminadas = st.executeUpdate(sql2);
				System.out.println("Filas eliminadas: " + filasEliminadas);
			}
			
			
			
			//SQL para agrgar los datos del ArrayList a la tabla nuevamente.
			String sql3 = "INSERT INTO Piscina (id, modelo, capacidad, fechafab) VALUES (?, ?, ?);";
			
			try(PreparedStatement pst2 = con.prepareStatement(sql3);) {
				
				con.setAutoCommit(false); // Iniciar transacción
				
				for (Piscina piscina : listaPiscinas) {
					pst2.setString(1, piscina.getModelo());
					pst2.setInt(2, piscina.getCapacidad());
					pst2.setString(3, piscina.getFechafab());
					pst2.addBatch();;
				}
				
				int[] result = pst2.executeBatch();
				
				con.commit(); // Confirmar transacción
				
				System.out.println(result.length + " registros insertados correctamente.");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
