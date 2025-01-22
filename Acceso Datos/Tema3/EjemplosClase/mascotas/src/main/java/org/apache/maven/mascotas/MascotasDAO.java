package org.apache.maven.mascotas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MascotasDAO {

	SessionFactory sf;

	public MascotasDAO() {
		super();

		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	}

	// Consultar registro por su clave
	public Cliente getClienteByDni(String dni) {
		Cliente c = null;
		try (Session session = sf.openSession()) {
			c = session.get(Cliente.class, dni);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	// Consultar registro único por campo distinto a clave
	public Mascota getMascotaByNombre(String nom) {
		Mascota m = null;
		try (Session session = sf.openSession()) {
			// Construimos sentencia HQL
			String hql = "FROM Mascota WHERE nombre = :nombre";
			Query<Mascota> q = session.createQuery(hql, Mascota.class);
			q.setParameter("nombre", nom);

			// Devolverá el primer resultado coincidente
			m = q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	// Consultar registros múltiples
	public ArrayList<Mascota> buscarMascotas(String busqueda) {
		ArrayList<Mascota> lista = null;
		try (Session session = sf.openSession()) {
			// Construimos sentencia HQL
			String hql = "FROM Mascota WHERE nombre LIKE :patron";
			Query<Mascota> q = session.createQuery(hql, Mascota.class);
			q.setParameter("patron", busqueda);
			// Devolverá todos los resultados coincidentes
			// Convierto a ArrayList, ya que Hibernate trabaja con List
			lista = (ArrayList<Mascota>) q.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	// Guardar nuevo cliente en la base de datos
	public void newCliente(Cliente c) {
		try (Session session = sf.openSession()) {
			Transaction tr = session.beginTransaction();

			session.persist(c);
			tr.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Guardar nuevo cliente en la base de datos
	public void modifyCliente(Cliente c) {
		try (Session session = sf.openSession()) {
			Cliente registro = session.get(Cliente.class, c.getDni());
			// Se ha verificado previamente que existe en la BD
			if (registro != null) {
				Transaction tr = session.beginTransaction();
				
				session.merge(c);
				tr.commit();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Consultar mascota por su clave
	
	public Mascota buscarMascotasporChip(String chip) {
		Mascota m = null;
		try (Session session = sf.openSession()) {
			// Construimos sentencia HQL
			String hql = "FROM Mascota WHERE chip = :patron";
			Query<Mascota> q = session.createQuery(hql, Mascota.class);
			q.setParameter("patron", chip);
			// Devolverá todos los resultados coincidentes
			m = q.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	//consultar Clientes por su apellido
	
	public ArrayList<Cliente> buscarCliente(String apellido) {
		ArrayList<Cliente> lista = null;
		try (Session session = sf.openSession()) {
			// Construimos sentencia HQL
			String hql = "FROM Cliente WHERE apellidos = :patron";
			Query<Cliente> q = session.createQuery(hql, Cliente.class);
			q.setParameter("patron", apellido);
			// Devolverá todos los resultados coincidentes
			// Convierto a ArrayList, ya que Hibernate trabaja con List
			lista = (ArrayList<Cliente>) q.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	//nueva mascota
	
	//Modificar mascota existente
	
	//Borrar especie
	
	
	// Eliminar cliente en la base de datos
	public void deleteCliente(Cliente c) {
		// session.remove(p);
	}

	public List<Mascota> getMascotasByCliente(Cliente c) {
		return null;
	}

	public Especie getEspecieByMascota(Mascota m) {

		return null;
	}

	public ArrayList<Vacuna> getVacunasByMascota(Mascota m) {
		/* select Vacuna.vacuna from Vacuna
		join Mascota_Vacuna on Mascota_Vacuna.vacuna = Vacuna.vacuna
		where Mascota_Vacuna.chip = 'C00001A' */
		ArrayList<Vacuna> lista = null;
		try (Session session = sf.openSession()) {
			// Construimos sentencia HQL
			String hql = "FROM Vacuna JOIN Mascota_Vacuna"
					+ " ON Mascota_Vacuna.vacuna = Vacuna.vacuna "
					+ "	WHERE Mascota_Vacuna.chip = :chip ";
			Query<Vacuna> q = session.createQuery(hql, Vacuna.class);
			q.setParameter("chip", m.getChip());
			// Devolverá todos los resultados coincidentes
			// Convierto a ArrayList, ya que Hibernate trabaja con List
			lista = (ArrayList<Vacuna>) q.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
