import java.io.*;
import java.net.*;

public class Test {

    public static void main(String[] args) {
        // Creamos y lanzamos el servidor en un hilo separado para que esté corriendo en paralelo
        Thread servidorThread = new Thread(() -> {
            Servidor.main(null);
        });
        servidorThread.start();

        // Esperamos un momento para asegurarnos de que el servidor esté escuchando
        try {
            Thread.sleep(1000); // Esperamos 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simulamos varios clientes que se conectan al servidor
        for (int i = 1; i <= 5; i++) {
            final int clienteId = i;
            new Thread(() -> {
                Cliente.main(new String[]{});
            }).start();
        }
    }
}

