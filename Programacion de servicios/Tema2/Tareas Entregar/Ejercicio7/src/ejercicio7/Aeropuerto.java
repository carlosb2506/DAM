package ejercicio7;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Aeropuerto {
    private PriorityQueue<Avion> colaPrioridades; 
    private static final Lock pista = new ReentrantLock();  

    public Aeropuerto() {
        colaPrioridades = new PriorityQueue<>(); 
    }

    public synchronized void pedirAterrizar(Avion avion) {
        colaPrioridades.offer(avion);
        System.out.println(avion.getNombre() + " HA SOLICITADO ATERRIZAR");
    }

    public void aterrizar() {
        try {
            while (!colaPrioridades.isEmpty()) {

                Avion siguienteAvion = colaPrioridades.poll();

                System.out.println(siguienteAvion.getNombre() + " ESTÁ ATERRIZANDO");

                pista.lock();  
                try {
                    System.out.println(siguienteAvion.getNombre() + " ESTÁ ATERRIZANDO...");

                    Thread.sleep(1000);  
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    pista.unlock();  
                }
                break; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
