package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TreeItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class SampleController {

	@FXML
	private AnchorPane contentPane;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtTitulo;

	@FXML
	private Spinner<String> spnArtista;

	@FXML
	private TreeTableView<Album> treeTableView;

	@FXML
	private TreeTableColumn<Album, String> colId;

	@FXML
	private TreeTableColumn<Album, String> colTitulo;

	@FXML
	private TreeTableColumn<Album, String> colArtista;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnModify;

	@FXML
	private Button btnDelete;

	@FXML
	private Button btnAlbum;

	@FXML
	private Button btnArtista;

	DatosDAO datosDAO = new DatosDAO();
	Album album;

	public void initialize() {

		colId.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue().getId()));
		colTitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue().getTitulo()));
		colArtista.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue().getArtista()));

		TreeItem<Album> rootItem = new TreeItem<>(new Album("", "", ""));
		treeTableView.setRoot(rootItem);
		treeTableView.setShowRoot(false);

		ObservableList<Artista> listaArtistas = DatosArtista.getInstance().getListaArtistas();
		ObservableList<String> nombresArtistas = FXCollections
				.observableArrayList(listaArtistas.stream().map(Artista::getNombre).toList());
		spnArtista.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(nombresArtistas));

		btnAdd.setOnAction(event -> aniadirAlbum());
		btnModify.setOnAction(event -> modificarAlbum());
		btnDelete.setOnAction(event -> eliminarAlbum());

		try {
			List<Album> albumesDesdeBD = datosDAO.mostrarAlbumes();
			for (Album album : albumesDesdeBD) {
				rootItem.getChildren().add(new TreeItem<>(album));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			mostrarAlerta("Error", "No se pudieron cargar los álbumes desde la base de datos.");
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
	private void aniadirAlbum() {

		String id = txtId.getText();
		String titulo = txtTitulo.getText();
		String artista = spnArtista.getValue();

		if (!id.isEmpty() && !titulo.isEmpty() && artista != null) {
			Album newAlbum = new Album(id, titulo, artista);
			TreeItem<Album> newItem = new TreeItem<>(newAlbum);
			treeTableView.getRoot().getChildren().add(newItem);

			try {

				datosDAO.guardarCancion(newAlbum);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtId.clear();
			txtTitulo.clear();
		}
	}

	@FXML
	private void modificarAlbum() {

		TreeItem<Album> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			Album album = selectedItem.getValue();
			album.setId(txtId.getText());
			album.setTitulo(txtTitulo.getText());
			album.setArtista(spnArtista.getValue());
			selectedItem.setValue(album);
			Album albumNuevo = new Album(txtId.getText(), txtTitulo.getText(), spnArtista.getValue());

			treeTableView.refresh();

			try {
				datosDAO.modificarCancion(album, albumNuevo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	private void eliminarAlbum() {
		TreeItem<Album> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			Album albumSeleccionado = selectedItem.getValue();

			treeTableView.getRoot().getChildren().remove(selectedItem);

			try {
				datosDAO.eliminarCancion(albumSeleccionado);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void mostrarAlerta(String titulo, String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setTitle(titulo);
		alerta.setContentText(mensaje);
		alerta.showAndWait();
	}

}
