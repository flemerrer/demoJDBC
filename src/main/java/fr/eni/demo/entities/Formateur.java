package fr.eni.demo.entities;

import java.util.Collection;

public class Formateur {

	private String prenom;
	private String nom;
	private long id_cours_principal;
	private Collection<Object> listeCours;
	private String email;

	public Formateur() {
	}

	public Collection<Object> getListeCours() {
		return listeCours;
	}

	public Formateur(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Contact { " +
			"prenom='" + prenom + '\'' +
			", nom='" + nom + '\'' +
			" }";
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
