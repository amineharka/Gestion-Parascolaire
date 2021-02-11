package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.AppartenanceKey;
import entities.DemandeInscription;

public class DaoDemandeInscriptionImpl implements DaoDemandeInscription{

	private EntityManagerFactory factory;
	
	public DaoDemandeInscriptionImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public void add(DemandeInscription demande) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(demande);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	
	
	@Override
	public DemandeInscription find(AppartenanceKey key) {
		DemandeInscription demande = null;
		EntityManager em = factory.createEntityManager();
		try {
			demande = em.find(DemandeInscription.class, key);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return demande;
	}

	
	
}
