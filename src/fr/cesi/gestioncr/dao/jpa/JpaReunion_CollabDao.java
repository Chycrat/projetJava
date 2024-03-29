package fr.cesi.gestioncr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.cesi.gestioncr.dao.Reunion_CollabDao;
import fr.cesi.gestioncr.entity.Collab;
import fr.cesi.gestioncr.entity.Reunion_Collab;

public class JpaReunion_CollabDao implements Reunion_CollabDao{

	private EntityManagerFactory factory = null;

	EntityManagerFactory emf = null;

	public JpaReunion_CollabDao(EntityManagerFactory emf) {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
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
		Query query = em.createQuery("SELECT p FROM Reunion_Collab AS p");
		List<Reunion_Collab> reunion_collab = (List<Reunion_Collab>) query.getResultList();
		return reunion_collab;
	}
	
	@Override
	public List<Collab> getCollabFromReunion(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p.collab FROM Reunion_Collab AS p WHERE id_reunion = ?1");
		query.setParameter(1, id);
		List<Collab> tache_reu = (List<Collab>) query.getResultList();
		List<Collab> tache_collab = null;
		for (Collab long1 : tache_reu) {
			Query query2 = em.createQuery("SELECT co.nom FROM Collab AS co WHERE id_collab = ?1");
			query2.setParameter(1, long1.getId_collab());
			List<Collab> listCollab = (List<Collab>)query2.getResultList();
			tache_collab.add(listCollab.get(0));
		}
		return tache_collab;
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

	@Override
	public void updateReunion_Collab(Reunion_Collab reunion_collab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reunion_Collab> getReunion_Collab_by_ReunionId(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Reunion_Collab AS p WHERE id_reunion = ?1");
		query.setParameter(1, id);
		List<Reunion_Collab> reunion_collab = (List<Reunion_Collab>) query.getResultList();
		return reunion_collab;
	}

	@Override
	public List<Reunion_Collab> getAllReunion_Collab_by_CollabId(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Reunion_Collab AS p WHERE id_collab = ?1"); 
		query.setParameter(1, id);
		List<Reunion_Collab> reunion_collab = (List<Reunion_Collab>) query.getResultList();
		return reunion_collab;
	}

	@Override
	public List<Reunion_Collab> getCollabFromReunion() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
