package fr.cesi.gestioncr.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.cesi.gestioncr.dao.CollabDao;
import fr.cesi.gestioncr.entity.Collab;

public class JpaCollabDao implements CollabDao {

	private EntityManagerFactory factory = null;

	EntityManagerFactory emf = null;

	public JpaCollabDao(EntityManagerFactory emf) {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
	}
	
	@Override
	public boolean Collab_existe(String name, String password)
	{
		EntityManager em = factory.createEntityManager();
	
		Query query = em.createQuery("SELECT count(id) FROM employee where nom = ?1 and pass = ?2");
		
		query.setParameter(1, name);
		query.setParameter(2, password);
		
		long existe = (long) query.getSingleResult();
		
		em.close();
		if(existe == 1) return(true);
	
		return(false);
		
	}
	
	@Override
	public Collab addCollab(Collab collab) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(collab);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		return collab;
	}

	@Override
	public Collab findCollabById(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Collab collab = em.find(Collab.class, id);
		em.close();
		return collab;
	}

	@Override
	public Collection<Collab> getAllCollab() {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Collab AS c");
		Collection<Collab> collab = (Collection<Collab>) query.getResultList();
		return collab;
	}

	@Override
	public void updateCollab(Collab collab) {
		EntityManager em = this.emf.createEntityManager();
		Long id = collab.getId();
		Collab clb = em.find(Collab.class, id);
		clb = em.merge(collab);
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(clb);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}

	@Override
	public void removeCollab(Collab collab) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.remove(em.contains(collab)?collab:em.merge(collab));
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}


}
