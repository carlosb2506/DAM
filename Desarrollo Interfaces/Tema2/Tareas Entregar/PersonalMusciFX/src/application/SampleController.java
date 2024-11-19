package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class SampleController {
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

    private static final String FILE_NAME = "albumsData.txt";

    public void initialize() {
        // Configura las columnas para mostrar propiedades del objeto Album
        colId.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue().getId()));
        colTitulo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue().getTitulo()));
        colArtista.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue().getArtista()));

        // Configura la tabla
        TreeItem<Album> rootItem = new TreeItem<>(new Album("", "", ""));
        treeTableView.setRoot(rootItem);
        treeTableView.setShowRoot(false);

        // Cargar datos guardados en la tabla
        loadSavedData();

        // Cargar la lista de artistas en el Spinner
        ObservableList<Artista> listaArtistas = DatosArtista.getInstance().getListaArtistas();
        ObservableList<String> nombresArtistas = FXCollections.observableArrayList(
                listaArtistas.stream()
                        .map(Artista::getNombre)
                        .toList()
        );

        // Configura el Spinner con la lista de nombres de artistas
        spnArtista.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(nombresArtistas));

        // Configura los botones con eventos
        btnAdd.setOnAction(event -> addAlbum());
        btnModify.setOnAction(event -> modifyAlbum());
        btnDelete.setOnAction(event -> deleteAlbum());
    }

    private void addAlbum() {
        String id = txtId.getText();
        String titulo = txtTitulo.getText();
        String artista = spnArtista.getValue();

        if (!id.isEmpty() && !titulo.isEmpty() && artista != null) {
            Album newAlbum = new Album(id, titulo, artista);
            TreeItem<Album> newItem = new TreeItem<>(newAlbum);
            treeTableView.getRoot().getChildren().add(newItem);

            // Guardar el nuevo álbum en la estructura de datos
            saveChanges();

            txtId.clear();
            txtTitulo.clear();
        }
    }

    private void modifyAlbum() {
        TreeItem<Album> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            Album album = selectedItem.getValue();
            album.setId(txtId.getText());
            album.setTitulo(txtTitulo.getText());
            album.setArtista(spnArtista.getValue());
            selectedItem.setValue(album);

            // Refresca la vista de la tabla para mostrar los cambios
            treeTableView.refresh();

            // Guardar los cambios en la estructura de datos
            saveChanges();
        }
    }

    private void deleteAlbum() {
        TreeItem<Album> selectedItem = treeTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            treeTableView.getRoot().getChildren().remove(selectedItem);

            // Guardar los cambios tras la eliminación
            saveChanges();
        }
    }

    private void saveChanges() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (TreeItem<Album> item : treeTableView.getRoot().getChildren()) {
                Album album = item.getValue();
                writer.write(album.getId() + "," + album.getTitulo() + "," + album.getArtista());
                writer.newLine();
            }
            System.out.println("Los cambios en la tabla se han guardado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSavedData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Album album = new Album(parts[0], parts[1], parts[2]);
                    TreeItem<Album> item = new TreeItem<>(album);
                    treeTableView.getRoot().getChildren().add(item);
                }
            }
            System.out.println("Datos cargados en la tabla.");
        } catch (IOException e) {
            System.out.println("No se pudo cargar los datos guardados.");
        }
    }
}




