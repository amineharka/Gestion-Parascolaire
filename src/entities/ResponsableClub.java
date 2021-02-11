package entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("resp")
public class ResponsableClub extends Utilisateur{

	@OneToOne(mappedBy = "responsableClub")
	Club club;
	
	
	
	public ResponsableClub() {}
	public ResponsableClub(String login, String pwd) {
		this.login = login;
		this.password = pwd;
	}


	public int getId() {
		return id;
	}
	public Club getClub() {
		return club;
	}

	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	
	

}
