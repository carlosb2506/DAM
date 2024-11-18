package ejercicio6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LineaProduccion {

    private static final int NUM_PIEZAS = 30;
    private int piezasDisponibles = NUM_PIEZAS;
    private Lock lock = new ReentrantLock();

    public void ensamblarPieza(String nombreOperario) {
        lock.lock();
        try {
            if (piezasDisponibles > 0) {
                piezasDisponibles--; 
                System.out.println(nombreOperario + " ESTÁ ENSAMBLANDO UNA PIEZA, PIEZAS RESTANTES: " + piezasDisponibles);
            } else {
                System.out.println(nombreOperario + " NO HAY MAS PIEZAS PARA ENSAMBLAR");
            }
        } finally {
            lock.unlock(); 
        }
    }

    public boolean hayPiezasDisponibles() {
        return piezasDisponibles > 0;
    }
}
