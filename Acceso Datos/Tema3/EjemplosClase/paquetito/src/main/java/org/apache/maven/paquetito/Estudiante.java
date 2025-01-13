package org.apache.maven.paquetito;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiantes")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estudiante_id")
	private int estudiante_id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "correo")
	private String correo;
	
	
	public int getEstudianteId() {
		return estudiante_id;
	}
	public void setEstudianteId(int id) {
		this.estudiante_id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Estudiante(int estudiante_id, String nombre, String correo) {
		super();
		this.estudiante_id = estudiante_id;
		this.nombre = nombre;
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Estudiante [id=" + estudiante_id + ", nombre=" + nombre + ", correo=" + correo + "]";
	}
	public Estudiante() {
		super();
	}
	
}
