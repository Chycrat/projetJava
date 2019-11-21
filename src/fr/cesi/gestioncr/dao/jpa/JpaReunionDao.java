package fr.cesi.gestioncr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.cesi.gestioncr.entity.Reunion;
import fr.cesi.gestioncr.dao.ReunionDao;

public class JpaReunionDao implements ReunionDao{

	private EntityManagerFactory factory = null;

	EntityManagerFactory emf = null;

	public JpaReunionDao(EntityManagerFactory emf) {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
	}

	@Override
	public Reunion addReunion(Reunion reunion) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(reunion);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		return reunion;
	}

	@Override
	public Reunion findReunionById(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Reunion reunion = em.find(Reunion.class, id);
		em.close();
		return reunion;
	}

	@Override
	public List<Reunion> getAllReunion() {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Projet AS p");
		List<Reunion> reunion = (List<Reunion>) query.getResultList();
		return reunion;
	}

	@Override
	public void updateReunion(Reunion reunion) {
		EntityManager em = this.emf.createEntityManager();
		Long id = reunion.getId_reunion();
		Reunion reu = em.find(Reunion.class, id);
		reu = em.merge(reunion);
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(reu);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}

	@Override
	public void removeReunion(Reunion reunion) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.remove(em.contains(reunion)?reunion:em.merge(reunion));
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}


}
