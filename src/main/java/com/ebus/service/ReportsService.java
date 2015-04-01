package com.ebus.service;

import java.sql.Timestamp;
import java.util.List;

import com.ebus.entity.DailyAuditReport;

public interface ReportsService {
	
	public List<DailyAuditReport> dailyAuditReport(String location, Timestamp date);

}
