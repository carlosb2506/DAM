package org.apache.maven.BarrosoCarlos_proyectoHibernate;

public class App {
	public static void main(String[] args) {
		ClientesDAO clienteDao = new ClientesDAO();

		Clientes c = clienteDao.buscarCliente(1);

		if (c != null) {
			System.out.println(c.toString());
		} else {
			System.out.println("Cliente no encontrado :(");
		}

//		clienteDao.aniadirCliente(new Clientes(5, "Carlos Barroso", "C/ REAL", "643223234", "cbarlop2506@gmail.com"));
		
		ProductosDAO productosDao = new ProductosDAO();

		Productos p = productosDao.buscarProducto("Camiseta");

		if (p != null) {
			System.out.println(p.toString());
		} else {
			System.out.println("Producto no encontrado :(");
		}
	}
}
