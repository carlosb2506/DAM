package ejercicio5;

import java.util.Random;

public class Agencia extends Thread {
    private Hotel hotel;
    private String nombreAgencia;
    private int habitacionesReservadas;

    public Agencia(Hotel hotel, String nombreAgencia) {
        this.hotel = hotel;
        this.nombreAgencia = nombreAgencia;
        this.habitacionesReservadas = 0;
    }
    @Override
    public void run() {
        Random random = new Random();
        while (hotel.quedanHabitaciones()) {

            int habitacionesAReservar = random.nextInt(4) + 1;

            System.out.println(nombreAgencia + " ESTÁ INTENTANDO RESERVAR " + habitacionesAReservar + " HABITACIONES");

            if (hotel.reservarHabitaciones(habitacionesAReservar, nombreAgencia)) {
                habitacionesReservadas += habitacionesAReservar;
            }
            try {
            	  Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombreAgencia + " HA RESERVADO EN TOTAL:" + habitacionesReservadas + " HABITACIONES");
    }
}
