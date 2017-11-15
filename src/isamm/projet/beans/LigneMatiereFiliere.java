package isamm.projet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligneMatiereFiliere")
public class LigneMatiereFiliere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int masseHoraire;
	@ManyToOne
	@JoinColumn(name = "matiere_id")
	private Matiere matiere;
	@ManyToOne
	@JoinColumn(name = "filiere_id")
	private Filiere filiere;

	public LigneMatiereFiliere() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMasseHoraire() {
		return masseHoraire;
	}

	public void setMasseHoraire(int masseHoraire) {
		this.masseHoraire = masseHoraire;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

}
