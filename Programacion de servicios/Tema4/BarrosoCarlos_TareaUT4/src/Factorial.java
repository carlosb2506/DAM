import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

public class Factorial implements HttpHandler {

	private HttpServer servidor;

	public Factorial(HttpServer servidor) {
		this.servidor = servidor;
	}

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		String respuesta;

		if ("GET".equals(exchange.getRequestMethod())) {

			String query = exchange.getRequestURI().getQuery();

			// Verifica si hay un parámetro 'number' en la consulta.
			if (query != null && query.startsWith("number=")) {
				try {

					int numero = Integer.parseInt(query.split("=")[1]);

					// Verificamos que el numero no sea negativo.
					if (numero < 0) {
						respuesta = "EL NÚMERO NO PUEDE SER NEGATIVO";
					} else {

						// Calculamos el factorial del número.
						BigInteger factorial = calculateFactorial(numero);
						respuesta = "EL FACTORIAL DE: " + numero + " ES: " + factorial;
					}
				} catch (NumberFormatException e) {

					respuesta = "EL PARÁMETRO 'NUMBER' DEBE SER UN NÚMERO ENTERO";
				}
			} else {

				respuesta = "POR FAVOR, PROPORCIONA UN NÚMERO USANDO EL PARAMETRO 'NUMBER'. EJEMPLO: /factorial?number=5";
			}
		} else {

			respuesta = "MÉTODO NO SOPORTADO";
		}

		exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=utf-8");

		exchange.sendResponseHeaders(200, respuesta.getBytes().length);
		try (OutputStream os = exchange.getResponseBody()) {
			os.write(respuesta.getBytes());
		}
	}

	public BigInteger calculateFactorial(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;

	}

}
