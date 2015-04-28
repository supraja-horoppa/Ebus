package com.ebus.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.dao.ReportParamsDao;
import com.ebus.entity.ReportParams;

public class ReportParamsServiceImpl implements ReportParamsService{

	@Autowired
	ReportParamsDao reportParamsDao;
	
	public ReportParams GetReportParams(String reportParamId) {
		return reportParamsDao.readReportParams(reportParamId);
	}
	
	public ReportParams GetReportParamsByLoginId(String loginId) {
		return reportParamsDao.readReportParamsByLoginId(loginId);
	}

	public void CreateReportParams(ReportParams reportParams) {
		reportParams.setId(UUID.randomUUID().toString());
		reportParamsDao.createReportParams(reportParams);
	}

	public ReportParams UpdateReportParams(String reportParamId,
			ReportParams reportParams) {
		ReportParams paramObj = reportParamsDao.readReportParams(reportParamId);
		paramObj.updateByJson(reportParams.toJson());
		System.out.println("reportParams tojson is "+paramObj.toJson());
		reportParamsDao.updateReportParams(paramObj);
		return paramObj;
	}

}
