package fr.cesi.gestioncr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.cesi.gestioncr.entity.Reunion_Collab;
import fr.cesi.gestioncr.entity.Tache_Collab;
import fr.cesi.gestioncr.dao.Tache_CollabDao;

public class JpaTache_CollabDao implements Tache_CollabDao{

	private EntityManagerFactory factory = null;

	EntityManagerFactory emf = null;

	public JpaTache_CollabDao(EntityManagerFactory emf) {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
	}

	@Override
	public Tache_Collab addTache_Collab(Tache_Collab tache_collab) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(tache_collab);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		return tache_collab;
	}

	@Override
	public Tache_Collab findTache_CollabById(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Tache_Collab tache_collab = em.find(Tache_Collab.class, id);
		em.close();
		return tache_collab;
	}

	@Override
	public List<Tache_Collab> getAllTache_Collab() {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Tache_Collab AS p");
		List<Tache_Collab> tache_collab = (List<Tache_Collab>) query.getResultList();
		return tache_collab;
	}

	

	@Override
	public void removeTache_Collab(Tache_Collab tache_collab) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.remove(em.contains(tache_collab)?tache_collab:em.merge(tache_collab));
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}

	@Override
	public void updateTache_Collab(Tache_Collab tache_collab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tache_Collab> getTache_Collab_by_TacheId(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Tache_Collab AS p WHERE id_tache = ?1");
		query.setParameter(1, id);
		List<Tache_Collab> tache_collab = (List<Tache_Collab>) query.getResultList();
		return tache_collab;
	}

	@Override
	public List<Tache_Collab> getAllTache_Collab_by_CollabId(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Tache_Collab AS p WHERE id_collab = ?1");
		query.setParameter(1, id);
		List<Tache_Collab> tache_collab = (List<Tache_Collab>) query.getResultList();
		return tache_collab;
	}

}
