package dao;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import entities.Club;

public class DaoClubImpl implements DaoClub{
	
	private EntityManagerFactory factory;
	
	public DaoClubImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	
	@Override
	public void add(Club club) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(club);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
	@Override
	public Club find(int id) {
		Club club = null;
		EntityManager em = factory.createEntityManager();
		try {
			club = em.find(Club.class,id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return club;
	}
	
	
	
	@Override
	public void update(Club club) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(club);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
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
			tx.begin();
			Club club = em.find(Club.class,id);
			em.remove(club);
			tx.commit();
		} catch( Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}	
	}

    @Override
    @SuppressWarnings("unchecked")
	public List<Club> lister() {

		EntityManager em = factory.createEntityManager();
		em.getTransaction();
		List<Club> clubs =  (List<Club>) em.createQuery( "SELECT u FROM Club u ").getResultList();
	     em.close();
	     return clubs;
    	
	}
}
