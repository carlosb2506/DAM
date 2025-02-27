package org.apache.maven.BarrosoCarlos_proyectoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ProductoProveedorDAO {
    SessionFactory sf;

    public ProductoProveedorDAO() {
        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void anadirRelacion(ProductoProveedor relacion) {
        try (Session session = sf.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(relacion);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al añadir la relación producto-proveedor");
            e.printStackTrace();
        }
    }

    public ProductoProveedor buscarRelacion(int idProducto, int idProveedor) {
        try (Session session = sf.openSession()) {
            String hql = "FROM ProductosProveedores WHERE id_producto = :idProducto AND id_proveedor = :idProveedor";
            Query<ProductoProveedor> q = session.createQuery(hql, ProductoProveedor.class);
            q.setParameter("idProducto", idProducto);
            q.setParameter("idProveedor", idProveedor);
            return q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
