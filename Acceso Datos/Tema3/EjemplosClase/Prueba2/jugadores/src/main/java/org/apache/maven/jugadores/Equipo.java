package org.apache.maven.jugadores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo {
	
	@Id
	@Column(name = "cif")
	private String cif;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "presupuesto")
	private float presupuesto;

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Equipo(String cif, String nombre, float presupuesto) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}

	public Equipo() {
		super();
	}

	
}
