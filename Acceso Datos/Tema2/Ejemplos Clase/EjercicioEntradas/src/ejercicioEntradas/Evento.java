package ejercicioEntradas;

public class Evento {
	private int codEv;
	private String nombre;
	private String ubicacion;
	private double precio;

	// Constructores
	public Evento() {

	}

	public Evento(int codEv, String nombre, String ubicacion, double precio) {
		this.codEv = codEv;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.precio = precio;
	}

	// Getters y Setters
	public int getCodEv() {
		return codEv;
	}

	public void setCodEv(int codEv) {
		this.codEv = codEv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	// Método toString para mostrar la información del evento
	@Override
	public String toString() {
		return "Evento{" + "codEv=" + codEv + ", nombre='" + nombre + '\'' + ", ubicacion='" + ubicacion + '\''
				+ ", precio=" + precio + '}';
	}
}
