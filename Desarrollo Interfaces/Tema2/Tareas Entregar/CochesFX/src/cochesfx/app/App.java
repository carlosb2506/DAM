package cochesfx.app;

import cochesfx.app.controlador.AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        AppController controller = new AppController();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cochesfx/app/vista/coches.fxml"));
        loader.setController(controller);
        VBox vbox = loader.load();

        controller.cargarDatos();

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}
