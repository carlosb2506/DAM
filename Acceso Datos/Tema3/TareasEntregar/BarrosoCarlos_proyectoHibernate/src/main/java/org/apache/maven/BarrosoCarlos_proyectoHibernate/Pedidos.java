package org.apache.maven.BarrosoCarlos_proyectoHibernate;


import jakarta.persistence.*;


@Entity
@Table(name = "Pedidos")
public class Pedidos {
    
    @Id
    @Column(name = "id_pedido")
    private int id_pedido;

    @Column(name = "fecha_pedido")
    private String fecha_pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;
    

    @Column(name = "total")
    private float total;
    
    public Pedidos() {
        super();
    }
    public int getIdPedido() {
        return id_pedido;
    }
    public void setIdPedido(int idPedido) {
        this.id_pedido = idPedido;
    }
    public String getFechaPedido() {
        return fecha_pedido;
    }
    public void setFechaPedido(String fechaPedido) {
        this.fecha_pedido = fechaPedido;
    }
    public Clientes getCliente() {
        return cliente;
    }
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
//    public Pedidos(int idPedido, String fechaPedido, int idCliente, float total) {
//        super();
//        this.id_pedido = idPedido;
//        this.fecha_pedido = fechaPedido;
//        this.total = total;
//     
//    }
    public Pedidos(int idPedido, String fechaPedido, Clientes cliente, float total) {
        super();
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        this.id_pedido = idPedido;
        this.fecha_pedido = fechaPedido;
        this.cliente = cliente;  // Asignamos el objeto cliente
        this.total = total;
    }

    @Override
    public String toString() {
        return "NOMBRE DEL CLIENTE: " + cliente.getNombre() + ", TOTAL: " + total + ", FECHA DEL PEDIDO: " + fecha_pedido;
    }
}

