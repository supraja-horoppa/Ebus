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

import com.ebus.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;
	
	public Role readRoleById(String roleId) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		tx = session.getTransaction();
		String hql = "FROM Role R WHERE R.id = '"+roleId+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		Iterator it = results.iterator();
		Role role = null;
		while(it.hasNext()) {
			role =(Role) it.next();
		}
		tx.commit();
		session.close();
		return role;
	}

	@SuppressWarnings("unchecked")
	public List<Role> readRoles(String sidx, String sord) {
		List<Role> roles = new ArrayList<Role>();
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    roles = (ArrayList<Role>) session.createQuery("FROM Role order by "+sidx+" "+sord).list(); 
	    tx.commit();
	    session.close();
		return roles;
	}
	
	public Role createRole(Role role) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		tx = session.getTransaction();
		session.save(role);
		tx.commit();
		session.close();
		return role;
	}
	
	public boolean deleteRole(String roleId)  {
		session = sessionFactory.openSession();
		session.beginTransaction();
		tx = session.getTransaction();
		Object o = session.load(Role.class, roleId);
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}
	
	public Role updateRole(String roleId, Role role) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(role); 
		Role roleObj = (Role) session.load(Role.class,
				new String(roleId));
		tx.commit();
		session.close();
		return roleObj;
	}

	@SuppressWarnings("unchecked")
	public List<Role> readRoles() {
		List<Role> roles = new ArrayList<Role>();
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    roles = (ArrayList<Role>) session.createQuery("FROM Role").list(); 
	    tx.commit();
	    session.close();
		return roles;
	}

}
