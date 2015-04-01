package com.ebus.dao;

import java.sql.Timestamp;
import java.util.List;

import com.ebus.entity.DailyAuditReport;

public interface ReportsDao {
	
	public List<DailyAuditReport> dailyAuditReport(String location, Timestamp date);

}
