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
	public List<Operations> readOperations(String sidx, String sord) {
		List<Operations> opts = new ArrayList<Operations>();
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    opts = (ArrayList<Operations>) session.createQuery("FROM Operations order by "+sidx+" "+sord).list(); 
	    tx.commit();
	    session.close();
		return opts;
	}
	
	@SuppressWarnings("unchecked")
	public List<Operations> readOperationsByRoleId(String roleId, String sidx, String sord) {
		List<Operations> opts = new ArrayList<Operations>();
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    opts = (ArrayList<Operations>) session.createQuery("select * FROM Operations where id in "
	    		+ "(select operationId from RoleOperation where roleId='"+roleId+"') order by "+sidx+" "+sord).list(); 
	    tx.commit();
	    session.close();
		return opts;
	}
	
}
