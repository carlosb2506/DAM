package org.apache.maven.paquetito;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        
        Estudiante e = s.get(Estudiante.class, 13);
        
        if(e != null) {
        	System.out.println(e);
        }else {
        	System.out.println("mierda pa juan");
        }
        
        sf.close();
    }
}
