package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Detalle_Pedidos")
public class Detalle_Pedidos {
	
	@Id
    private int id_detalle;
    private int id_pedido;
    private int id_producto;
    private int cantidad;
    private float precio_unitario;
	public int getIdDetalle() {
		return id_detalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.id_detalle = idDetalle;
	}
	public int getIdPedido() {
		return id_pedido;
	}
	public void setIdPedido(int idPedido) {
		this.id_pedido = idPedido;
	}
	public int getIdProducto() {
		return id_producto;
	}
	public void setIdProducto(int idProducto) {
		this.id_producto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecioUnitario() {
		return precio_unitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precio_unitario = precioUnitario;
	}
	public Detalle_Pedidos(int idDetalle, int idPedido, int idProducto, int cantidad, float precioUnitario) {
		super();
		this.id_detalle = idDetalle;
		this.id_pedido = idPedido;
		this.id_producto = idProducto;
		this.cantidad = cantidad;
		this.precio_unitario = precioUnitario;
	}
	@Override
	public String toString() {
		return "idDetalle: " + id_detalle + ", idPedido: " + id_pedido + ", idProducto:" + id_producto
				+ ", cantidad: " + cantidad + ", precioUnitario: " + precio_unitario;
	}

    
}
