package ejercicio2;

public class CuentaBancaria {
    
    private int saldo;

    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void ingresar(int cantidad) {
        this.saldo += cantidad;
    }

    public synchronized void retirar(int cantidad) {

        if (this.saldo >= cantidad) {

            this.saldo -= cantidad;
        } else {

            System.out.println("No hay suficiente saldo para retirar " + cantidad + " euros.");
        }
    }

    public int getSaldo() {
        return this.saldo;
    }
}

