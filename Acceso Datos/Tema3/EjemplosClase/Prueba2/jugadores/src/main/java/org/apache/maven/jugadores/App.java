package org.apache.maven.jugadores;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        JugadorDAO jugadorDAO = new JugadorDAO();
        
        jugadorDAO.insertJugador(new Jugador("23323445F", "Carlitos Martinez", 23, 3434));
    }
}
