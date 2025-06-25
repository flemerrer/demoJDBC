package fr.eni.demo.bo;

public class Cours {

	private String nom;
	private long id;
	private Object titre;
	private Object duree;

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Object getTitre() {
		return titre;
	}

	public void setTitre(Object titre) {
		this.titre = titre;
	}

	public Object getDuree() {
		return duree;
	}

	public void setDuree(Object duree) {
		this.duree = duree;
	}
}
