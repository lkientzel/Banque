package Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransaction;
	private String libelle;
	private Date date;
	private int montant;
	private boolean forme;
	
	@ManyToOne
	@JoinColumn(name="numero")
	private Compte numero;
	
	public int getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public boolean getForme() {
		return forme;
	}
	public void setForme(boolean forme) {
		this.forme = forme;
	}
	public Compte getNumero() {
		return numero;
	}
	public void setNumero(Compte numero) {
		this.numero = numero;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
