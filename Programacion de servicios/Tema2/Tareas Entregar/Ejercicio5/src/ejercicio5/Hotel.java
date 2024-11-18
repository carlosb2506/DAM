package ejercicio5;

public class Hotel {
    private int habitacionesDisponibles;

    public Hotel() {
        this.habitacionesDisponibles = 50;
    }
    public synchronized boolean reservarHabitaciones(int cantidad, String agencia) {
        if (habitacionesDisponibles >= cantidad) {
            habitacionesDisponibles -= cantidad;
            System.out.println(agencia + " HA RESERVADO " + cantidad + " HABITACIONES, QUEDAN " + habitacionesDisponibles + " HABITACIONES");
            return true;
        } else {
            System.out.println(agencia + " NO PUEDE RESERVAR HABITACIONES " + cantidad + " HABITACIONES, NO HAY SUFICIENTES HABITACIONES");
            return false; 
        }
    }
    public synchronized boolean quedanHabitaciones() {
        return habitacionesDisponibles > 0;
    }
}

