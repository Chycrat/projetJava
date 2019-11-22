package fr.cesi.gestioncr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.cesi.gestioncr.dao.TacheDao;
import fr.cesi.gestioncr.entity.Tache;

public class JpaTacheDao implements TacheDao{

	private EntityManagerFactory factory = null;

	EntityManagerFactory emf = null;

	public JpaTacheDao(EntityManagerFactory emf) {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
	}

	@Override
	public Tache addTache(Tache tache) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(tache);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		return tache;
	}

	@Override
	public Tache findTacheById(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Tache tache = em.find(Tache.class, id);
		em.close();
		return tache;
	}

	@Override
	public List<Tache> getAllTache() {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM tache AS p");
		List<Tache> tache = (List<Tache>) query.getResultList();
		return tache;
	}
	
	@Override
	public List<Tache> getTacheFromReunion(Long id_reunion) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Tache AS p WHERE reunion = ?1");
		query.setParameter(1,id_reunion);
		List<Tache> tache = (List<Tache>) query.getResultList();
		return tache;
	}

	@Override
	public void updateTache(Tache tache) {
		EntityManager em = this.emf.createEntityManager();
		Long id = tache.getId_tache();
		Tache tach = em.find(Tache.class, id);
		tach = em.merge(tache);
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(tach);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}

	@Override
	public void removeTache(Tache tache) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.remove(em.contains(tache)?tache:em.merge(tache));
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}
	
}
