package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Servidor {
    private List<Archivo> archivos;

    public Servidor(int numArchivos) {
        archivos = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numArchivos; i++) {
            archivos.add(new Archivo("Archivo " + (i + 1), random.nextInt(501) + 500));
        }
    }

    public synchronized Archivo obtenerArchivo() {
        if (archivos.isEmpty()) {
            return null; 
        }
        return archivos.remove(0);
    }

    public synchronized boolean quedanArchivos() {
        return !archivos.isEmpty();
    }
}

