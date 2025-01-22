package org.apache.maven.mascotas;

//import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	/*
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) Sólo lo usaremos cuando
	 * el id sea AUTOINCREMENT en la BBDD
	 */
	// @Column(name = "dni") // si se llamara distinto
	private String dni;
	@Column
	// @Column(name = "nombre") // si se llamara distinto
	private String nombre;
	@Column
	private String apellidos;

	/*
	 * Ojo con esto porque intentará hacer la siguiente SELECT: select
	 * c1_0.dni,c1_0.apellidos,c1_0.mascotas,c1_0.nombre from Cliente c1_0 where
	 * c1_0.dni=? y el campo mascotas no existe en la tabla
	 */
	// @OneToMany
	// @JoinColumn(name = "cliente") // Clave foránea
	// private ArrayList<Mascota> mascotas;

	public Cliente() {
		super();
	}

	public Cliente(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		// this.mascotas = null;
	}

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	// public ArrayList<Mascota> getMascotas() {
	// return mascotas;
	// }
	//
	// public void setMascotas(ArrayList<Mascota> mascotas) {
	// this.mascotas = mascotas;
	// }

	@Override
	public String toString() {
		String out = "Cliente: " + nombre + " " + apellidos + ", con DNI " + dni;

		// Código para mostrar la lista de mascotas si la tuviera como atributo:
		// if (mascotas != null) {
		// out = out + ", tiene a: ";
		// for (int i = 0; i < mascotas.size(); i++) {
		// out = out + mascotas.get(i);
		// // prevenir que no se inserte una comita en el último
		// if (i != mascotas.size() - 1) {
		// out = out + ", ";
		// } else {
		// out = out + ".";
		// }
		// }
		// } else {
		// out = out + ", no tiene mascotas ya.";
		// }

		return out;
	}

}
