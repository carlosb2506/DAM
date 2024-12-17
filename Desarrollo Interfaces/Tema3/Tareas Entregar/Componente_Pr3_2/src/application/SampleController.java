package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SampleController {

	public TextField numConvertir;
	public TextField txtResultado;
	public RadioButton bytee;
	public RadioButton GigaByte;
	public RadioButton kiloByte;
	public RadioButton megaByte;
	public RadioButton teraByte;
	public RadioButton petaByte;

	public void btnOperar() {
		try {
			double numaConvertir;
			double resultado;

			numaConvertir = Double.parseDouble(numConvertir.getText()); 

			if (bytee.isSelected()) {
				try {
					resultado = numaConvertir * 1000000;
					txtResultado.setText(String.valueOf(resultado)); 
				} catch (Exception e) {
					showErrorAlert("Error", e);
				}
			} else if (GigaByte.isSelected()) {
				try {
					resultado = numaConvertir / 1000;
					txtResultado.setText(String.valueOf(resultado)); 
				} catch (Exception e) {
					showErrorAlert("Error", e);
				}
			} else if (kiloByte.isSelected()) {
				try {
					resultado = numaConvertir * 1024;
					txtResultado.setText(String.valueOf(resultado));
				} catch (Exception e) {
					showErrorAlert("Error", e);
				}
			} else if (megaByte.isSelected()) {
				try {
					resultado = numaConvertir;
					txtResultado.setText(String.valueOf(resultado));
				} catch (Exception e) {
					showErrorAlert("Error", e);
				}
			} else if (teraByte.isSelected()) {
				try {
					resultado = numaConvertir / 1000000;
					txtResultado.setText(String.valueOf(resultado));
				} catch (Exception e) {
					showErrorAlert("Error", e);
				}
			} else if (petaByte.isSelected()) {
				try {
					resultado = numaConvertir / 1000000000;
					txtResultado.setText(String.valueOf(resultado));
				} catch (Exception e) {
					showErrorAlert("Error", e);
				}
			}
		} catch (Exception e) {
			showErrorAlert("Error en la operación", e);
		}
	}

	private void showErrorAlert(String header, Exception e) {
		Alert alerta = new Alert(AlertType.ERROR);
		alerta.setHeaderText(header);
		alerta.setTitle("ERROR");
		alerta.setContentText("Formato incorrecto");
		alerta.showAndWait();
	}
}
