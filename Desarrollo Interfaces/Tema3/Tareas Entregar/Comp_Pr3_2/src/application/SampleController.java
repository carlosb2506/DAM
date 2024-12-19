package application;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;

public class SampleController {

	@FXML
	public Pane paneColor;
	@FXML
	public Button btnCambiaColor;
	@FXML
	public Pane paneGrande;

	public void btnCambiaColor() {
		
		Random rnd = new Random();
		
		int numeroAleatorio = rnd.nextInt(4) + 1;
		
		if (numeroAleatorio == 1) {
			paneColor.setStyle("-fx-background-color: blue;");
			paneGrande.setStyle("-fx-background-color: green;");
		} else if (numeroAleatorio == 2) {
			paneColor.setStyle("-fx-background-color: yellow;");
			paneGrande.setStyle("-fx-background-color: red;");
		} else if (numeroAleatorio == 3) {
			paneColor.setStyle("-fx-background-color: green;");
			paneGrande.setStyle("-fx-background-color: yellow;");
		} else {
			paneColor.setStyle("-fx-background-color: red;");
			paneGrande.setStyle("-fx-background-color: blue;");
		}

		Rotate rotacion = new Rotate();
		Rotate rotacion2 = new Rotate();
		rotacion.setAngle(15);
		rotacion2.setAngle(-45);
		rotacion.setPivotX(paneColor.getLayoutBounds().getWidth() / 2);
		rotacion.setPivotY(paneColor.getLayoutBounds().getHeight() / 2);
		rotacion2.setPivotX(paneGrande.getLayoutBounds().getWidth() / 2);
		rotacion2.setPivotY(paneGrande.getLayoutBounds().getHeight() / 2);
		paneColor.getTransforms().add(rotacion);
		paneGrande.getTransforms().add(rotacion2);
	}

	private void showErrorAlert(String header, Exception e) {
		Alert alerta = new Alert(AlertType.ERROR);
		alerta.setHeaderText(header);
		alerta.setTitle("ERROR");
		alerta.setContentText("Formato incorrecto");
		alerta.showAndWait();
	}
}
