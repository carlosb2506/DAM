package ejercicio3;

import java.util.Random;

public class Ventanilla extends Thread {
    private Taquilla taquilla; 
    private String nombreVentanilla; 

    public Ventanilla(Taquilla taquilla, String nombreVentanilla) {
        this.taquilla = taquilla;
        this.nombreVentanilla = nombreVentanilla;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (taquilla.quedanEntradas()) {
            try {
                System.out.println(Thread.currentThread().getName() + " - Estado: " + Thread.currentThread().getState() 
                                   + " - " + nombreVentanilla + " esperando para vender.");

                Thread.sleep(random.nextInt(1000));

                int cantidad = random.nextInt(5) + 1;
                taquilla.venderEntradas(cantidad, nombreVentanilla);

                System.out.println(Thread.currentThread().getName() + " - Estado: " + Thread.currentThread().getState()
                                   + " - " + nombreVentanilla + " vendió " + cantidad + " entradas.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombreVentanilla + " ha terminado de vender entradas.");
    }
}

