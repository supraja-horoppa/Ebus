package com.ebus.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Entity
@Table(name="dbo.ReportParams")
public class ReportParams {
	@Id
	@Column(name="id")
	private String id;
    @Column(name="location_param")
    private String locationParam;
	@Column(name="contracts_param")
	private String contractsParam;
	@Column(name="duties_param")
	private String dutiesParam;
	@Column(name="routes_param")
	private String routesParam;
	@Column(name="buses_param")
	private String busesParam;
	@Column(name="staff_param")
	private String staffParam;
	@Column(name="login_id")
	private String loginId;
	
	public ReportParams(){
		
	}
	
	public ReportParams(String json) {
		
		// Fill out default values
		ReportParamsDefault();

		// Override default values with JSON
		updateByJson(json);

		// Assign GUID
		id = UUID.randomUUID().toString();
	}
	
	public void updateByJson(String json) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		ReportParams reportParams = gson.fromJson(json, this.getClass());

		if (json.contains("locationParam")&& !((reportParams.locationParam).isEmpty())) {
			this.locationParam = reportParams.locationParam;
		}
		if (json.contains("contractsParam") && !((reportParams.contractsParam).isEmpty())) {
			this.contractsParam = reportParams.contractsParam;
		}
		if (json.contains("dutiesParam") && !((reportParams.dutiesParam).isEmpty())) {
			this.dutiesParam = reportParams.dutiesParam;
		}
		if (json.contains("busesParam") && !((reportParams.busesParam).isEmpty())) {
			this.busesParam = reportParams.busesParam;
		}
		if (json.contains("staffParam") && !((reportParams.staffParam).isEmpty())) {
			this.staffParam = reportParams.staffParam;
		}
		if (json.contains("routesParam") && !((reportParams.routesParam).isEmpty())) {
			this.routesParam = reportParams.routesParam;
		}
		if (json.contains("loginId") && reportParams.loginId!="") {
			this.loginId = reportParams.loginId;
		}
		
	}
	
	public void ReportParamsDefault() {
		this.id = "";
		this.locationParam = "";
		this.contractsParam = "";
		this.dutiesParam = "";
		this.routesParam = "";
		this.staffParam = "";
		this.busesParam = "";
		this.loginId = "";
		
	}
	
	public String toJson() {
		JsonObject json = new Gson().toJsonTree(this).getAsJsonObject();
		return json.toString();
	}
	
	public String getLocationParam() {
		return locationParam;
	}
	public void setLocationParam(String locationParam) {
		this.locationParam = locationParam;
	}
	public String getContractsParam() {
		return contractsParam;
	}
	public void setContractsParam(String contractsParam) {
		this.contractsParam = contractsParam;
	}
	public String getDutiesParam() {
		return dutiesParam;
	}
	public void setDutiesParam(String dutiesParam) {
		this.dutiesParam = dutiesParam;
	}
	public String getRoutesParam() {
		return routesParam;
	}
	public void setRoutesParam(String routesParam) {
		this.routesParam = routesParam;
	}
	public String getBusesParam() {
		return busesParam;
	}
	public void setBusesParam(String busesParam) {
		this.busesParam = busesParam;
	}
	public String getStaffParam() {
		return staffParam;
	}
	public void setStaffParam(String staffParam) {
		this.staffParam = staffParam;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
		
}
