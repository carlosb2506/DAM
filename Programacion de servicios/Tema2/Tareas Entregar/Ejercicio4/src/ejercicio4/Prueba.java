package ejercicio4;

public class Prueba {
    public static void main(String[] args) {

        Servidor servidor = new Servidor(5);

        Cliente cliente1 = new Cliente(servidor, "Cliente 1");
        Cliente cliente2 = new Cliente(servidor, "Cliente 2");
        Cliente cliente3 = new Cliente(servidor, "Cliente 3");

        cliente1.start();
        cliente2.start();
        cliente3.start();

        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todas las descargas han finalizado.");
    }
}
