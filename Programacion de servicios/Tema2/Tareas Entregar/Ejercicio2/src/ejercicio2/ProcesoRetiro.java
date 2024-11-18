package ejercicio2;

public class ProcesoRetiro implements Runnable {
    private CuentaBancaria cuenta;
    private int cantidad;

    public ProcesoRetiro(CuentaBancaria cuenta, int cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        cuenta.retirar(cantidad);
    }
}
