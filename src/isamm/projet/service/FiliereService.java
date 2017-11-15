package isamm.projet.service;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import isamm.projet.beans.Etudiant;
import isamm.projet.beans.Filiere;
import isamm.projet.inter.IDao;

public class FiliereService implements IDao {
	Transaction tx = null;

	@Override
	public Boolean create(Object T) {
		tx = session.beginTransaction();
		session.save(T);
		tx.commit();
		return true;
	}

	@Override
	public List<Object> getAll() {
		return session.createCriteria(Filiere.class).list();
	}

	@Override
	public boolean delete(int id) {
		tx = session.beginTransaction();
		session.delete(session.load(Filiere.class, id));
		tx.commit();
		return true;
	}

	@Override
	public Boolean update(int id, Object T) {
		tx = session.beginTransaction();
		Filiere filiere = (Filiere) T;
		filiere.setId(id);
		session.save(filiere);
		tx.commit();
		return true;
	}

	@Override
	public boolean getByid(int id) {
		session.load(Filiere.class, id);
		return true;
	}

	public List<Etudiant> getEtudiantByFiliere(Filiere filiere) {
		return session.createCriteria(Etudiant.class).
		add(Restrictions.eq("filiere.id", filiere.getId())).list();
	}

}
