package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entities.Activite;
import entities.Etudiant;

public class DaoActiviteImpl implements DaoActivite{
	
	private EntityManagerFactory factory;
	
	public DaoActiviteImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	
	
	@Override
	public void add(Activite activite) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(activite);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}	
	}
	
	
	
	@Override
	public Activite find(int id) {
		Activite activite = null;
		EntityManager em = factory.createEntityManager();
		try {
			activite = em.find(Activite.class, id );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return activite;
	}

	
	
	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Activite activite = em.find(Activite.class, id );
			em.remove(activite);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	@Override
	public void update(Activite activite) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(activite);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}



	@Override
	public List<Activite> lister() {
		EntityManager em = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Activite> activites = em.createQuery("SELECT a FROM Activite a").getResultList();
		em.close();
		return activites;
	}
	
	
	
	@Override
	public List<Activite> listerToutPublique() {
		EntityManager em = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Activite> activites = em.createQuery("SELECT a FROM Activite a WHERE a.privee=false").getResultList();
		em.close();
		return activites;
	}
	
	
	
	@Override
	public List<Activite> listerTousMesClubs(boolean privee, Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE a.privee=:privee AND a.club IN (SELECT a.club FROM Appartenance AS a WHERE a.etudiant = :etd)");
		query.setParameter("privee", privee);
		query.setParameter("etd", etd);
		@SuppressWarnings("unchecked")
		List<Activite> activites = query.getResultList();
		em.close();
		return activites;
	}



	@Override
	public List<Activite> listerTousAutresClubs(Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE a.privee=false AND a.club IN (SELECT c FROM Club c WHERE c NOT IN (SELECT a.club FROM Appartenance AS a WHERE a.etudiant = :etd))");
		query.setParameter("etd", etd);
		@SuppressWarnings("unchecked")
		List<Activite> activites = query.getResultList();
		em.close();
		return activites;
	}



	@Override
	public List<Activite> listerPublique(String clubName) {
		EntityManager em = factory.createEntityManager();
		Query query = em.createQuery("SELECT a FROM Activite a WHERE a.club.name=:clubName AND a.privee=false");
		query.setParameter("clubName", clubName);
		@SuppressWarnings("unchecked")
		List<Activite> activites = query.getResultList();
		em.close();
		return activites;
	}



	@Override
	public List<Activite> listerPrivee(String clubName, Etudiant etd) {
		EntityManager em = factory.createEntityManager();
		Query quer = em.createQuery("SELECT a.club FROM Appartenance AS a WHERE a.etudiant=:etd AND a.club.name=:clubName");
		quer.setParameter("etd", etd);
		quer.setParameter("clubName", clubName);
		@SuppressWarnings("unchecked")
		List<Activite> club = quer.getResultList();
		
		if (!club.isEmpty()) {
			Query query = em.createQuery("SELECT a FROM Activite a WHERE a.club.name=:clubName AND a.privee=true");
			query.setParameter("clubName", clubName);
			@SuppressWarnings("unchecked")
			List<Activite> activites = query.getResultList();
			em.close();
			return activites;
		}
		em.close();
		return null;
	}


	
	
}
