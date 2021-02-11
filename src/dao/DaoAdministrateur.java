package dao;

import entities.Administrateur;

public interface DaoAdministrateur {
	
	Administrateur find(int id);
	void add(Administrateur administrateur);

}
