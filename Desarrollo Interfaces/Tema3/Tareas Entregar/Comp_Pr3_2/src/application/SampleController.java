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
	
    public void initialize() {
    	
    	try {

            btnCambiaColor.setOnAction(e -> {
            	
                Random rand = new Random();
                int numeroAleatorio = rand.nextInt(4) + 1;
            	
                if (numeroAleatorio == 1) {
                    paneColor.setStyle("-fx-background-color: blue;");
                } else if(numeroAleatorio == 2){
                    paneColor.setStyle("-fx-background-color: yellow;");
                } else if(numeroAleatorio == 3){
                    paneColor.setStyle("-fx-background-color: green;");
                }else {
                	paneColor.setStyle("-fx-background-color: red;");
    			}
                
                Rotate rotacion = new Rotate(); 
                
                rotacion.setAngle(10);

                //rotacion.setPivotX(paneColor.getLayoutBounds().getWidth() / 2);

                //rotacion.setPivotY(paneColor.getLayoutBounds().getHeight() / 2); 

                paneColor.getTransforms().add(rotacion);
                
                

            });
			
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
