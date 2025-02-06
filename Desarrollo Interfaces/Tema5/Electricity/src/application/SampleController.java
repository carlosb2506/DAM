package application;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Controlador principal de la aplicación, encargado de gestionar los eventos y
 * la interacción con la base de datos, gráficos y generación de reportes PDF.
 * 
 * Contiene métodos para agregar datos de consumo de electricidad a una base de
 * datos, calcular los consumos por mes y generar gráficos visuales, así como
 * generar un informe en formato PDF con los datos calculados.
 */
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
    
    @FXML
    private AnchorPane anchorPaneAyuda;
    
    private float precioPunta = 0.2001f;
    private float precioLlano = 0.1236f;
    private float precioValle = 0.1560f;
    
    float consumoPunta;
    float consumoLlano;
    float consumoValle;

    /**
     * Método de inicialización que se ejecuta al cargar la escena. Establece los
     * valores predeterminados en los controles gráficos, configura los eventos y
     * carga la ayuda en el componente WebView.
     * 
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    @FXML
    public void initialize() throws SQLException {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("Ayuda.html").toExternalForm());
        webView.setPrefSize(833, 433); 
        anchorPaneAyuda.getChildren().add(webView);

        Tooltip tooltipPdf = new Tooltip("Pulsando este boton se generará un pdf automaticamente con los datos del cliente");
        Tooltip tooltipGraficos = new Tooltip("Pulsando este boton se generará un grafico de barras con el consumo total en los meses seleccionados y otro grafico que contendra los datos solos del mes final que se haya seleccionado");
        Tooltip tooltipAgregar = new Tooltip("Pulsando este boton se agregara automaticamente el cliente junto a sus datos que estara disponible su información en la otra pestaña");
        
        btnGenerarPDFButton.setTooltip(tooltipPdf);
        btnAgregar.setTooltip(tooltipAgregar);
        btnCalcular.setTooltip(tooltipGraficos);
        
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
        
        btnGenerarPDFButton.setOnAction(event -> generarPDF());

        // Establece los valores del Spinner para seleccionar el mes
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

        // Carga los nombres de los usuarios en el ComboBox
        try {
            mostrarNombres(cbNombres);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Agrega los datos de un nuevo usuario a la base de datos.
     * 
     * @throws SQLException Si ocurre un error al insertar los datos en la base
     *                      de datos.
     */
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

    /**
     * Muestra los nombres de los usuarios en el ComboBox.
     * 
     * @param comboBox El ComboBox donde se agregarán los nombres.
     * @throws SQLException Si ocurre un error al obtener los nombres desde la base
     *                      de datos.
     */
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

    /**
     * Actualiza el ComboBox de nombres con los usuarios disponibles.
     * 
     * @throws SQLException Si ocurre un error al actualizar los nombres.
     */
    private void actualizarComboBox() throws SQLException {
        cbNombres.getItems().clear();
        mostrarNombres(cbNombres);
    }

    /**
     * Calcula el consumo total por usuario y genera un gráfico de barras con los
     * datos.
     * 
     * @throws SQLException Si ocurre un error al obtener los datos de consumo desde
     *                      la base de datos.
     */
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

    /**
     * Calcula el consumo en cada franja horaria (Punta, Llano, Valle) y genera un
     * gráfico de torta (PieChart) con los datos.
     * 
     * @throws SQLException Si ocurre un error al obtener los datos de consumo desde
     *                      la base de datos.
     */
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

    /**
     * Genera un reporte en formato PDF con los datos de consumo y lo muestra.
     */
    public void generarPDF() {
        float alquiler = 0.99f;
        float energiaContratada = 9.23f;

        JasperReport reporte = null;
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile("Flower.jasper");
        } catch (JRException e) {
            e.printStackTrace();
        }

        String url = "jdbc:sqlite:ElectricityBBDD.db";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
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

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(reporte, parametros, conexion);
        } catch (JRException e) {
            e.printStackTrace();
        }

        JasperViewer.viewReport(jasperPrint, false);
    }
}
