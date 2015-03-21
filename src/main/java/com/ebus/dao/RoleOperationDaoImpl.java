package com.ebus.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ebus.entity.RoleOperation;
@Repository
public class RoleOperationDaoImpl implements RoleOperationDao {
	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;
	public RoleOperation createRoleOperation(RoleOperation roleOperation) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		tx = session.getTransaction();
		session.save(roleOperation);
		tx.commit();
		session.close();
		return roleOperation;
	}

}


