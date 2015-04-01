package com.ebus.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ebus.service.LoginService;

public class DailyAuditReport {
	
	@Autowired
	static SessionFactory sessionFactory;
	static Session session = null;
	static Transaction tx = null;
	
	private String locationCode;
	private String location;
	private int employeeNo;
	private String employeeName;
	private int moduleId;
	private int module;
	private int modOnReaderId;
	private String modSignOnLoc;
	private Timestamp modSignOnTime;
	private int modOffReaderId;
	private String modSignOffLoc;
	private Timestamp modSignOffTime;
	private int dutyId;
	private String duty;
	private Timestamp dutyDate;
	private Timestamp dutySignOn;
	private Timestamp dutySignOff;
	private String busNumber;
	private byte equipmentType;
	private String equipmentNumber;
	private String firstRoute;
	private short firstJournery;
	private int revenue;
	private int tickets;
	private int passes;
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public int getModule() {
		return module;
	}
	public void setModule(int module) {
		this.module = module;
	}
	public int getModOnReaderId() {
		return modOnReaderId;
	}
	public void setModOnReaderId(int modOnReaderId) {
		this.modOnReaderId = modOnReaderId;
	}
	public String getModSignOnLoc() {
		return modSignOnLoc;
	}
	public void setModSignOnLoc(String modSignOnLoc) {
		this.modSignOnLoc = modSignOnLoc;
	}
	public Timestamp getModSignOnTime() {
		return modSignOnTime;
	}
	public void setModSignOnTime(Timestamp modSignOnTime) {
		this.modSignOnTime = modSignOnTime;
	}
	public int getModOffReaderId() {
		return modOffReaderId;
	}
	public void setModOffReaderId(int modOffReaderId) {
		this.modOffReaderId = modOffReaderId;
	}
	public String getModSignOffLoc() {
		return modSignOffLoc;
	}
	public void setModSignOffLoc(String modSignOffLoc) {
		this.modSignOffLoc = modSignOffLoc;
	}
	public Timestamp getModSignOffTime() {
		return modSignOffTime;
	}
	public void setModSignOffTime(Timestamp modSignOffTime) {
		this.modSignOffTime = modSignOffTime;
	}
	public int getDutyId() {
		return dutyId;
	}
	public void setDutyId(int dutyId) {
		this.dutyId = dutyId;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Timestamp getDutyDate() {
		return dutyDate;
	}
	public void setDutyDate(Timestamp dutyDate) {
		this.dutyDate = dutyDate;
	}
	public Timestamp getDutySignOn() {
		return dutySignOn;
	}
	public void setDutySignOn(Timestamp dutySignOn) {
		this.dutySignOn = dutySignOn;
	}
	public Timestamp getDutySignOff() {
		return dutySignOff;
	}
	public void setDutySignOff(Timestamp dutySignOff) {
		this.dutySignOff = dutySignOff;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public byte getEquipmentType() {
		return equipmentType;
	}
	
	public void setEquipmentType(byte equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getEquipmentNumber() {
		return equipmentNumber;
	}
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	public String getFirstRoute() {
		return firstRoute;
	}
	public void setFirstRoute(String firstRoute) {
		this.firstRoute = firstRoute;
	}
	public short getFirstJournery() {
		return firstJournery;
	}
	public void setFirstJournery(short firstJournery) {
		this.firstJournery = firstJournery;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public int getPasses() {
		return passes;
	}
	public void setPasses(int passes) {
		this.passes = passes;
	}
	
	public static Collection getStudentList()
    {
		List<DailyAuditReport> rows = new ArrayList<DailyAuditReport>();
	   
           DailyAuditReport row = new DailyAuditReport();
           row.setLocationCode("A1");
           row.setLocation("Atemelang one (A1)");
           row.setEmployeeNo(1234);
           row.setEmployeeName("New Driver 1234");
           row.setBusNumber("0000");
           row.setDuty( "32");
           row.setDutyDate(new Timestamp(1));
           row.setDutyId(1234);
           row.setModSignOnLoc("On A1");
           row.setDutySignOn(new Timestamp(1));
           row.setModSignOffLoc("off A1");
           row.setModSignOffTime(new Timestamp(1));
           row.setDutySignOn(new Timestamp(1));
           row.setDutySignOff(new Timestamp(1));
           row.setEquipmentType((byte) 1);
           row.setEquipmentNumber("004115");
           row.setFirstRoute("B03S");
           row.setFirstJournery((short) 3250);
           row.setRevenue(10240);
           row.setTickets(10);
           row.setPasses(0);
           rows.add(row); 
           
           DailyAuditReport row1 = new DailyAuditReport();
           row1.setLocationCode("A1");
           row1.setLocation("Atemelang one (A1)");
           row1.setEmployeeNo(1234);
           row1.setEmployeeName("New Driver 1234");
           row1.setBusNumber("0000");
           row1.setDuty( "32");
           row1.setDutyDate(new Timestamp(1));
           row1.setDutyId(1234);
           row1.setModSignOnLoc("On A1");
           row1.setDutySignOn(new Timestamp(1));
           row1.setModSignOffLoc("off A1");
           row1.setModSignOffTime(new Timestamp(1));
           row1.setDutySignOn(new Timestamp(1));
           row1.setDutySignOff(new Timestamp(1));
           row1.setEquipmentType((byte) 1);
           row1.setEquipmentNumber("004115");
           row1.setFirstRoute("B03S");
           row1.setFirstJournery((short) 250);
           row1.setRevenue(1240);
           row1.setTickets(10);
           row1.setPasses(0);
           rows.add(row1); 
           
           DailyAuditReport row2 = new DailyAuditReport();
           row2.setLocationCode("A1");
           row2.setLocation("Atemelang one (A1)");
           row2.setEmployeeNo(123456);
           row2.setEmployeeName("New Driver 1234");
           row2.setBusNumber("0000");
           row2.setDuty( "32");
           row2.setDutyDate(new Timestamp(1));
           row2.setDutyId(1234);
           row2.setModSignOnLoc("On A1");
           row2.setDutySignOn(new Timestamp(1));
           row2.setModSignOffLoc("off A1");
           row2.setModSignOffTime(new Timestamp(1));
           row2.setDutySignOn(new Timestamp(1));
           row2.setDutySignOff(new Timestamp(1));
           row2.setEquipmentType((byte) 1);
           row2.setEquipmentNumber("004115");
           row2.setFirstRoute("B03S");
           row2.setFirstJournery((short) 3250);
           row2.setRevenue(10240);
           row2.setTickets(10);
           row2.setPasses(0);
           rows.add(row2); 
       
	    System.out.println("rows size is "+rows.size());
		return rows;
       
    }
	
	
}
