package application;

//import javafx.collections.FXCollections;
//import javafx.fxml.FXML;
//import javafx.scene.control.Spinner;
//import javafx.scene.control.SpinnerValueFactory;
//
//public class SampleController {
//
//	@FXML
//	private Spinner<String> mySpinner;
//
//	@FXML
//	public void initialize() {
//		
//		Spinner<String> stringgSpinner = new Spinner<>();
//		stringgSpinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>( FXCollections.observableArrayList("Opción 1", "Opción 2", "Opción 3") ));
//
//		
//		mySpinner.setValueFactory(stringgSpinner);
//	}
//}

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class SampleController {

    @FXML
    private Spinner<String> mySpinner;

    @FXML
    public void initialize() {
        // Rellenar el Spinner con una lista de cadenas
        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(
                FXCollections.observableArrayList("Opción 1", "Opción 2", "Opción 3")
        );
        mySpinner.setValueFactory(valueFactory);
    }
}
