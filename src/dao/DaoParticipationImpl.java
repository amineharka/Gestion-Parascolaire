package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Activite;
import entities.Etudiant;

public class DaoParticipationImpl implements DaoParticipation{
	
	private EntityManagerFactory factory;
	
	public DaoParticipationImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	
	
	@Override
	public void participer(Etudiant etudiant, Activite activite) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			etudiant.addActivites(activite);
			em.merge(etudiant);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	
	
}
