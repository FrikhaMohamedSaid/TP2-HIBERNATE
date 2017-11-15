package isamm.projet.service;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import isamm.projet.beans.Filiere;
import isamm.projet.beans.LigneMatiereFiliere;
import isamm.projet.beans.Matiere;
import isamm.projet.inter.IDao;

public class LigneMatiereFiliereService implements IDao{
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
		return session.createCriteria(LigneMatiereFiliere.class).list();
	}

	@Override
	public boolean delete(int id) {
		tx = session.beginTransaction();
		session.delete(session.load(LigneMatiereFiliere.class, id));
		tx.commit();
		return true;
	}

	@Override
	public Boolean update(int id, Object T) {
		tx = session.beginTransaction();
		LigneMatiereFiliere ligneMatiereFiliere = (LigneMatiereFiliere) T;
		ligneMatiereFiliere.setId(id);
		session.save(ligneMatiereFiliere);
		tx.commit();
		return true;
	}

	@Override
	public boolean getByid(int id) {
		session.load(LigneMatiereFiliere.class, id);
		return true;
	}
	
	public List<Matiere> getMatiereByFiliere(Filiere filiere){
		return session.createCriteria(Matiere.class).
		createAlias("ligneMatiereFilieres", "lms").
		add(Restrictions.eq("lms.filiere.id", filiere.getId())).list();
	}

}
