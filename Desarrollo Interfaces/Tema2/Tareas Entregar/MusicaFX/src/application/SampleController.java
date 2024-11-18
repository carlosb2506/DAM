package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SampleController {

	@FXML
	public void showAbout(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Acerca de");
		alert.setHeaderText("PersonalMusic");
		alert.setContentText("Aplicación para gestionar música en tu servidor local.");
		alert.showAndWait();
	}

	@FXML
	public void handleSaveShortcut(KeyEvent event) {
		if (event.isControlDown() && event.getCode().toString().equals("S")) {
			saveData();
		}
	}

	private void saveData() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Guardar");
		alert.setHeaderText("Guardado");
		alert.setContentText("Los cambios han sido guardados exitosamente.");
		alert.showAndWait();
	}

	@FXML
    private void nuevaVistaa() {
        System.out.println("Nuevo álbum creado");
    }
}
