package com.ebus.service;

import com.ebus.entity.ReportParams;

public interface ReportParamsService {
	
	public ReportParams GetReportParams(String userId);
	
	public void CreateReportParams(ReportParams reportParams);
	
	public ReportParams UpdateReportParams(String userId, ReportParams reportParams);
	
	public ReportParams GetReportParamsByLoginId(String loginId);

}
