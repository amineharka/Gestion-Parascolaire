package entities;


import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@DiscriminatorValue("etd")
public class Etudiant extends Utilisateur{

	private String nom;
	private String prenom;
	private String filiere;
	private String cne;
	private String pays;
	private String ville;
	private String adresse;
	
	@OneToMany(mappedBy="etudiant")
	List<Appartenance> appartenances;
	
	@OneToMany(mappedBy="etudiant")
	List<DemandeInscription> demandesInscription;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable (name="participation", joinColumns=@JoinColumn(name="id_etudiant"), inverseJoinColumns=@JoinColumn(name="id_activite") )
	List<Activite> activites;
	
	
	
	public Etudiant () {}
	public Etudiant(String login, String pwd) {
		this.login = login;
		this.password = pwd;
	}
	
	
	
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getFiliere() {
		return filiere;
	}
	public String getCne() {
		return cne;
	}
	public String getPays() {
		return pays;
	}
	public String getVille() {
		return ville;
	}
	public String getAdresse() {
		return adresse;
	}
	
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	public List<Appartenance> getAppartenances() {
		return appartenances;
	}
	public void addAppartenances(Appartenance appartenance) {
		this.appartenances.add(appartenance);
	}
	
	public List<Activite> getActivites() {
		return activites;
	}
	public void addActivites(Activite activite) {
		this.activites.add(activite);
	}
	
	public List<DemandeInscription> getDemandesInscription() {
		return demandesInscription;
	}
	public void addDemandeInscription(DemandeInscription demandeInscription) {
		this.demandesInscription.add(demandeInscription);
	}
}
