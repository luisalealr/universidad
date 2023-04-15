package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Conexion<T> {

	private Class<T> c;
	private static EntityManager em = null;

	public static EntityManager getEm() {
		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("universidadweb2");
			em = emf.createEntityManager();
		}
		return em;
	}

	@SuppressWarnings("static-access")
	public Conexion() {
		em = this.getEm();
	}

	@SuppressWarnings("static-access")
	public Conexion(Class<T> c) {
		em = this.getEm();
		this.c = c;
	}

	public void setConexion(Class<T> c) {
		this.c = c;
	}

	public <E> T find(E id) {
		T object = (T) em.find(c, id);
		return object;
	}

	public List<T> list() {
		TypedQuery<T> consulta = em.createNamedQuery(c.getSimpleName() + ".findAll", c);
		List<T> lista = (List<T>) consulta.getResultList();
		return lista;
	}

	public void insert(T o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}

	public void update(T o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}

	public void delete(T o) {
		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}
}
