package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class SampleController {
	
	public TextField txtNum1;
	public TextField txtNum2;
	public TextField txtResultado;
	
	public void btnSumar() {
		try {
			
			int num1, num2, resultado;
			
			num1 = Integer.parseInt(txtNum1.getText());
			num2 = Integer.parseInt(txtNum2.getText());
			
			resultado = num1 + num2;
			
			txtResultado.setText(""+resultado);
			
		} catch (Exception e) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setHeaderText("Error en la suma");
			alerta.setTitle("ERROR");
			alerta.setContentText(e.toString());
			alerta.setContentText("Formato incorrecto");
		}
	}
	
}
