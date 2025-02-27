package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proveedores")
public class Proveedores {

	@Id
	private int id_proveedor;
	private String nombre;
	private String contacto;
	private String direccion;

	public int getIdProveedor() {
		return id_proveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.id_proveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Proveedores() {
		super();
	}

	public Proveedores(int idProveedor, String nombre, String contacto, String direccion) {
		super();
		this.id_proveedor = idProveedor;
		this.nombre = nombre;
		this.contacto = contacto;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "NOMBRE: " + nombre + ", TELÉFONO: " + contacto
				+ ", DIRECCIÓN: " + direccion;
	}

}