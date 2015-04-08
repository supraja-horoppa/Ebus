package com.ebus.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.entity.DailyAuditReport;

public class ReportsDaoImpl implements ReportsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;

	public List<DailyAuditReport> dailyAuditReport(String location, Timestamp date) {
		session = sessionFactory.openSession();
		session.beginTransaction();
	    tx = session.getTransaction();
	    List<DailyAuditReport> rows = new ArrayList<DailyAuditReport>();
	    String sql = "exec dbo.usp_rpt_DailyAudit '"+location+"', '"+date+"'";
        SQLQuery query = session.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List data = query.list();
        System.out.println("size is "+data.size());
        for(Object object : data)
        {
           Map map = (Map)object;
           DailyAuditReport row = new DailyAuditReport();
           row.setLocationCode((String) map.get("LocationCode"));
           row.setLocation((String) map.get("Location"));
           row.setEmployeeNo((Integer) map.get("EmployeeNo"));
           row.setEmployeeName((String) map.get("EmployeeName"));
           row.setBusNumber((String) map.get("BusNumber"));
           row.setDuty( (String) map.get("Duty"));
           row.setDutyDate((Timestamp) map.get("DutyDate"));
           row.setModule((Integer) map.get("Module"));
           row.setModSignOnLoc((String) map.get("ModSignOnLoc"));
           row.setModSignOnTime((Timestamp) map.get("ModSignOnTime"));
           row.setModSignOffLoc((String) map.get("ModSignOffLoc"));
           row.setModSignOffTime((Timestamp) map.get("ModSignOffTime"));
           row.setDutySignOn((Timestamp) map.get("DutySignOn"));
           row.setDutySignOff((Timestamp) map.get("DutySignOff"));
           row.setEquipmentType((Byte) map.get("EquipmentType"));
           row.setEquipmentNumber((String) map.get("EquipmentNumber"));
           row.setFirstRoute((String) map.get("FirstRoute"));
           row.setFirstJournery((Short) map.get("FirstJourney"));
           row.setRevenue((Integer) map.get("Revenue"));
           row.setTickets((Integer) map.get("Tickets"));
           row.setPasses((Integer) map.get("Passes"));
           rows.add(row); 
        }
	    tx.commit();
	    session.close();
	    System.out.println("rows size is "+rows.size());
		return rows;
	}

}
