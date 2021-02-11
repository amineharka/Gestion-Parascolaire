package services;

import javax.servlet.http.Part;

public interface FilesManager {
	
	String getNomFichier(Part part); 
	String ecrireFichier(Part part,String chemin);
	void delete(String chemin,String imageName);
}
