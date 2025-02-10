package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientesDAO {
	
	SessionFactory sf;

	public ClientesDAO() {
		super();

		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}
	
    public void anadirCliente(Clientes cliente) {
        // Implementación para añadir un cliente a la base de datos
    }

    public void actualizarCliente(Clientes cliente) {
        // Implementación para actualizar un cliente en la base de datos
    }
    
    public Clientes buscarCliente(int id) {
		Clientes c = null;
		try (Session session = sf.openSession()) {

			String hql = "FROM Clientes WHERE id_cliente = :id";

			Query<Clientes> q = session.createQuery(hql, Clientes.class);
			q.setParameter("id", id);

			c = q.uniqueResult();
		} catch (Exception e) {
			System.out.println("Por aqui pasa en la exception");
			e.printStackTrace();
		}

		return c;
    }
}
