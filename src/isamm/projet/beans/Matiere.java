package isamm.projet.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String libelle;
	@ManyToOne
	@JoinColumn(name = "formateur_id")
	private Formateur formateur;
	@OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
	private Set<LigneMatiereFiliere> ligneMatiereFilieres;

	public Matiere(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	public Matiere() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Set<LigneMatiereFiliere> getLigneMatiereFilieres() {
		return ligneMatiereFilieres;
	}

	public void setLigneMatiereFilieres(Set<LigneMatiereFiliere> ligneMatiereFilieres) {
		this.ligneMatiereFilieres = ligneMatiereFilieres;
	}
}
