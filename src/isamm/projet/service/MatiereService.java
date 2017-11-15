package isamm.projet.service;

import java.util.List;

import org.hibernate.Transaction;

import isamm.projet.beans.Matiere;
import isamm.projet.inter.IDao;

public class MatiereService implements IDao{
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
		return session.createCriteria(Matiere.class).list();
	}

	@Override
	public boolean delete(int id) {
		tx = session.beginTransaction();
		session.delete(session.load(Matiere.class, id));
		tx.commit();
		return true;
	}

	@Override
	public Boolean update(int id, Object T) {
		tx = session.beginTransaction();
		Matiere matiere = (Matiere) T;
		matiere.setId(id);
		session.save(matiere);
		tx.commit();
		return true;
	}

	@Override
	public boolean getByid(int id) {
		session.load(Matiere.class, id);
		return true;
	}

}
