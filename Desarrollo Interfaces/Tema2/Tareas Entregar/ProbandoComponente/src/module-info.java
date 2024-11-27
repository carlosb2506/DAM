module ProbandoComponente {
	requires javafx.controls;
	requires javafx.fxml;
	requires miComponente;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
