package isamm.projet.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Formateur extends Personne {
	private String matricule;
	@OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
	private Set<Matiere> matieres;

	public Formateur() {
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

}
