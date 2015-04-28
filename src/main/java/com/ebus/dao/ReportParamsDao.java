package com.ebus.dao;

import com.ebus.entity.ReportParams;

public interface ReportParamsDao {
	
	public ReportParams readReportParams(String userId);
	
	public void createReportParams(ReportParams reportParams);
	
	public ReportParams updateReportParams(ReportParams reportParams);
	
	public ReportParams readReportParamsByLoginId(String loginId);

}
