module CalcFX {
//	exports calculatorFX;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens calculatorFX to javafx.fxml, javafx.graphics;
}