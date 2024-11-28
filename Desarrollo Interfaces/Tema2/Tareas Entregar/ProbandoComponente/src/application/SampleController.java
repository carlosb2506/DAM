package application;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SampleController {
	@FXML
	private componente.SampleController miComponenteController;
	
	@FXML
	private Circle circulito;
	
	public void initialize() {
		System.out.println("inicializa");
		
		try {
			addListener(miComponenteController.pb1);
			addListener(miComponenteController.pb2);
			addListener(miComponenteController.pb3);
			addListener(miComponenteController.pb4);
			addListener(miComponenteController.pb5);

			cambiarColorCirculo();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

		private void addListener(ProgressBar progressbar) {
			progressbar.visibleProperty().addListener((observable, oldValue, newValue) -> cambiarColorCirculo());
		}
	
	
	public void cambiarColorCirculo() {
		
		if (miComponenteController.pb1Visible()) {
			circulito.setFill(javafx.scene.paint.Color.RED);
		}
		if (miComponenteController.pb2Visible()) {
			circulito.setFill(javafx.scene.paint.Color.ORANGE);
		}
		if (miComponenteController.pb3Visible()) {
			circulito.setFill(javafx.scene.paint.Color.YELLOW);
		}  if (miComponenteController.pb4Visible()) {
			circulito.setFill(javafx.scene.paint.Color.GREEN);
		}  if (miComponenteController.pb5Visible()) {
			circulito.setFill(javafx.scene.paint.Color.BLUE);
		}	
	}
}
