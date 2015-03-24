package com.ebus.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebus.dao.LoginDao;
import com.ebus.entity.LoginForm;
import com.ebus.entity.Organization;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;
   
	public LoginForm readLoginByUsername(String username) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		tx = session.getTransaction();
		String hql = "FROM LoginForm E WHERE E.username = '"+username+"'";
		ArrayList<LoginForm> accts = (ArrayList<LoginForm>)session.createQuery(hql).list();
		Iterator it = accts.iterator();
		LoginForm login = null;
		while(it.hasNext()) {
			login = (LoginForm) it.next();
		}
		tx.commit();
		session.close();
		return login;
	}
	
	public LoginForm readLoginById(String userId) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		tx = session.getTransaction();
		String hql = "FROM LoginForm E WHERE E.id = '"+userId+"'";
		ArrayList<LoginForm> accts = (ArrayList<LoginForm>) session.createQuery(hql).list();
		Iterator it = accts.iterator();
		LoginForm login = null;
		while(it.hasNext()) {
			login =(LoginForm) it.next();
		}
		tx.commit();
		session.close();
		return login;
	}

	@SuppressWarnings("unchecked")
	public List<LoginForm> readUsers(String sidx, String sord) {
		List<LoginForm> accts = new ArrayList<LoginForm>();
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    accts = (ArrayList<LoginForm>) session.createQuery("FROM LoginForm order by "+sidx+" "+sord).list(); 
	    tx.commit();
	    session.close();
		return accts;
	}
	
	public LoginForm createUser(LoginForm user) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		tx = session.getTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return user;
	}
	
	public boolean deleteUser(String userId)  {
		session = sessionFactory.openSession();
		session.beginTransaction();
		tx = session.getTransaction();
		Object o = session.load(LoginForm.class, userId);
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}
	
	public LoginForm updateUser(String userId, LoginForm user) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(user); 
		tx.commit();
		session.close();
		return user;
	}
}
