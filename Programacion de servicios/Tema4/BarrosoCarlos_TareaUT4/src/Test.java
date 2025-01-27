import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Test {

	public static void main(String[] args) throws IOException {
		
		// Creamos el servidor en el puerto 8080
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

		server.createContext("/factorial", new Factorial(server));

		// Aquí iniciamos el servidor
		server.setExecutor(null);
		System.out.println("Servidor iniciado en http://localhost:8080");
		server.start();
		
	}
}
