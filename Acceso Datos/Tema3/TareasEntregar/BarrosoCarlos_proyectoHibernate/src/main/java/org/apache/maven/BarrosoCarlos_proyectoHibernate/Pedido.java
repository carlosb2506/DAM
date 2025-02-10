package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedidos")
public class Pedido {
	
	@Id
    private int idPedido;
    private Date fechaPedido;
    private int idCliente;
    private float total;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	} 
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Pedido(int idPedido, Date fechaPedido, int idCliente, float total) {
		super();
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.idCliente = idCliente;
		this.total = total;
	}
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", total=" + total + "]";
	}

    
}
