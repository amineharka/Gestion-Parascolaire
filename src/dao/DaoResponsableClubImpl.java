package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.ResponsableClub;

public class DaoResponsableClubImpl implements DaoResponsableClub{

	private EntityManagerFactory factory;

	public DaoResponsableClubImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	
	
	@Override
	public void add(ResponsableClub responsableClub) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(responsableClub);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	
	
	@Override
	public ResponsableClub find(int id) {
		ResponsableClub responsableClub = null;
		EntityManager em = factory.createEntityManager();
		try {
			responsableClub = em.find(ResponsableClub.class, id );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return responsableClub;
	}

	
	
	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ResponsableClub responsableClub = em.find(ResponsableClub.class, id);
			em.remove(responsableClub);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
}
