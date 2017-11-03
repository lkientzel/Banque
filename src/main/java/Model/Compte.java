package Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	private String libelle;
	private int solde;
	
	
	@OneToMany(mappedBy="numero", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Transaction> lesTransaction;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public int getSolde() {
		return solde;
	}
	
	public void setSolde(int solde) {
		this.solde = solde;
	}
	
	public List<Transaction> getLesTransaction() {
		return lesTransaction;
	}
	public void setLesTransaction(List<Transaction> lesTransaction) {
		this.lesTransaction = lesTransaction;
	}
}
