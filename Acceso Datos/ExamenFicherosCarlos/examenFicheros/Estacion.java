package examenFicheros;

import java.util.ArrayList;

public class Estacion {

	private String name;
	private Coordenada site;
	private ArrayList<String> people;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordenada getSite() {
		return site;
	}
	public void setSite(Coordenada site) {
		this.site = site;
	}
	public ArrayList<String> getPeople() {
		return people;
	}
	public void setPeople(ArrayList<String> people) {
		this.people = people;
	}
	
	public Estacion(String name, Coordenada site) {

		this.name = name;
		this.site = site;
	}
	
	@Override
	public String toString() {
		String station;
		
		
		//cambia el string segun si tiene gente o no
		if(this.people!=null) {
			station="Estación "+this.name +", situada en "+site+", está habitada por: "+peopleStringScreen()+".";
		}else {
			station="Estación "+this.name +", situada en "+site+", está inhabitada.";
		}
		
		
		return station;
		
	}
	
	
	//funcion para escribir las estaciones en el fichero mas facilmente
	public String putString() {
		String station;
		
		
		//cambia el string segun si tiene gente o no
		if(this.people!=null) {
			station=name+";"+site+";"+peopleString();
		}else {
			station=name+";"+site;
		}
		
		
		return station;
	}
	
	
	//funcion concreta para quitar los []
	public String peopleString() {
		String newLine="";
		
		for(int i =0;i<this.people.size();i++) {
			
			newLine+=this.people.get(i)+" ";
			
		}
		
		
		return newLine;
		
		
		
	}
	
	//funcion concreta para quitar los [] y PONER COMAS
	public String peopleStringScreen() {
		String newLine="";
		
		for(int i =0;i<this.people.size();i++) {
			if(i==0) {
				newLine+=this.people.get(i);
			}else {
				newLine+=", "+this.people.get(i);
			}
			
		}
		
		
		return newLine;
		
		
		
	}
	
	
}
