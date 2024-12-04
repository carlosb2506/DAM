package ejercicioEntradas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EntradaDAO {

	public EntradaDAO() {

	}

	public void insertEntrada(Entrada ent) {
		String sql = "INSERT INTO Entradas " + "(cod_ent, dni, cod_ev, cod_comp)" + "VALUES (?, ?, ?, ?);";
		try (Connection con = Database.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			int i = 1;
			ps.setInt(1, ent.getCodEnt());
			ps.setInt(2, ent.getDni());
			ps.setInt(3, ent.getCodEv());
			ps.setInt(4, ent.getCodComp());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Entrada getEntrada(int codEnt) {

		return null;
	}

	public ArrayList<Entrada> listEntradas() {

		return null;
	}

	public void updateEntrada(Entrada entrada) {

	}

	public void deleteEntrada(int codEnt) {

	}

	public ArrayList<Entrada> getEntradaByEvento(int codEv) {
		return null;
	}

	public ArrayList<Entrada> getEntradasByPersona(int dni) {
		return null;
	}

	// public int newEntrada(Evento ev) {
	// return 1000 si es el primero o el máximo;
	// }

	public int newCodCompra() {
		String sql = "SELECT max(cod_comp) AS m FROM Compras;";
		int resultado = 10000;
		try (Connection con = Database.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resultado = rs.getInt("m");
				if (resultado != 0) {
					resultado++;
				} else {
					resultado = 10000;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public int newCodEnt(Evento ev) {
		String sql = "SELECT max(cod_ent) m FROM Entradas " + "WHERE cod_ev = ?;";
		int resultado = 1000;
		try (Connection con = Database.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, ev.getCodEv());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resultado = rs.getInt("m");
				if (resultado != 0) {
					resultado++;
				} else {
					resultado = 1000;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public void insertCompra(Compra c) {
		String sql = "INSERT INTO Compras (cod_comp, precio)" + "VALUES (?, ?);";
		try (Connection con = Database.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			int i = 1;
			ps.setInt(i++, c.getCodComp());
			ps.setDouble(i++, c.getPrecio());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comprar(Persona per, Evento ev) {
		// Poner el autocommit a falso
		// con.setAutoCommit(false);
		// Insertar Compra
		int codCompra = newCodCompra();
		insertCompra(new Compra(codCompra, ev.getPrecio()));
		// Insertar Entrada
		insertEntrada(new Entrada(newCodEnt(ev), per.getDni(), ev.getCodEv(), codCompra));
		// Commit si todo ha ido bien
		// con.commit();
		// Rollback si la ENTRADA no se ha insertado
		// sql exception
		// con.rollback();
	}

	public void comprarBien(Persona per, Evento ev) throws SQLException {
		int codComp = newCodCompra();
		Compra c = new Compra(codComp, ev.getPrecio());

		Entrada ent = new Entrada(newCodEnt(ev), per.getDni(), ev.getCodEv(), codComp);
		
		Connection con = Database.conectar();
		
		try (con){
			
			con.setAutoCommit(false);

			String sql = "INSERT INTO Compras (cod_comp, precio)" + "VALUES (?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
				int i = 1;
				ps.setInt(i++, c.getCodComp());
				ps.setDouble(i++, c.getPrecio());
				ps.execute();
			
			sql = "INSERT INTO Entradas " + "(cod_ent, dni, cod_ev, cod_comp)" + "VALUES (?, ?, ?, ?);";
			PreparedStatement psEntrada = con.prepareStatement(sql);

				//i = 1;
				psEntrada.setInt(1, ent.getCodEnt());
				psEntrada.setInt(2, ent.getDni());
				psEntrada.setInt(3, ent.getCodEv());
				psEntrada.setInt(4, ent.getCodComp());
				psEntrada.execute();
				
				con.commit();
				System.out.println("COMMIT REALIZADO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con.rollback();
			System.out.println("ROLLBACK REALIZADO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void comprar(ArrayList<Persona> familia, Evento ev) {

	}

}
