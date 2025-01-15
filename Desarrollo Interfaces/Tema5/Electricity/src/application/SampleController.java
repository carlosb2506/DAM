package application;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class SampleController {

	@FXML
	private Spinner<String> spinner;

	@FXML
	private Spinner<String> mesInic;

	@FXML
	private Spinner<String> mesFin;

	@FXML
	private TextField tfNombre, tfPunta, tfLlano, tfValle;

	@FXML
	private Button btnAgregar;
	@FXML
	private Button btnCalcular;

	@FXML
	private ComboBox<String> cbNombres;
	
	private boolean bandera = true;

	@FXML
	public void initialize() {
		btnAgregar.setOnAction(event -> {
			bandera = true;
			agregarBBDD();
			try {
				actualizarComboBox();
			} catch (SQLException e) {
				bandera = false;
				e.printStackTrace();
			}
		});
		
		btnCalcular.setOnAction(event -> {
			agregarBBDD();
			try {
				calcularConsumo();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		SpinnerValueFactory<String> value = new SpinnerValueFactory.ListSpinnerValueFactory<>(
				FXCollections.observableArrayList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
						"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));
		spinner.setValueFactory(value);

		SpinnerValueFactory<String> valueInic = new SpinnerValueFactory.ListSpinnerValueFactory<>(
				FXCollections.observableArrayList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
						"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));

		mesInic.setValueFactory(valueInic);

		SpinnerValueFactory<String> valueFin = new SpinnerValueFactory.ListSpinnerValueFactory<>(
				FXCollections.observableArrayList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
						"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"));
		mesFin.setValueFactory(valueFin);

		try {
			mostrarNombres(cbNombres);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void agregarBBDD() {
		
		if (bandera) return;
		
		String nombre = tfNombre.getText();
		String strPunta = tfPunta.getText();
		String strLlano = tfLlano.getText();
		String strValle = tfValle.getText();

		String mes = spinner.getValue();
		if (nombre.isEmpty() || strPunta.isEmpty() || strLlano.isEmpty() || strValle.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ningún campo puede estar vacio");
		} else {
			int punta = Integer.parseInt(strPunta);
			int llano = Integer.parseInt(strLlano);
			int valle = Integer.parseInt(strValle);

			String url = "jdbc:sqlite:ElectricityBBDD.db";

			String sql = "INSERT INTO usuario (nombre, consumo_en_punta, consumo_en_llano, consumo_en_valle, mes) VALUES (?, ?, ?, ?, ?)";
			try (Connection con = DriverManager.getConnection(url);
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, nombre);
				pstmt.setInt(2, punta);
				pstmt.setInt(3, llano);
				pstmt.setInt(4, valle);
				pstmt.setString(5, mes);

				pstmt.executeUpdate();
				System.out.println("Datos insertados en la base de datos correctamente.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error al insertar los datos en la base de datos: " + e.getMessage());
			}
		}
	}

	public static void mostrarNombres(ComboBox<String> comboBox) throws SQLException {

		String url = "jdbc:sqlite:ElectricityBBDD.db";

		try (Connection con = DriverManager.getConnection(url)) {
			String sql = "SELECT DISTINCT nombre FROM usuario";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				comboBox.getItems().add(rs.getString("nombre"));
			}
		}
	}

	private void actualizarComboBox() throws SQLException {
		cbNombres.getItems().clear();

		mostrarNombres(cbNombres);

	}

	
	public void calcularConsumo() throws SQLException {
		
		if (!bandera) return;
		
	    String mesInicial = mesInic.getValue();
	    String mesFinal = mesFin.getValue();
	    String nombreUsuario = cbNombres.getValue();

	    if ( nombreUsuario == null) {
	        JOptionPane.showMessageDialog(null, "SELECCIONE UN USUARIO");
	        return;
	    }

	    String url = "jdbc:sqlite:ElectricityBBDD.db";
	    String sql = "SELECT mes, (consumo_en_punta + consumo_en_llano + consumo_en_valle) AS consumo_total "
	               + "FROM usuario "
	               + "WHERE nombre = ? AND mes BETWEEN ? AND ? "
	               + "ORDER BY mes";

	    try (Connection con = DriverManager.getConnection(url);
	         PreparedStatement pstmt = con.prepareStatement(sql)) {
	        
	        pstmt.setString(1, nombreUsuario);
	        pstmt.setString(2, mesInicial);
	        pstmt.setString(3, mesFinal);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            String mes = rs.getString("mes");
	            double consumoTotal = rs.getDouble("consumo_total");
	            System.out.println("Consumo total en " + mes + " para " + nombreUsuario + ": " + consumoTotal);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al calcular el consumo por meses: " + e.getMessage());
	    }
	}
}
