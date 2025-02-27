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
	
	public Clientes buscarClienteNombre(String nombre) {
		Clientes c = null;
		try (Session session = sf.openSession()) {

			String hql = "FROM Clientes WHERE nombre = :id";

			Query<Clientes> q = session.createQuery(hql, Clientes.class);
			q.setParameter("id", nombre);

			c = q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}
	
	public void actualizarCliente(Clientes cliente) {
	    Transaction transaction = null;
	    try (Session session = sf.openSession()) {
	        transaction = session.beginTransaction();
	        session.merge(cliente);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        System.out.println("Error al actualizar el cliente");
	        e.printStackTrace();
	    }
	}


}
