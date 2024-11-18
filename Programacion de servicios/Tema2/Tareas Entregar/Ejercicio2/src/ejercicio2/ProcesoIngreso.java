package ejercicio2;

public class ProcesoIngreso implements Runnable {
    private CuentaBancaria cuenta;
    private int cantidad;

    public ProcesoIngreso(CuentaBancaria cuenta, int cantidad) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        cuenta.ingresar(cantidad);
    }
}