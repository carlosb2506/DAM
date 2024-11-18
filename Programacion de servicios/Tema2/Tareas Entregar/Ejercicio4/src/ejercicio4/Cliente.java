package ejercicio4;

public class Cliente extends Thread {
    private Servidor servidor;
    private String nombreCliente;

    public Cliente(Servidor servidor, String nombreCliente) {
        this.servidor = servidor;
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void run() {
        while (true) {
            Archivo archivo = servidor.obtenerArchivo();
            if (archivo == null) {
                break;
            }

            System.out.println(nombreCliente + " comenzó a descargar " + archivo.getNombre() + " (" + archivo.getTamaño() + " MB)");

            try {
                int tiempoDescarga = archivo.getTamaño() / 10 * 1000;
                for (int progreso = 0; progreso <= archivo.getTamaño(); progreso += 10) {
                    Thread.sleep(1000);
                    System.out.println(nombreCliente + " descargando " + archivo.getNombre() + ": " + progreso + "/" + archivo.getTamaño() + " MB");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(nombreCliente + " terminó de descargar " + archivo.getNombre());
        }
    }
}

