package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class SampleController2 {

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
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    private ObservableList<Artista> listaArtistas;

    public void initialize() {
        // Obtener la lista de artistas del DataStore
        listaArtistas = DatosArtista.getInstance().getListaArtistas();
        tablaArtistas.setItems(listaArtistas);

        // Configuración de las columnas para mostrar los datos correctamente
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
    }

    @FXML
    private void btnAdd() {
        String id = txtId.getText();
        String nombreArtista = txtNombreArtista.getText();

        if (id.isEmpty() || nombreArtista.isEmpty()) {
            mostrarAlerta("Error", "Los campos ID y Artista no pueden estar vacíos.");
            return;
        }

        Artista nuevoArtista = new Artista(id, nombreArtista);
        listaArtistas.add(nuevoArtista);
        limpiarCampos();
    }

    @FXML
    private void btnModify() {
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
        tablaArtistas.refresh();
        limpiarCampos();
    }

    @FXML
    private void btnDelete() {
        Artista artistaSeleccionado = tablaArtistas.getSelectionModel().getSelectedItem();
        if (artistaSeleccionado == null) {
            mostrarAlerta("Advertencia", "Seleccione un elemento para eliminar.");
            return;
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

