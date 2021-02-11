package dao;

import entities.Etudiant;

public interface DaoEtudiant {
	
	void add(Etudiant etd);
	Etudiant find(int id);
	void update(Etudiant etd);
	void delete(int id);
	
}
