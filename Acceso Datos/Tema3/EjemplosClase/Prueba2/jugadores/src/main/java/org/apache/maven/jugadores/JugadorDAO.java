package org.apache.maven.jugadores;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JugadorDAO {

	private SessionFactory sf;

	public JugadorDAO() {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void insertJugador(Jugador j) {

		Session session = sf.openSession();

		Transaction tr = null;

		try {

			tr = session.beginTransaction();

			session.persist(j);

			tr.commit();

		} catch (Exception e) {

			e.printStackTrace();

			if (tr == null) {
				tr.rollback();
			}
		} finally {
			session.close();
		}

	}

	public Equipo getEquipo(Jugador j) {
		
		return null;
	}

	public void assignJugador(Jugador jug, Equipo equi) {

	}

}
