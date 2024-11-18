package ejercicio7;

public class Avion extends Thread implements Comparable<Avion> {
    private int combustible;  
    private String nombre;    
    private Aeropuerto aeropuerto; 

    public Avion(String nombre, int combustible, Aeropuerto aeropuerto) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.aeropuerto = aeropuerto;
    }

    @Override
    public void run() {
        try {
            System.out.println(nombre + " está esperando para aterrizar con " + combustible + " unidades de combustible.");
            
            aeropuerto.aterrizar();
            
            Thread.sleep(1000);
            System.out.println(nombre + " ha aterrizado.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int compareTo(Avion otroAvion) {
        return Integer.compare(this.combustible, otroAvion.combustible);
    }

    public void decrecerCombustible() {
        if (combustible > 0) {
            combustible--;
        }
    }

    public int getCombustible() {
        return combustible;
    }

    public String getNombre() {
        return nombre;
    }
}
