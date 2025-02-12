package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ProveedoresDAO {
	SessionFactory sf;

	public ProveedoresDAO() {
		super();

		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}
	
    public void anadirProveedor(Proveedores proveedor) {
		try (Session session = sf.openSession()) {
			
			Transaction transaction = session.beginTransaction();

			session.persist(proveedor);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error al añadir el nuevo proveedor");
			e.printStackTrace();
		}
    }

	public Proveedores buscarProveedor(String nombre) {
		Proveedores pr = null;
		try (Session session = sf.openSession()) {

			String hql = "FROM Proveedores WHERE nombre = :nombre";

			Query<Proveedores> q = session.createQuery(hql, Proveedores.class);
			q.setParameter("nombre", nombre);

			pr = q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pr;
	}
}