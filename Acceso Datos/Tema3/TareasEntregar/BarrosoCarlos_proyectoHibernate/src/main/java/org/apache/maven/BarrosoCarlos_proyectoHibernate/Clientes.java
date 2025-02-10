package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Clientes {
	
	@Id
    private int id_cliente;
	private String nombre;
    private String direccion;
    private String telefono;
    private String email;
	public int getIdCliente() {
		return id_cliente;
	}
	public void setIdCliente(int idCliente) {
		this.id_cliente = idCliente;
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
    public Clientes() {
		super();
	}
	public Clientes(int idCliente, String nombre, String direccion, String telefono, String email) {
		super();
		this.id_cliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Id: " + id_cliente + ", Nombre: " + nombre + ", Direccion: " + direccion + ", Telefono: " + telefono + ", Email: " + email;
	}

    
}