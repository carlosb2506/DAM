package ejercicio1;

public class Ejercicio1 {
	public static void main(String[] args) {
        int totalClientes = 300;
        int productos = 100; 
        int maxIntentos = 10;

        Almacen almacen = new Almacen(productos);
        Cliente[] clientes = new Cliente[totalClientes]; 
        
        for (int i = 0; i < totalClientes; i++) {
        	int num = (int) (Math.random() * 300);
            clientes[i] = new Cliente(num + 1);
        }

        for (Cliente cliente : clientes) {

            if (cliente.intentaEntrar(maxIntentos)) {
                almacen.clienteEntra(cliente); 
            } else {
                System.out.println("El cliente " + cliente.getId() + " se marcha después de 10 intentos.");
            }
        }
    }
}
