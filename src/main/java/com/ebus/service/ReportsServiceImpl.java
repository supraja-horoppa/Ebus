package com.ebus.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.dao.ReportsDao;
import com.ebus.entity.DailyAuditReport;

public class ReportsServiceImpl implements ReportsService{
	
	@Autowired
	ReportsDao reportsDao;

	public List<DailyAuditReport> dailyAuditReport(String location, Timestamp date) {
		return reportsDao.dailyAuditReport(location, date);
	}

}
