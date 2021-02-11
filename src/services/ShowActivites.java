package services;

import java.util.List;

import dao.DaoActivite;
import entities.Activite;
import entities.Etudiant;

public class ShowActivites {

	DaoActivite daoActivite;
	Etudiant etd;
	private String result = null;
	
	public ShowActivites(DaoActivite daoActivite, Etudiant etd) {
		this.daoActivite = daoActivite;
		this.etd = etd;
	}
	
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}



	public List<Activite> listActivites(String clubName, boolean privee) {
		
		List<Activite> activites;
		if(clubName == null || clubName.isEmpty() || clubName.equals("tout")) {
			activites = daoActivite.listerToutPublique();
			if(activites.isEmpty())
				setResult("Pas d'activités à montrer.");
		}
		else if(clubName.equals("tousMesClubs")) {
			activites = daoActivite.listerTousMesClubs(privee, etd);
			if(activites.isEmpty())
				setResult("Vos clubs n'ont pas d'activités publiques à venir.");
		}
		else if(clubName.equals("tousAutresClubs")) {
			activites = daoActivite.listerTousAutresClubs(etd);
			if(activites.isEmpty())
				setResult("Pas d'activités à montrer.");
		}
		else if(!clubName.isEmpty()) {
			if (!privee) {
				activites = daoActivite.listerPublique(clubName);
				if(activites.isEmpty())
					setResult("Le club "+clubName+" n'a pas d'activités publiques à venir.");
			}
			else {
				activites = daoActivite.listerPrivee(clubName, etd);
				if(activites == null)
					setResult("Vous n'avez pas accès aux activités privées du club "+clubName+".");
				else if(activites.isEmpty())
					setResult("Le club "+clubName+" n'a pas d'activités privées à venir.");
			}
		}
		else {
			activites = null;
			setResult("How did you do this?");
		}
		
		
		
		return activites;
	}
}
