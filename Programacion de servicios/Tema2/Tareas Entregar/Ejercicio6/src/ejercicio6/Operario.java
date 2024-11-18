package ejercicio6;

import java.util.Random;

public class Operario implements Runnable {
    private LineaProduccion linea;
    private String nombre;

    public Operario(LineaProduccion linea, String nombre) {
        this.linea = linea;
        this.nombre = nombre;
    }
    @Override
    public void run() {
        while (linea.hayPiezasDisponibles()) {
            linea.ensamblarPieza(nombre);
            try {
                Random rand = new Random();
                int tiempoEnsamblaje = 500 + rand.nextInt(1500);
                Thread.sleep(tiempoEnsamblaje);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(nombre + " HA TERMINADO SU TRABAJO.");
    }
}
