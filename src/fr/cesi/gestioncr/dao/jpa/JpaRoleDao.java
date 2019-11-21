package fr.cesi.gestioncr.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.cesi.gestioncr.entity.Role;
import fr.cesi.gestioncr.dao.RoleDao;

public class JpaRoleDao implements RoleDao{

	private EntityManagerFactory factory = null;

	EntityManagerFactory emf = null;

	public JpaRoleDao(EntityManagerFactory emf) {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
	}

	@Override
	public Role addRole(Role role) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(role);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}
		return role;
	}

	@Override
	public Role findRoleById(Long id) {
		EntityManager em = this.emf.createEntityManager();
		Role role = em.find(Role.class, id);
		em.close();
		return role;
	}

	@Override
	public List<Role> getAllRole() {
		EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery("SELECT p FROM Projet AS p");
		List<Role> role = (List<Role>) query.getResultList();
		return role;
	}

	@Override
	public void updateRole(Role role) {
		EntityManager em = this.emf.createEntityManager();
		Long id = role.getId();
		Role rol = em.find(Role.class, id);
		rol = em.merge(role);
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(rol);
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}

	@Override
	public void removeRole(Role role) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.remove(em.contains(role)?role:em.merge(role));
			t.commit();
		} finally {
			if (t.isActive()) t.rollback();
			em.close();
		}

	}

}
