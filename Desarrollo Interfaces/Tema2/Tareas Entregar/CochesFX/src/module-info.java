module Coches {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires org.apache.commons.csv;
	requires java.sql;
	
	opens cochesfx.app to javafx.graphics, javafx.fxml;
	opens cochesfx.app.controlador to javafx.fxml;
}
