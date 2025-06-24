package fr.eni.demo.bo;

import java.util.Collection;
import java.util.List;

public class Formateur {

	private String nom;
	private String email;
	private String prenom;
	private Collection<Object> listeCours;

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Collection<Object> getListeCours() {
		return listeCours;
	}

	public void setListeCours(Collection<Object> listeCours) {
		this.listeCours = listeCours;
	}
}
