import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

	Pattern pat = null;
	Matcher mat = null;

	public void validar(String telefono) {

		try {

			// Expresión para validar el teléfono
			pat = Pattern.compile("\\+\\d{1,3}\\s\\d{9}");
			mat = pat.matcher(telefono);

			// Comprobamos aqui si el número es correcto o no
			if (mat.matches()) {
				System.out.println("El teléfono: " + telefono + " es correcto!!");
			} else {
				System.out.println("El teléfono: " + telefono + " está mal ");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
