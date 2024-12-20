import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Nos conectamos al servidor en el puerto 5000
            Socket socket = new Socket("localhost", 5000);

            // Enviamos un mensaje al servidor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hola, servidor");

            // Leemos la respuesta del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerramos la conexión
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

