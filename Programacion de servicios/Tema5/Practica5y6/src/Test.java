public class Test {

	public static void main(String[] args) {

		Validacion validado = new Validacion();
		String telefono = new String();

		System.out.println("Introduce tu número de teléfono (Formato: +34 612345678):");
		telefono = System.console().readLine();

		validado.validar(telefono);

	}
}
