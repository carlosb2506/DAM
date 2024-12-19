module Comp_Pr3_2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml;
}
