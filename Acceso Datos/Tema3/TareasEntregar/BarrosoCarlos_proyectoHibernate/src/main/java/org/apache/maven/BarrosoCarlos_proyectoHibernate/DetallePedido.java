package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Detalle_Pedidos")
public class DetallePedido {
	
	@Id
    private int idDetalle;
    private int idPedido;
    private int idProducto;
    private int cantidad;
    private float precioUnitario;
	public int getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public DetallePedido(int idDetalle, int idPedido, int idProducto, int cantidad, float precioUnitario) {
		super();
		this.idDetalle = idDetalle;
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}
	@Override
	public String toString() {
		return "DetallePedido [idDetalle=" + idDetalle + ", idPedido=" + idPedido + ", idProducto=" + idProducto
				+ ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + "]";
	}

    
}
