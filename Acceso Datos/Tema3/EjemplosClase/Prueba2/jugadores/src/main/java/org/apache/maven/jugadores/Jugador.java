package org.apache.maven.jugadores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugador")
public class Jugador {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String dni;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "sueldo")
	private float sueldo;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public Jugador(String dni, String nombre, int edad, float sueldo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}

	public Jugador() {
		super();
	}

	@Override
	public String toString() {
		return "Jugador [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}

}
