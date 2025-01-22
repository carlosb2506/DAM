package org.apache.maven.mascotas;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table (name= "Vacuna")
public class Vacuna {
	
	@Id
	private String vacuna;
	@Column
	private float precio; // Precio en euros
//	@ManyToMany(mappedBy = "vacunas")
//    private ArrayList<Mascota> mascotas;

	public Vacuna() {
		super();
	}

	public Vacuna(String vacuna, float precio) {
		super();
		this.vacuna = vacuna;
		this.precio = precio;
	}

	public String getVacuna() {
		return vacuna;
	}

	public void setVacuna(String vacuna) {
		this.vacuna = vacuna;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vacuna [vacuna=" + vacuna + ", precio=" + precio + "]";
	}

}
