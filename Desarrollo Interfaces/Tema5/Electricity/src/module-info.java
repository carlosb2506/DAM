module Electricity {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires java.sql;
	requires javafx.graphics;
	requires net.sf.jasperreports.core;
	requires javafx.web;
	
	opens application to javafx.graphics, javafx.fxml;
}
