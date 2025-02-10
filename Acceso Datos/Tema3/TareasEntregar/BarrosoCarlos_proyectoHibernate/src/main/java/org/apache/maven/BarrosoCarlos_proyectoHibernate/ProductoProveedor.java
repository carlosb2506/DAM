package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto_Proveedores")
public class ProductoProveedor {
	
	@Id
    private int idProducto;
    private int idProveedor;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public ProductoProveedor(int idProducto, int idProveedor) {
		super();
		this.idProducto = idProducto;
		this.idProveedor = idProveedor;
	}
	@Override
	public String toString() {
		return "ProductoProveedor [idProducto=" + idProducto + ", idProveedor=" + idProveedor + "]";
	}

    
}
