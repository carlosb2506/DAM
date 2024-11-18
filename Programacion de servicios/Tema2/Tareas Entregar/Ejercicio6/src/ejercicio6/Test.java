package ejercicio6;

public class Test {
	public static void main(String[] args) {
		LineaProduccion linea = new LineaProduccion();

		Thread operario1 = new Thread(new Operario(linea, "OPERARIO 1"));
		Thread operario2 = new Thread(new Operario(linea, "OPERARIO 2"));
		Thread operario3 = new Thread(new Operario(linea, "OPERARIO 3"));

		operario1.start();
		operario2.start();
		operario3.start();

		try {
			operario1.join();
			operario2.join();
			operario3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("¡TODAS LAS PIEZAS HAN SIDO ENSAMBLADAS!");
	}
}
