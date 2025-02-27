package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DetallePedidoDAO {
    SessionFactory sf;

    public DetallePedidoDAO() {
        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void anadirDetallePedido(Detalle_Pedidos detalle) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(detalle);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al añadir el detalle del pedido");
            e.printStackTrace();
        }
    }

    public Detalle_Pedidos buscarDetallePedido(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Detalle_Pedidos.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}