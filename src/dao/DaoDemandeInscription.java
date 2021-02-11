package dao;

import entities.AppartenanceKey;
import entities.DemandeInscription;

public interface DaoDemandeInscription {

	void add(DemandeInscription demande);
	DemandeInscription find(AppartenanceKey key);
	
}
