package dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import entities.Administrateur;
import entities.Etudiant;
import entities.ResponsableClub;
import entities.Utilisateur;

public class DaoUtilisateurImpl implements DaoUtilisateur {

    private EntityManagerFactory factory;

    public DaoUtilisateurImpl(EntityManagerFactory factory) {
    	this.factory = factory;
    }
    
    
    
    @Override
    public void add(Utilisateur utilisateur) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(utilisateur);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

    
    
	@Override
	public Utilisateur find(int id) {
		Utilisateur utilisateur = null;
		EntityManager em = factory.createEntityManager();
		try {
			utilisateur = em.find(Utilisateur.class, id );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return utilisateur;
	}
	
	
	@Override
	public int getIdByEmail(String email) {
		EntityManager em=factory.createEntityManager();
		em.getTransaction();
		Query query=em.createQuery("SELECT u.id FROM Utilisateur u WHERE u.login LIKE :email");
		query.setParameter("email", email);
		int id=(int)query.getSingleResult();
		em.close();
		return id;
	}



	@Override
	public boolean isEtudiant(int id) {
		EntityManager em=factory.createEntityManager();
		em.getTransaction();
		Query query=em.createQuery("SELECT TYPE(u) FROM Utilisateur u WHERE u.id=:id");
		query.setParameter("id", id);
		boolean isEtudiant=query.getSingleResult().equals(Etudiant.class);
		em.close();
		return isEtudiant;
	}
	
	@Override
	public boolean isResponsableClub(int id) {
		EntityManager em=factory.createEntityManager();
		em.getTransaction();
		Query query=em.createQuery("SELECT TYPE(u) FROM Utilisateur u WHERE u.id=:id");
		query.setParameter("id", id);
		boolean isResponsableClub=query.getSingleResult().equals(ResponsableClub.class);
		em.close();
		return isResponsableClub;
	}
	
	@Override
	public boolean isAdministrateur(int id) {
		EntityManager em=factory.createEntityManager();
		em.getTransaction();
		Query query=em.createQuery("SELECT TYPE(u) FROM Utilisateur u WHERE u.id=:id");
		query.setParameter("id", id);
		boolean isAdministrateur=query.getSingleResult().equals(Administrateur.class);
		em.close();
		return isAdministrateur;
	}
	
	@Override
	public String getUserType(int id) throws NoResultException {
		
		EntityManager em=factory.createEntityManager();
		em.getTransaction();
		
		Query query=em.createQuery("SELECT TYPE(u) FROM Utilisateur u WHERE u.id=:id");
		
		query.setParameter("id", id);
		
		Object object=query.getSingleResult();
		
		if (object.equals(Etudiant.class)) 
			return "Etudiant";
		
		else if (object.equals(ResponsableClub.class))	
			return	"ResponsableClub";
		
		else 
			return "Administrateur";
			

		
	}



	@Override
	public void delete(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Utilisateur utilisateur = em.find(Utilisateur.class, id);
			em.remove(utilisateur);
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
	
}
