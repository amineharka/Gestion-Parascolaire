package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Administrateur extends Utilisateur{
	
	public Administrateur() {}
	public Administrateur(String login, String pwd) {
		this.login = login;
		this.password = pwd;
	}
	
	
}
