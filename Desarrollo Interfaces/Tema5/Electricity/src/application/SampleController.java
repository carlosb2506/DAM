package application;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class SampleController {

	@FXML
	private Spinner<String> spinner;

	@FXML
	private Spinner<String> mesInic;

	@FXML
	private Spinner<String> mesFin;

	@FXML
	private TextField tfNombre, tfPunta, tfLlano, tfValle, tfPrecioFin;

	@FXML
	private Button btnAgregar;
	@FXML
	private Button btnCalcular;

	@FXML
	private ComboBox<String> cbNombres;

	@FXML
	private StackedBarChart<String, Number> grafico;

	@FXML
	private PieChart graficoQuesitos;
	
	@FXML
	private Button btnGenerarPDFButton;
	
	private float precioPunta = 0.2001f;
	private float precioLlano = 0.1236f;
	private float precioValle = 0.1560f;
	
	float consumoPunta;
	float consumoLlano;
	float consumoValle;

	@FXML
	public void initialize() throws SQLException {
		btnAgregar.setOnAction(event -> {
			agregarBBDD();
			try {
				actualizarComboBox();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		btnCalcular.setOnAction(event -> {
			agregarBBDD();
			try {
				calcularConsumo();
				calcularConsumoQuesitos();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		btnGenerarPDFButton.setOnAction(event -> {
			//agregarBBDD();
			generarPDF();
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

		String mesInicial = mesInic.getValue();
		String mesFinal = mesFin.getValue();
		String nombreUsuario = cbNombres.getValue();

		if (nombreUsuario == null) {
			JOptionPane.showMessageDialog(null, "SELECCIONE UN USUARIO");
			return;
		}

		String url = "jdbc:sqlite:ElectricityBBDD.db";
		String sql = "SELECT mes, (consumo_en_punta + consumo_en_llano + consumo_en_valle) AS consumo_total "
				+ "FROM usuario WHERE nombre = ? AND mes BETWEEN ? AND ?";

		try (Connection con = DriverManager.getConnection(url); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, nombreUsuario);
			pstmt.setString(2, mesInicial);
			pstmt.setString(3, mesFinal);

			ResultSet rs = pstmt.executeQuery();

			grafico.getData().clear();

			XYChart.Series<String, Number> series = new XYChart.Series<>();
			series.setName(nombreUsuario);

			while (rs.next()) {
				String mes = rs.getString("mes");
				double consumoTotal = rs.getDouble("consumo_total") / 3;

				series.getData().add(new XYChart.Data<>(mes, consumoTotal));
			}

			grafico.getData().add(series);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al calcular el consumo por meses: " + e.getMessage());
		}
	}

	public void calcularConsumoQuesitos() throws SQLException {

		String mesFinal = mesFin.getValue();
		String nombreUsuario = cbNombres.getValue();

		if (nombreUsuario == null) {
			JOptionPane.showMessageDialog(null, "SELECCIONE UN USUARIO");
			return;
		}

		String url = "jdbc:sqlite:ElectricityBBDD.db";

		String sql = "SELECT consumo_en_punta, consumo_en_llano, consumo_en_valle "
				+ "FROM usuario WHERE nombre = ? AND mes = ?";

		try (Connection con = DriverManager.getConnection(url); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, nombreUsuario);
			pstmt.setString(2, mesFinal);

			ResultSet rs = pstmt.executeQuery();

			graficoQuesitos.getData().clear();

			if (rs.next()) {
				consumoPunta = rs.getFloat("consumo_en_punta");
				consumoLlano = rs.getFloat("consumo_en_llano");
				consumoValle = rs.getFloat("consumo_en_valle");

				graficoQuesitos.getData().add(new PieChart.Data("Punta", consumoPunta));
				graficoQuesitos.getData().add(new PieChart.Data("Llano", consumoLlano));
				graficoQuesitos.getData().add(new PieChart.Data("Valle", consumoValle));		

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al calcular el consumo: " + e.getMessage());
		}
	}
	
	
	public void generarPDF() {
		float alquiler = 0.99f;
		float energiaContratada = 9.23f;

		 JasperReport reporte = null;
		try {
			reporte = (JasperReport) JRLoader.loadObjectFromFile("Flower.jasper");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 String url = "jdbc:sqlite:ElectricityBBDD.db";

		 Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		 HashMap<String, Object> parametros = new HashMap<>();

		 parametros.put("Nombre", cbNombres.getValue());
		 parametros.put("ConsumoPunta", String.format("%.2f", (consumoPunta * precioPunta)) + " €");
		 parametros.put("ConsumoLlano", String.format("%.2f", (consumoLlano * precioLlano)) + " €");
		 parametros.put("ConsumoValle", String.format("%.2f", (consumoValle * precioValle)) + " €");
		 parametros.put("PotenciaConsumida", String.format("%.2f", (consumoLlano + consumoPunta + consumoValle)) + " Kw/h");
		 parametros.put("PrecioConsPunta", String.format("%.2f", precioPunta) + " €");
		 parametros.put("PrecioConsLlano", String.format("%.2f", precioLlano) + " €");
		 parametros.put("PrecioConsValle", String.format("%.2f", precioValle) + " €");
		 parametros.put("Impuesto", String.format("%.2f", ((consumoValle * precioValle) + (consumoPunta * precioPunta) + (consumoLlano * precioLlano) * 0.07f)) + " €");
		 parametros.put("AlquilerContador", alquiler + " €");
		 parametros.put("IVA", String.format("%.2f", ((consumoValle * precioValle) + (consumoPunta * precioPunta) + (consumoLlano * precioLlano) * 0.21f)) + " €");
		 parametros.put("EnergContr", energiaContratada + " €");
		 parametros.put("Total", String.format("%.2f", 
		     ((consumoPunta * precioPunta) 
		     + (consumoLlano * precioLlano) 
		     + (consumoValle * precioValle) 
		     + ((consumoValle * precioValle) 
		     + (consumoPunta * precioPunta) 
		     + (consumoLlano * precioLlano) * 0.07f) 
		     + alquiler 
		     + ((consumoValle * precioValle) 
		     + (consumoPunta * precioPunta) 
		     + (consumoLlano * precioLlano) * 0.21f) 
		     + energiaContratada)) + " €");
		 
		 
//		    parametros.put("ConsumoPuntaPie", consumoPunta);
//		    parametros.put("ConsumoLlanoPie", consumoLlano);
//		    parametros.put("ConsumoVallePie", consumoValle);


		 JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(reporte, parametros, conexion);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 JasperViewer.viewReport(jasperPrint, false);
	}
}