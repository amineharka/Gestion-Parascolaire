package entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table
public class Activite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private boolean privee;
	private String nom;
	private LocalDate date;
	private String lieu;
	private String description;
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name="id_club")
	private Club club;
	
	@ManyToMany(mappedBy="activites")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Etudiant> etudiants;
	
	
	public Activite() {}
	public Activite(boolean privee, String nom, LocalDate date, String lieu, String description) {
		this.privee = privee;
		this.nom = nom;
		this.date = date;
		this.lieu = lieu;
		this.description = description;
	}


	
	public int getId() {
		return id;
	}
	public boolean isPrivee() {
		return privee;
	}
	public String getNom() {
		return nom;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getLieu() {
		return lieu;
	}
	public String getDescription() {
		return description;
	}
	public Club getClub() {
		return club;
	}


	public void setId(int id) {
		this.id = id;
	}
	public void setPrivee(boolean privee) {
		this.privee = privee;
	}
	public void setNom_activite(String nom) {
		this.nom = nom;
	}
	public void setDate_activite(LocalDate date) {
		this.date = date;
	}
	public void setLieu_activite(String lieu) {
		this.lieu = lieu;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	
	
	
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void addEtudiants(Etudiant etudiant) {
		this.etudiants.add(etudiant);
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	

}
