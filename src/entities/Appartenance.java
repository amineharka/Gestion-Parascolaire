package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name="appartenance")
public class Appartenance {

	@EmbeddedId
	AppartenanceKey id = new AppartenanceKey();
	
	@ManyToOne
	@MapsId("idEtudiant")
	@JoinColumn(name="id_etudiant")
	Etudiant etudiant;
	
	@ManyToOne
	@MapsId("idClub")
	@JoinColumn(name="id_club")
	Club club;
	
	@Column(name="date_appartenance")
	Date dateAppartenance;


	
	public Appartenance() {}
	public Appartenance(Etudiant etd, Club club) {
		this.etudiant = etd;
		this.club = club;
	}
	
	
	
	public AppartenanceKey getId() {
		return id;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public Club getClub() {
		return club;
	}
	public Date getDateAppartenance() {
		return dateAppartenance;
	}


	
	public void setId(AppartenanceKey id) {
		this.id = id;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	public void setDateAppartenance(Date dateAppartenance) {
		this.dateAppartenance = dateAppartenance;
	}

	
	
}
