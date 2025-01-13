package org.apache.maven.paquetito;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        //Consulta
        
        Session s = sf.openSession();
        
        Transaction tr = s.beginTransaction();
        
          String hql =  "FROM Estudiante WHERE nombre = :nombre";
          
          Query<Estudiante> query = s.createQuery(hql, Estudiante.class);
          
          query.setParameter("nombre", "Daniel Ramos");
          
          Estudiante e = query.getSingleResult();
          
        if(e != null) {
        	System.out.println(e);
        	e.setNombre("Daniel Ramos modif");
        	e.setCorreo("tomynabo@pepita.com");
        	
        	s.merge(e);

        	tr.commit();

        }else {
        	System.out.println("mierda pa juan");
        }
        
        sf.close();
    }
}
