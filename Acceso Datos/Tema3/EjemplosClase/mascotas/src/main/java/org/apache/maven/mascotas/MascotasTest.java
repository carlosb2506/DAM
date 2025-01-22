package org.apache.maven.mascotas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Hello world!
 */
public class MascotasTest {
	public static void main(String[] args) {

		MascotasDAO mdao = new MascotasDAO();

		System.out.println("------- PRUEBAS -------");

		// Obtener cliente por su dni
		Cliente c = mdao.getClienteByDni("23456789B");

		if (c != null) {
			System.out.println(c);
		} else {
			System.out.println("Cliente no encontrado :(");
		}

		// Obtener mascota por su nombre
		Mascota m = mdao.getMascotaByNombre("Chester");

		if (m != null) {
			System.out.println(m);
		} else {
			System.out.println("Mascota no encontrada :(");
		}

		// Obtener varias mascotas
		ArrayList<Mascota> mascotas = mdao.buscarMascotas("M%");
		System.out.println("Lista de mascotas que empiezan por M:");
		for (Mascota masc : mascotas) {
			System.out.println(masc);
		}

		// Guardar nuevo cliente
		 c = new Cliente("1234567T", "Pepón", "Montgomery");
		 mdao.newCliente(c);

		// Modificar cliente existente
		c = new Cliente("1234567T", "Big Pepe", "Of the Mountains");
		mdao.modifyCliente(c);
		
		//Buscar Mascota por chip
		Mascota mm = mdao.buscarMascotasporChip("C00008H");
		
		System.out.println(mm);
		
		//Mostrar Cliente por apellido
		
		ArrayList<Cliente> clientes = mdao.buscarCliente("Pérez");
		System.out.println("Clientes con apellido Pérez:");
		for (Cliente clt : clientes) {
			System.out.println(clt);
		}

		// Obtener las vacunas de una mascota
//		ArrayList<Vacuna> vacunas = mdao.getVacunasByMascota(new Mascota("P00003C",null,null,null));
//		System.out.println("Vacunas de " + m.getNombre() + ": ");
//		for (Vacuna v : vacunas) {
//			System.out.println(v);
//		}
	}
}
