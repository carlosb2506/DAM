package ejercicioEntradas;

public class Persona {
	private int dni;
	private String nombre;
	private String email;

	// Constructores
	public Persona() {

	}

	public Persona(int dni, String nombre, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	// Getters y Setters
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Método toString para mostrar la información de la persona
	@Override
	public String toString() {
		return "Persona{" + "dni=" + dni + ", nombre='" + nombre + '\'' + ", email='" + email + '\'' + '}';
	}
}