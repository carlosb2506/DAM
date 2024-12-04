package simulacroexamen;

public class Juegos {
	private String nombre;
	private float precio;
	private boolean adultos;
	public Juegos() {
		super();
	}
	public Juegos(String nombre, float precio, boolean adultos) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.adultos = adultos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isAdultos() {
		return adultos;
	}
	public void setAdultos(boolean adultos) {
		this.adultos = adultos;
	}
	@Override
	public String toString() {
		return "Juegos [nombre=" + nombre + ", precio=" + precio + ", adultos=" + adultos + "]";
	}

	
}
