package ejercicio1;

public class Almacen {
    private int productosDisponibles; 

    public Almacen(int productos) {
    	
        this.productosDisponibles = productos;
        
    }

    public synchronized boolean clienteEntra(Cliente cliente) {

        if (productosDisponibles > 0) {
            productosDisponibles--; 
            System.out.println("El cliente " + cliente.getId() + " ha entrado y tomó un producto. Productos restantes: " + productosDisponibles);
            return true; 
        } else {

            System.out.println("El cliente " + cliente.getId() + " ha entrado pero no quedan productos.");
            return false; 
        }
    }
}
