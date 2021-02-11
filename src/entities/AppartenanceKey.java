package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@SuppressWarnings("serial")
@Embeddable
public class AppartenanceKey implements Serializable{

	@Column(name="id_etudiant")
	int idEtudiant;
	
	@Column(name="id_club")
	int idClub;
	
	
	
	public AppartenanceKey() {}
	public AppartenanceKey(int idEtd, int idClub) {
		this.idEtudiant = idEtd;
		this.idClub = idClub;
	}

	
	
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public int getIdClub() {
		return idClub;
	}

	
	
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idClub;
		result = prime * result + idEtudiant;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppartenanceKey other = (AppartenanceKey) obj;
		if (idClub != other.idClub)
			return false;
		if (idEtudiant != other.idEtudiant)
			return false;
		return true;
	}

	
	
}
