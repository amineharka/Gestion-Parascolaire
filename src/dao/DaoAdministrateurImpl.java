package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Administrateur;
import entities.Etudiant;

public class DaoAdministrateurImpl implements DaoAdministrateur{
	
	private EntityManagerFactory factory;
	
	public DaoAdministrateurImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public Administrateur find(int id) {
		Administrateur admin = null;
		EntityManager em = factory.createEntityManager();
		try {
			admin = em.find(Administrateur.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return admin;
	}
	
	@Override
	public void add(Administrateur administrateur) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(administrateur);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
}
