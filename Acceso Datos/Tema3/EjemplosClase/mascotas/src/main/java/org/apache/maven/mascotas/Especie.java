package org.apache.maven.mascotas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Especie")
public class Especie {
	
	@Id
	private String especie;
	@Column
	private int vida; // Esperanza de vida media en años

	public Especie() {
		super();
	}

	public Especie(String especie, int vida) {
		super();
		this.especie = especie;
		this.vida = vida;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@Override
	public String toString() {
		return "Especie [especie=" + especie + ", vida=" + vida + "]";
	}

}
