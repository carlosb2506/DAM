package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatosArtista {
	private static DatosArtista instance;
    private ObservableList<Artista> listaArtistas;

    private DatosArtista() {
        listaArtistas = FXCollections.observableArrayList();
    }

    public static DatosArtista getInstance() {
        if (instance == null) {
            instance = new DatosArtista();
        }
        return instance;
    }

    public ObservableList<Artista> getListaArtistas() {
        return listaArtistas;
    }
}
