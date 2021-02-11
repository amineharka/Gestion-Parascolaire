package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Etudiant;

public class DaoEtudiantImpl implements DaoEtudiant{
	
	private EntityManagerFactory factory;
	
	public DaoEtudiantImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public void add(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(etd);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
	@Override
	public Etudiant find(int id) {
		Etudiant etd = null;
		EntityManager em = factory.createEntityManager();
		try {
			etd = em.find(Etudiant.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return etd;
	}
	
	
	
	@Override
	public void update(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(etd);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
	}



	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Etudiant etudiant = em.find(Etudiant.class, id);
			em.remove(etudiant);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	

}
