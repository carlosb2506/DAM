import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

public class Factorial implements HttpHandler {

	private HttpServer server;

	// Constructor que recibe el servidor como un parámetro
	public Factorial(HttpServer server) {
		this.server = server;
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String response;

		if ("GET".equals(exchange.getRequestMethod())) {

			// Obtiene los parámetros de la URL de la solicitud.
			String query = exchange.getRequestURI().getQuery();

			// Verifica si hay un parámetro 'number' en la consulta.
			if (query != null && query.startsWith("number=")) {
				try {
					// Extraemos el valor del parámetro 'number' y le hacemos casting a entero.
					int number = Integer.parseInt(query.split("=")[1]);

					// Verificamos que el numero no sea negativo.
					if (number < 0) {
						response = "EL NÚMERO NO PUEDE SER NEGATIVO";
					} else {

						// Calculamos el factorial del número.
						BigInteger factorial = calculateFactorial(number);
						response = "EL FACTORIAL DE: " + number + " ES: " + factorial;
					}
				} catch (NumberFormatException e) {

					response = "EL PARÁMETRO 'NUMBER' DEBE SER UN NÚMERO ENTERO";
				}
			} else {

				response = "POR FAVOR, PROPORCIONA UN NÚMERO USANDO EL PARAMETRO 'NUMBER'. EJEMPLO: /factorial?number=5";
			}
		} else {

			response = "MÉTODO NO SOPORTADO";
		}

		exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");

		// Envia el código de respuesta HTTP (200 OK) y el contenido de la respuesta.
		exchange.sendResponseHeaders(200, response.getBytes().length);
		try (OutputStream os = exchange.getResponseBody()) {
			os.write(response.getBytes());
		}

		// Detiene el servidor después de manejar la solicitud
//		server.stop(0);
//		System.out.println("SERVIDOR DETENIDO.");
	}

	public BigInteger calculateFactorial(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;

	}

}
