package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el archivo FXML
			Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
			
			Scene scene = new Scene(root, 400, 400);
			
			// Configura y muestra la ventana
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

