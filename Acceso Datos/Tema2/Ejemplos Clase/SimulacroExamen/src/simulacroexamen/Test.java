package simulacroexamen;

public class Test {
	
	public static void main(String[] args) {
		MOSE nose = new MOSE();
		
		System.out.println("DIME EL NOMBRE DEL USUARIO QUE DESEAS AÑADIR SALDO: ");
		String nomUser = System.console().readLine();
		System.out.println("DIME EL SALDO QUE DESEAS AÑADIR: ");
		double saldoAniadir = Double.parseDouble(System.console().readLine());
		
		nose.recargaSaldo(nomUser, saldoAniadir);
		
		
	}

}
