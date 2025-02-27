package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ProductosDAO {
	
	SessionFactory sf;

	public ProductosDAO() {
		super();

		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}
	
    public void anadirProducto(Productos producto) {
		try (Session session = sf.openSession()) {
			
			Transaction transaction = session.beginTransaction();

			session.persist(producto);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error al añadir el nuevo producto");
			e.printStackTrace();
		}
    }

	public Productos buscarProducto(String nombre) {
		Productos p = null;
		try (Session session = sf.openSession()) {

			String hql = "FROM Productos WHERE nombre = :nombre";

			Query<Productos> q = session.createQuery(hql, Productos.class);
			q.setParameter("nombre", nombre);

			p = q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public void actualizarProducto(Productos producto) {
	    Transaction transaction = null;
	    try (Session session = sf.openSession()) {
	        transaction = session.beginTransaction();
	        session.merge(producto);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        System.out.println("Error al actualizar el producto");
	        e.printStackTrace();
	    }
	}

}