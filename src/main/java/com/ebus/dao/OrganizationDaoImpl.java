package com.ebus.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.entity.Organization;

public class OrganizationDaoImpl implements OrganizationDao{
	
	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;
	

	
	@SuppressWarnings("unchecked")
	public ArrayList<Organization> getOrganizations() throws Exception {
		
		ArrayList<Organization> accts = new ArrayList<Organization>();
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    accts = (ArrayList<Organization>) session.createQuery("FROM Organization").list(); 
	    tx.commit();
	    session.close();
		return accts;
	}

}
