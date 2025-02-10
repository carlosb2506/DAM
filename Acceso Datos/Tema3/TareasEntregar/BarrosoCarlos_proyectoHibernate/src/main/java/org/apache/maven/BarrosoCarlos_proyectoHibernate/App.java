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
    }
}
