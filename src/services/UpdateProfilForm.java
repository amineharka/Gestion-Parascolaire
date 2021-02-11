package services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.DaoEtudiant;
import entities.Etudiant;


public class UpdateProfilForm {

	Map<String,String> errors = new HashMap<String,String>();
	String result;
	DaoEtudiant daoEtudiant;
	
	
	public UpdateProfilForm(DaoEtudiant daoEtudiant) {
		this.daoEtudiant = daoEtudiant;
	}
	
	
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public String getResult() {
		return result;
	}

	

	public Etudiant updateProfil(HttpServletRequest request, int id) {
		
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String cne = request.getParameter("cne");
		String filiere = request.getParameter("filiere");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");
		
		Etudiant etd;		
		validateNotEmpty(prenom, "prenom");
		validateNotEmpty(nom, "nom");
		validateNotEmpty(cne, "cne");
		validateNotEmpty(filiere, "filiere");
		validateNotEmpty(pays, "pays");
		validateNotEmpty(ville, "ville");

		
		if(errors.isEmpty()) {
			etd = daoEtudiant.find(id);
			etd.setPrenom(prenom);
			etd.setNom(nom);
			etd.setCne(cne);
			etd.setFiliere(filiere);
			etd.setPays(pays);
			etd.setVille(ville);
			
			daoEtudiant.update(etd);
			etd = daoEtudiant.find(id);
			
		} 
		else {
			etd = null;
			
			result = "Veuiller remplir tous les champs.";
		}
		
		
		return etd;
	}
	
	
	
	//----------------------Méthodes de Validation :----------------------
	//Validation de non-vide :
	private void validateNotEmpty(String str, String errKey) {
		tryEmpty(str, errKey);
	}
	
	
	//----------------------Méthodes de Try and Catch :----------------------
	//Try and Catching de non-vide :
	private void tryEmpty(String str, String errKey) {
		try {
			checkEmpty(str);
		} catch(UpdateProfilFormException e) {
			errors.put(errKey, e.getMessage());
		}
	}
	
	
	//----------------------Méthodes de Checking :----------------------
	//Checking de non-vide:
	private void checkEmpty(String str) throws UpdateProfilFormException{
		if(str.isEmpty())
			throw new UpdateProfilFormException("Ce champ ne doit pas être vide.");
	}
}
