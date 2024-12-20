import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjercicioA {

	public static void main(String[] args) {
		try {
			// obtenemos y mostramos la dirección local
			System.out.println("MI MÁQUINA ES: " + InetAddress.getLocalHost());

			// obtenemos y mostramos la dirección IP
			System.out.println("DIRECCIÓN: " + InetAddress.getLocalHost().getHostAddress());

			// obtenemos y mostramos el nombre
			System.out.println("NOMBRE: " + InetAddress.getLocalHost().getHostName());

			// obtenemos y mostramos la dirección IP utilizando el nombre
			System.out.println("NOMBRE CON EL MÉTODO (getByName): " + InetAddress.getByName(InetAddress.getLocalHost().getHostName()));

			// obtenemoos y mostramos los bytes de la dirección IP
			byte[] address = InetAddress.getLocalHost().getAddress();

			for (byte b : address) {
				System.out.println("CON LA MATRIZ .getAddress():" + (b & 0xFF));
			}

		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
	}
}
