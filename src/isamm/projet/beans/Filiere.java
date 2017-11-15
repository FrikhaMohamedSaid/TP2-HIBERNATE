package isamm.projet.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "filiere")
public class Filiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String libelle;
	@OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
	private Set<Etudiant> etudiants;
	@OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
	private Set<LigneMatiereFiliere> ligneMatiereFilieres;

	public Filiere(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	public Filiere() {
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

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Set<LigneMatiereFiliere> getLigneMatiereFilieres() {
		return ligneMatiereFilieres;
	}

	public void setLigneMatiereFilieres(Set<LigneMatiereFiliere> ligneMatiereFilieres) {
		this.ligneMatiereFilieres = ligneMatiereFilieres;
	}

}
