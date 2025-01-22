package org.apache.maven.mascotas;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;

//import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mascota")
public class Mascota {
	@Id
	private String chip;
	@Column
	private String nombre;
	// @Column // No se ha de poner si es clave foránea
	@ManyToOne
	@JoinColumn(name = "cliente") // Clave foránea
	private Cliente cliente;
	// @Column // No se ha de poner si es clave foránea
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "especie") // Clave foránea
	private Especie especie;

//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "Mascota_Vacuna", joinColumns = @JoinColumn(name = "chip"), inverseJoinColumns = @JoinColumn(name = "vacuna"))
//	private ArrayList<Vacuna> vacunas;

	public Mascota() {
		super();
	}

	public Mascota(String chip, String nombre, Cliente cliente, Especie especie) {
		super();
		this.chip = chip;
		this.nombre = nombre;
		this.cliente = cliente;
		this.especie = especie;
//		this.vacunas = null;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

//	public ArrayList<Vacuna> getVacunas() {
//		return vacunas;
//	}
//
//	public void setVacunas(ArrayList<Vacuna> vacunas) {
//		this.vacunas = vacunas;
//	}

	@Override
	public String toString() {
		String out = nombre + ", " + especie.getEspecie() + " con chip " + chip;

//		if (vacunas != null) {
//			out = out + "(vacunado de ";
//			for (int i = 0; i < vacunas.size(); i++) {
//				out = out + vacunas.get(i);
//				// prevenir que no se inserte una comita en el último
//				if (i != vacunas.size() - 1) {
//					out = out + ", ";
//				} else {
//					out = out + ")";
//				}
//			}
//		}

		return out;
	}

}
