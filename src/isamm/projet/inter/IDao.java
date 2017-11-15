package isamm.projet.inter;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import isamm.projet.beans.HibernateUtil;

public interface IDao {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	public Boolean create(Object T);
	
	public List<Object> getAll();
	
	public boolean delete(int id);
	
	public Boolean update(int id, Object T);
	
	public boolean getByid(int id);
}
