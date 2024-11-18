package ejercicio3;

public class Cine {
	public static void main(String[] args) {
        Taquilla taquilla = new Taquilla();

        Ventanilla ventanilla1 = new Ventanilla(taquilla, "Ventanilla 1");
        Ventanilla ventanilla2 = new Ventanilla(taquilla, "Ventanilla 2");
        Ventanilla ventanilla3 = new Ventanilla(taquilla, "Ventanilla 3");

        ventanilla1.setPriority(Thread.MIN_PRIORITY);
        ventanilla2.setPriority(Thread.NORM_PRIORITY); 
        ventanilla3.setPriority(Thread.MAX_PRIORITY);  

        System.out.println("Estado antes de iniciar: ");
        System.out.println(ventanilla1.getName() + " - " + ventanilla1.getState());
        System.out.println(ventanilla2.getName() + " - " + ventanilla2.getState());
        System.out.println(ventanilla3.getName() + " - " + ventanilla3.getState());

        ventanilla1.start();
        ventanilla2.start();
        ventanilla3.start();

        try {
            ventanilla1.join();
            ventanilla2.join();
            ventanilla3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los hilos han terminado.");
    }
}
