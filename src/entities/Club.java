package entities;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "club")
public class Club {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_club")
	private int id;
	
	private String name;
	@Column(columnDefinition="TEXT")
	private String description;
	@Column(columnDefinition="TEXT")
	private String paragraphe;
	private String logoPath;
	private String img1Path;
	private String img2Path;
	private String img3Path;
	
	@OneToOne
	@JoinColumn(name = "id_responsable_club", referencedColumnName = "id_utilisateur")
	private ResponsableClub responsableClub;
	
	@OneToMany(mappedBy="club")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Activite> activites;
	
	@OneToMany(mappedBy="club")
	List<Appartenance> appartenances;
	
	@OneToMany(mappedBy="club")
	List<DemandeInscription> demandesInscription;
	


	public Club() {}
	public Club(String name , String description , String paragraphe)
	{
		this.name=name;
		this.description=description;
		this.paragraphe=paragraphe;
	}


	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getParagraphe() {
		return paragraphe;
	}
	public ResponsableClub getResponsableClub() {
		return responsableClub;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setParagraphe(String paragraphe) {
		this.paragraphe = paragraphe;
	}
	public void setResponsableClub(ResponsableClub responsableClub) {
		this.responsableClub = responsableClub;
	}
	

	
	
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getImg1Path() {
		return img1Path;
	}
	public void setImg1Path(String img1Path) {
		this.img1Path = img1Path;
	}
	public String getImg2Path() {
		return img2Path;
	}
	public void setImg2Path(String img2Path) {
		this.img2Path = img2Path;
	}
	public String getImg3Path() {
		return img3Path;
	}
	public void setImg3Path(String img3Path) {
		this.img3Path = img3Path;
	}
	public List<Activite> getActivites() {
		return activites;
	}
	public void addActivites(Activite activite) {
		this.activites.add(activite);
	}
	
	public List<Appartenance> getAppartenances() {
		return appartenances;
	}
	public void addAppartenance(Appartenance appartenance) {
		this.appartenances.add(appartenance);
	}
	
	public List<DemandeInscription> getDemandesInscription() {
		return demandesInscription;
	}
	public void addDemandeInscription(DemandeInscription demandeInscription) {
		this.demandesInscription.add(demandeInscription);
	}

}
