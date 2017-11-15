package isamm.projet.service;

import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import isamm.projet.beans.Formateur;
import isamm.projet.beans.Matiere;
import isamm.projet.inter.IDao;

public class FormateurService implements IDao{
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
		return session.createCriteria(Formateur.class).list();
	}

	@Override
	public boolean delete(int id) {
		tx = session.beginTransaction();
		session.delete(session.load(Formateur.class, id));
		tx.commit();
		return true;
	}

	@Override
	public Boolean update(int id, Object T) {
		tx = session.beginTransaction();
		Formateur formateur = (Formateur) T;
		formateur.setId(id);
		session.save(formateur);
		tx.commit();
		return true;
	}

	@Override
	public boolean getByid(int id) {
		session.load(Formateur.class, id);
		return true;
	}
	
	public List<Formateur> getFormateurByMetiere(Matiere matiere){
		return session.createCriteria(Formateur.class).
		createAlias("matieres", "m").
		add(Restrictions.eq("m.id", matiere.getId())).list();
	}

}
