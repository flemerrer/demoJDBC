package fr.eni.demo.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Collection;

public class Formateur {

	private String prenom;
	private String nom;
	private Collection<Object> listeCours = new ArrayList();

//	@NotBlank
//	@Email
//	@Pattern(regexp="^[@-_.]")
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

	public void addCours(Object cours) {
		this.listeCours.add(cours);
	}
}
