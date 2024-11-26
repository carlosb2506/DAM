package componente;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SampleController {

	@FXML
	private ProgressBar pb1;
	@FXML
	private ProgressBar pb2;
	@FXML
	private ProgressBar pb3;
	@FXML
	private ProgressBar pb4;
	@FXML
	private ProgressBar pb5;

	@FXML
	private Slider slider;

	@FXML
	private Slider sliderHoriz;

	@FXML
	private Pane pnPrincipal;

	public void initialize() {
		System.out.println("inicializa");
		pb1.setVisible(false);
		pb2.setVisible(false);
		pb3.setVisible(false);
		pb4.setVisible(false);
		pb5.setVisible(false);
		slider.setVisible(false);

	}

	@FXML
	public void funcionSlider(MouseEvent event) {
		double value = slider.getValue();
		subiendoSlider((int) value);
	}

	@FXML
	public void funcionPane(MouseEvent event) {
		double value = 100 - (int) ((event.getY() / pnPrincipal.getHeight()) * 100);
		subiendoPane((int) value);
	}

	@FXML
	public void funcionSliderHoriz(MouseEvent event) {
		double value = sliderHoriz.getValue();
		if (value > 97) {
			slider.setVisible(true);
		} else {
			slider.setVisible(false);
		}
	}

	public void subiendoSlider(int y) {
		ProgressBar[] progressBars = { pb1, pb2, pb3, pb4, pb5 };

		for (int i = 0; i < progressBars.length; i++) {
			if (y >= i * 25) {
				progressBars[i].setVisible(true);
			} else {
				progressBars[i].setVisible(false);
			}
		}
	}

	public void subiendoPane(int y) {
		ProgressBar[] progressBars = { pb1, pb2, pb3, pb4, pb5 };
		for (int i = 0; i < progressBars.length; i++) {
			if (y >= i * 25) {
				progressBars[i].setVisible(true);
			} else {
				progressBars[i].setVisible(false);
			}
		}
	}
}
