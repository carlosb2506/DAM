package org.apache.maven.jugadores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignacion")
public class Asignacion {
	
	@Id
	@Column(name = "jugador")
	private String jugador;
	
	@Id
	@Column(name = "equipo")
	private String equipo;
	
	

}
