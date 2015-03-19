package com.ebus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.ebus.entity.Operations;

public class OperationsDaoImpl implements OperationsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;

	@SuppressWarnings("unchecked")
	public List<Operations> readOperations() {
		List<Operations> opts = new ArrayList<Operations>();
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    opts = (ArrayList<Operations>) session.createQuery("FROM Operations").list(); 
	    tx.commit();
	    session.close();
		return opts;
	}
}
