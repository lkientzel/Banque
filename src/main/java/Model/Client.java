package Model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	private String nom;
	private String prenom;
	private String password;
	private String login;
	
	@OneToMany(mappedBy = "client", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Compte> lesComptes;
	
	public List<Compte> getLesComptes() {
		return lesComptes;
	}

	public void setLesComptes(List<Compte> lesComptes) {
		this.lesComptes = lesComptes;
	}

	public String toString() {
		return idClient + " " + nom + " " + prenom + " " + login;
	}
	
	public String toJSON() {
		return "{" + idClient + ";" + nom + ";" + prenom + ";" + login + ";" + password +"}";
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
