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
		Query query = session.createQuery(hql);
		List results = query.list();
		Iterator it = results.iterator();
		LoginForm login = null;
		while(it.hasNext()) {
			login =(LoginForm) it.next();
		}
		tx.commit();
		session.close();
		return login;
	}

	@SuppressWarnings("unchecked")
	public List<LoginForm> readUsers() {
		List<LoginForm> accts = new ArrayList<LoginForm>();
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    accts = (ArrayList<LoginForm>) session.createQuery("FROM LoginForm").list(); 
	    tx.commit();
	    session.close();
		return accts;
	}
}
