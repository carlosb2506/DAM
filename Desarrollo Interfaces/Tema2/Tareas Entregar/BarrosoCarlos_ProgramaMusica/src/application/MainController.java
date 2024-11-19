package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class MainController {

    @FXML
    private StackPane contentPane;

    @FXML
    private void showAlbumView() {
        try {
            AnchorPane albumView = FXMLLoader.load(getClass().getResource("Sample.fxml"));
            contentPane.getChildren().setAll(albumView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showArtistaView() {
        try {
            AnchorPane artistaView = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
            contentPane.getChildren().setAll(artistaView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

