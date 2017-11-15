package isamm.projet.service;

import java.util.List;

import org.hibernate.Transaction;

import isamm.projet.beans.Etudiant;
import isamm.projet.inter.IDao;

public class EtudiantService implements IDao {
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
		return session.createCriteria(Etudiant.class).list();
	}

	@Override
	public boolean delete(int id) {
		tx = session.beginTransaction();
		session.delete(session.load(Etudiant.class, id));
		tx.commit();
		return true;
	}

	@Override
	public Boolean update(int id, Object T) {
		tx = session.beginTransaction();
			Etudiant etudiant=(Etudiant) T;
				etudiant.setId(id);
			session.save(etudiant);
		tx.commit();
		return true;
	}

	@Override
	public boolean getByid(int id) {
		session.load(Etudiant.class, id);
		return true;
	}

}
