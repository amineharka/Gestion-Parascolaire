package dao;

import entities.Activite;
import entities.Etudiant;

public interface DaoParticipation {

	void participer(Etudiant etudiant, Activite activite);
	
}
