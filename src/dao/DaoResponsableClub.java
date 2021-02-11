package dao;

import entities.ResponsableClub;

public interface DaoResponsableClub {

	void add(ResponsableClub responsableClub);
	ResponsableClub find(int id);
	void delete(int id);
	
}
