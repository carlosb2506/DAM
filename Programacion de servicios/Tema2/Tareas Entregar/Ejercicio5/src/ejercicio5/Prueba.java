package ejercicio5;

public class Prueba {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        Agencia agencia1 = new Agencia(hotel, "AGENCIA 1");
        Agencia agencia2 = new Agencia(hotel, "AGENCIA 2");
        Agencia agencia3 = new Agencia(hotel, "AGENCIA 3");
        Agencia agencia4 = new Agencia(hotel, "AGENCIA 4");

        agencia1.setPriority(Thread.MIN_PRIORITY);  
        agencia2.setPriority(Thread.NORM_PRIORITY); 
        agencia3.setPriority(Thread.MAX_PRIORITY);  
        agencia4.setPriority(Thread.NORM_PRIORITY); 

        agencia1.start();
        agencia2.start();
        agencia3.start();
        agencia4.start();

        try {
            agencia1.join();
            agencia2.join();
            agencia3.join();
            agencia4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TODAS LAS HABITACIONES ESTAN RESERVADAS");
    }
}
