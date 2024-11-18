package ejercicio7;

public class Test {
    public static void main(String[] args) {
    	
        Aeropuerto aeropuerto = new Aeropuerto();

        Avion avion1 = new Avion("AVIÓN A", 5, aeropuerto);
        Avion avion2 = new Avion("AVIÓN B", 2, aeropuerto);
        Avion avion3 = new Avion("AVIÓN C", 8, aeropuerto);
        Avion avion4 = new Avion("AVIÓN D", 1, aeropuerto);
        Avion avion5 = new Avion("AVIÓN E", 10, aeropuerto);

        aeropuerto.pedirAterrizar(avion1);
        aeropuerto.pedirAterrizar(avion2);
        aeropuerto.pedirAterrizar(avion3);
        aeropuerto.pedirAterrizar(avion4);
        aeropuerto.pedirAterrizar(avion5);

        avion1.start();
        avion2.start();
        avion3.start();
        avion4.start();
        avion5.start();

        try {
            avion1.join();
            avion2.join();
            avion3.join();
            avion4.join();
            avion5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("TODOS LOS AVIONES HAN ATERRIZADO");
    }
}