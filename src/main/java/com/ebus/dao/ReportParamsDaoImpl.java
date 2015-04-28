package com.ebus.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.entity.LoginForm;
import com.ebus.entity.ReportParams;

public class ReportParamsDaoImpl implements ReportParamsDao{

	
		@Autowired
		SessionFactory sessionFactory;
		Session session = null;
		Transaction tx = null;
	   
		public ReportParams readReportParams(String reportParamId) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			tx = session.getTransaction();
			String hql = "FROM ReportParams where id ='"+reportParamId+"'";
			ArrayList<LoginForm> accts = (ArrayList<LoginForm>)session.createQuery(hql).list();
			Iterator it = accts.iterator();
			ReportParams params = null;
			while(it.hasNext()) {
				params = (ReportParams) it.next();
			}
			tx.commit();
			session.close();
			return params;
		}
		
		public ReportParams readReportParamsByLoginId(String loginId) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			tx = session.getTransaction();
			String hql = "FROM ReportParams where loginId ='"+loginId+"'";
			ArrayList<LoginForm> accts = (ArrayList<LoginForm>)session.createQuery(hql).list();
			Iterator it = accts.iterator();
			ReportParams params = null;
			while(it.hasNext()) {
				params = (ReportParams) it.next();
			}
			tx.commit();
			session.close();
			return params;
		}

		public void createReportParams(ReportParams reportParams) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			tx = session.getTransaction();
			session.save(reportParams);
			tx.commit();
			session.close();
			//return user;
		}
		
		public ReportParams updateReportParams(ReportParams reportParams) {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(reportParams); 
			tx.commit();
			session.close();
			return reportParams;
		}

}
