package ejercicio3;

public class Taquilla {

    private int entradasDisponibles = 100;

    public synchronized void venderEntradas(int cantidad, String ventanilla) {

        if (entradasDisponibles >= cantidad) {

            entradasDisponibles -= cantidad;
            System.out.println(ventanilla + " vendió " + cantidad + " entradas. Quedan " + entradasDisponibles + " entradas.");
        } else {

            System.out.println(ventanilla + " no puede vender " + cantidad + " entradas. Quedan " + entradasDisponibles + " entradas.");
        }
    }

    public synchronized boolean quedanEntradas() {
        return entradasDisponibles > 0;
    }
}
