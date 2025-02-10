package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Productos {
	
	@Id
    private int id_producto;
    private String nombre;
    private String categoria;
    private float precio;
    private int stock;
	public int getIdProducto() {
		return id_producto;
	}
	public void setIdProducto(int idProducto) {
		this.id_producto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Productos(int idProducto, String nombre, String categoria, float precio, int stock) {
		super();
		this.id_producto = idProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [idProducto=" + id_producto + ", nombre=" + nombre + ", categoria=" + categoria + ", precio="
				+ precio + ", stock=" + stock + "]";
	}

    

}
