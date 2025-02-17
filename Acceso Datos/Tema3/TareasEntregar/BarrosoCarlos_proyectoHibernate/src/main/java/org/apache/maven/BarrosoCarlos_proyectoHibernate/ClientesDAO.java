package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientesDAO {

	SessionFactory sf;

	public ClientesDAO() {
		super();

		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}

	public void aniadirCliente(Clientes cliente) {
		try (Session session = sf.openSession()) {
			
			Transaction transaction = session.beginTransaction();

			session.persist(cliente);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error al añadir cliente");
			e.printStackTrace();
		}
	}


	public Clientes buscarCliente(int id) {
		Clientes c = null;
		try (Session session = sf.openSession()) {

			String hql = "FROM Clientes WHERE id_cliente = :id";

			Query<Clientes> q = session.createQuery(hql, Clientes.class);
			q.setParameter("id", id);

			c = q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}
}
