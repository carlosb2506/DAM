package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DetallePedidoDAO {
	SessionFactory sf;

	public DetallePedidoDAO() {
		super();

		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}
	
    public void anadirProducto(Detalle_Pedidos detped) {
		try (Session session = sf.openSession()) {
			
			Transaction transaction = session.beginTransaction();

			session.persist(detped);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error al añadir el nuevo detalle del pedido");
			e.printStackTrace();
		}
    }

	public Detalle_Pedidos buscarDetallePedido(String nombre) {
		Detalle_Pedidos det_pedidos = null;
		try (Session session = sf.openSession()) {

			String hql = "FROM Productos WHERE nombre = :nombre";

			Query<Productos> q = session.createQuery(hql, Productos.class);
			q.setParameter("nombre", nombre);

			det_pedidos = q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return det_pedidos;
	}

}
