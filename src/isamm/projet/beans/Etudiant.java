package isamm.projet.beans;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Etudiant extends Personne{
	private String cne;
	@ManyToOne
	@JoinColumn(name = "filiere_id")
	private Filiere filiere;

	public Etudiant(String cne) {
		this.cne = cne;
	}

	public Etudiant() {
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

}
