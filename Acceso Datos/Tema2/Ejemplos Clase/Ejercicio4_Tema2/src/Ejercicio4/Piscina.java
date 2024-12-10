package Ejercicio4;

public class Piscina {
	
	//Atributos
	private int id;
	private String modelo;
	private int capacidad;
	private String fechafab;
	
	
	//Constructores
	public Piscina(){
		
	}
	
	public Piscina(String modelo, int capacidad, String fechafab){
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.fechafab = fechafab;
	}
	
	
	public Piscina(int id, String modelo, int capacidad, String fechafab){
		this.id = id;
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.fechafab = fechafab;
	}
	
	
	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getFechafab() {
		return fechafab;
	}

	public void setFechafab(String fechafab) {
		this.fechafab = fechafab;
	}
	

	//Metodos
	@Override
	public String toString() {
		return modelo + " " + capacidad + " " + fechafab;
	}

}
