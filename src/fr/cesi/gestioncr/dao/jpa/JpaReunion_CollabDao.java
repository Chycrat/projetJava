package fr.cesi.gestioncr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.cesi.gestioncr.entity.Reunion_Collab;
import fr.cesi.gestioncr.dao.Reunion_CollabDao;

public class JpaReunion_CollabDao implements Reunion_CollabDao{

	private EntityManagerFactory factory = null;

	EntityManagerFactory emf = null;

	public JpaReunion_CollabDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Reunion_Collab addReunion_Collab(Reunion_Collab reunion_collab) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(reunion_collab);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		return reunion_collab;
	}

	@Override
	public Reunion_Collab findReunion_CollabById(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Reunion_Collab reunion_collab = em.find(Reunion_Collab.class, id);
		em.close();
		return reunion_collab;
	}

	@Override
	public List<Reunion_Collab> getAllReunion_Collab() {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM reunion_collab AS p");
		List<Reunion_Collab> reunion_collab = (List<Reunion_Collab>) query.getResultList();
		return reunion_collab;
	}

	@Override
	public void removeReunion_Collab(Reunion_Collab reunion_collab) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.remove(em.contains(reunion_collab)?reunion_collab:em.merge(reunion_collab));
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}
	
}
