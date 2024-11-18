package ejercicio2;

public class Banco {
	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(100);

		Thread[] procesosIngresos = new Thread[120];
		Thread[] procesosRetiros = new Thread[120];

		for (int i = 0; i < 40; i++) {
			procesosIngresos[i] = new Thread(new ProcesoIngreso(cuenta, 100));
		}

		for (int i = 40; i < 60; i++) {
			procesosIngresos[i] = new Thread(new ProcesoIngreso(cuenta, 50));
		}

		for (int i = 60; i < 120; i++) { 
			procesosIngresos[i] = new Thread(new ProcesoIngreso(cuenta, 20));
		}

		for (int i = 0; i < 40; i++) {
			procesosRetiros[i] = new Thread(new ProcesoRetiro(cuenta, 100));
		}

		for (int i = 40; i < 60; i++) {
			procesosRetiros[i] = new Thread(new ProcesoRetiro(cuenta, 50));
		}

		for (int i = 60; i < 120; i++) {
			procesosRetiros[i] = new Thread(new ProcesoRetiro(cuenta, 20));
		}

		for (Thread proceso : procesosIngresos) {
			proceso.start();
		}

		for (Thread proceso : procesosIngresos) {
			try {
				proceso.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (Thread proceso : procesosRetiros) {
			proceso.start();
		}

		for (Thread proceso : procesosRetiros) {
			try {
				proceso.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Saldo final en la cuenta: " + cuenta.getSaldo() + " euros.");
		if (cuenta.getSaldo() == 100) {
			System.out.println("El saldo final es correcto.");
		} else {
			System.out.println("El saldo final es incorrecto.");
		}
	}
}
