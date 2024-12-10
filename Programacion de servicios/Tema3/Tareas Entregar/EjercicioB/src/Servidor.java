import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Creamos el servidor y lo vinculamos al puerto
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Esperando conexiones...");

            int contadorClientes = 1;

            while (true) {
                // Aceptamos una conexión
                Socket cS = ss.accept();

                // Creamos un nuevo hilo para gestionar al cliente
                Thread hiloCliente = new Thread(new ClienteHandler(cS, contadorClientes));
                hiloCliente.start();

                contadorClientes++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClienteHandler implements Runnable {
    private Socket clienteSocket;
    private int numeroCliente;

    public ClienteHandler(Socket socket, int numeroCliente) {
        this.clienteSocket = socket;
        this.numeroCliente = numeroCliente;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente " + numeroCliente + " conectado");

            // Leer el mensaje enviado por el cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            String mensajeCliente = in.readLine();
            System.out.println("Mensaje del cliente " + numeroCliente + ": " + mensajeCliente);

            // Enviar una respuesta al cliente
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
            out.println("Mensaje recibido");

            // Cerramos la conexión
            clienteSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


