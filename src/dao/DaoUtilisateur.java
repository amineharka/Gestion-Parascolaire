package dao;

import entities.Utilisateur;

public interface DaoUtilisateur {
	
	void add(Utilisateur utilisateur);
	Utilisateur find(int id);
	int getIdByEmail(String email);
	String getUserType(int id);
	void delete(int id);
	boolean isAdministrateur(int id);
	boolean isResponsableClub(int id);
	boolean isEtudiant(int id);

}
