package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class SampleController2 {

	@FXML
	private StackPane contentPane;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNombreArtista;

	@FXML
	private TableView<Artista> tablaArtistas;

	@FXML
	private TableColumn<Artista, String> colId;

	@FXML
	private TableColumn<Artista, String> colNombre;

	@FXML
	private Button btnAnadir;

	@FXML
	private Button btnArtista;

	@FXML
	private Button btnModificar;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnAlbum;

	private DatosDAO datosDAO = new DatosDAO();

	private ObservableList<Artista> listaArtistas;

	public void initialize() {

		listaArtistas = DatosArtista.getInstance().getListaArtistas();
		tablaArtistas.setItems(listaArtistas);

		colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
		colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

		try {
			List<Artista> artistasDesdeBD = datosDAO.mostrarArtistas();
			listaArtistas.clear();
			listaArtistas.addAll(artistasDesdeBD);
		} catch (SQLException e) {
			e.printStackTrace();
			mostrarAlerta("Error", "No se pudieron cargar los artistas desde la base de datos.");
		}
	}

	@FXML
	private void verArtistas() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sample2.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.show();

			Stage myStage = (Stage) this.btnArtista.getScene().getWindow();
			myStage.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	private void verAlbumes() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Sample.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);
			Stage stage = new Stage();

			stage.setScene(scene);
			stage.show();

			Stage myStage = (Stage) this.btnAlbum.getScene().getWindow();
			myStage.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	private void btnAniadir() {
		String id = txtId.getText();
		String nombreArtista = txtNombreArtista.getText();

		try {

			datosDAO.guardarArtista(new Artista(id, nombreArtista));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (id.isEmpty() || nombreArtista.isEmpty()) {
			mostrarAlerta("Error", "Los campos ID y Artista no pueden estar vacíos.");
			return;
		}

		Artista nuevoArtista = new Artista(id, nombreArtista);
		listaArtistas.add(nuevoArtista);
		limpiarCampos();
	}

	@FXML
	private void btnModificar() {
		Artista artistaSeleccionado = tablaArtistas.getSelectionModel().getSelectedItem();
		if (artistaSeleccionado == null) {
			mostrarAlerta("Advertencia", "Seleccione un elemento para modificar.");
			return;
		}

		String id = txtId.getText();
		String nombreArtista = txtNombreArtista.getText();

		if (id.isEmpty() || nombreArtista.isEmpty()) {
			mostrarAlerta("Error", "Los campos ID y Artista no pueden estar vacíos.");
			return;
		}

		artistaSeleccionado.setId(id);
		artistaSeleccionado.setNombre(nombreArtista);

		try {
			datosDAO.modificarArtista(artistaSeleccionado);
		} catch (SQLException e) {
			e.printStackTrace();
			mostrarAlerta("Error", "No se pudo modificar el artista en la base de datos.");
			return;
		}

		tablaArtistas.refresh();
		limpiarCampos();
	}

	@FXML
	private void btnEliminar() {
		Artista artistaSeleccionado = tablaArtistas.getSelectionModel().getSelectedItem();
		if (artistaSeleccionado == null) {
			mostrarAlerta("Advertencia", "Seleccione un elemento para eliminar.");
			return;
		}

		try {
			datosDAO.eliminarArtista(artistaSeleccionado);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		listaArtistas.remove(artistaSeleccionado);
	}

	private void limpiarCampos() {
		txtId.clear();
		txtNombreArtista.clear();
	}

	private void mostrarAlerta(String titulo, String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle(titulo);
		alerta.setContentText(mensaje);
		alerta.showAndWait();
	}
}
