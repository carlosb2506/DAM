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
	
	@FXML
	public void cambiarColorCirculo(MouseEvent event) {
	    double x = event.getX();
	    double y = event.getY();
	    System.out.println("Clic en: (" + x + ", " + y + ")");

	    Color color = Color.rgb((int) (x % 255), (int) (y % 255), (int) ((x + y) % 255));
	    System.out.println("Color generado: " + color.toString());
	    circulito.setFill(color);
	}

	
}
