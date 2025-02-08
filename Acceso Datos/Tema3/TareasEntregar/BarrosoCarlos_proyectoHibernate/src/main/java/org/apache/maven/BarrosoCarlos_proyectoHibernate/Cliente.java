package org.apache.maven.BarrosoCarlos_proyectoHibernate;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Cliente(int idCliente, String nombre, String direccion, String telefono, String email) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", email=" + email + "]";
	}

    
}