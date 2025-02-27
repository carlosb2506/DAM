package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PedidoDAO {
    SessionFactory sf;

    public PedidoDAO() {
    	sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void anadirPedido(Pedidos pedido) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(pedido);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al añadir el pedido");
            e.printStackTrace();
        }
    }

    
    public Pedidos buscarPedido(int pedidoId) {
        Pedidos ped = null;
        try (Session session = sf.openSession()) {

            String hql = "FROM Pedidos p JOIN p.cliente c WHERE p.id_pedido = :id";
            Query<Pedidos> q = session.createQuery(hql, Pedidos.class);
            q.setParameter("id", pedidoId);

            ped = q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ped;
    }

}
