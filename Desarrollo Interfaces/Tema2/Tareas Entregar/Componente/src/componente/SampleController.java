package application;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

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

	public void initialize() {
		System.out.println("inicializa");
		pb1.setVisible(true);
		pb2.setVisible(false);
		pb3.setVisible(false);
		pb4.setVisible(false);
		pb5.setVisible(false);
	}

//	@FXML
//	public void funcionSlider(MouseEvent event) {
//		System.out.println("funciona esto de clikar el raton");
//		double value = slider.getValue();
//		subiendo((int) value);
//	}
//
//	public void subiendo(int y) {
//		System.out.println("por aqui entraa");
//		ProgressBar[] progressBars = { pb1, pb2, pb3, pb4, pb5 };
//
//		for (int i = 0; i < progressBars.length; i++) {
//			if (y >= progressBars[i].getLayoutX()) {
//				progressBars[i].setVisible(true);
//			} else {
//				progressBars[i].setVisible(false);
//			}
//		}
//	}
	
	@FXML
	public void funcionSlider(MouseEvent event) {
	    System.out.println("funciona esto de clikar el raton");
	    double value = slider.getValue();
	    subiendo((int) value);
	}

	public void subiendo(int y) {
	    System.out.println("por aqui entraa");
	    ProgressBar[] progressBars = { pb1, pb2, pb3, pb4, pb5 };

	    for (int i = 0; i < progressBars.length; i++) {
	        if (y >= i * 20) { 
	            progressBars[i].setVisible(true);
	        } else {
	            progressBars[i].setVisible(false);
	        }
	    }
	}

}