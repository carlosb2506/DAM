package calculatorFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
	Parent root = FXMLLoader.load(getClass().getResource("/calculatorFX/Calculadora.fxml"));
        primaryStage.setTitle("Calculadora JavaFX");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

