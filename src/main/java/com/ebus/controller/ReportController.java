package com.ebus.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ebus.entity.DailyAuditReport;
import com.ebus.entity.ReportParams;
import com.ebus.service.ReportParamsService;
import com.ebus.service.ReportsService;
import com.ebus.util.Utilities;


@Controller
public class ReportController {
	
	@Autowired
	ReportsService reportsService;
	
	@Autowired
	ReportParamsService reportParamsService;
	
	/*@RequestMapping(value = "/dailyAuditReport", method = RequestMethod.GET)
	    public ResponseEntity<byte[]> getDailyAuditReport() {
	    	ReportParams reportParam = reportParamsService.GetReportParams();
	    	String location = reportParam.getLocationParam();
	    	String date = reportParam.getDateParam();
		    JasperReport jasperReport;
	    	JasperPrint jasperPrint;
	    	JasperDesign jasperDesign;
	    	Map jasperParameter = new HashMap();
	    	jasperParameter.put("selectedLocation", location );
	    	jasperParameter.put("selectedDate", date);
	    	List<DailyAuditReport> records = reportsService.dailyAuditReport(location,date);
	    	try {
	    		String jrxml = "C://supraja/Ebus/Ebus/report2.jrxml";
				jasperReport = JasperCompileManager.compileReport(jrxml);
				JRDataSource datasource = new JRBeanCollectionDataSource(records, true);
	            jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter, datasource);
	            JasperExportManager.exportReportToPdfFile(jasperPrint, "C://supraja/Ebus/Ebus/dailyAuditReport.pdf");
				
	        } catch (JRException e) {
				e.printStackTrace();
			}
	    	InputStream input;
	    	byte[] contents = null;
			try {
				input = new FileInputStream(new File("C://supraja/Ebus/Ebus/dailyAuditReport.pdf"));
			    contents = IOUtils.toByteArray(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			    	
	    	HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/pdf"));
	        String filename = "dailyAuditReport.pdf";
	        headers.setContentDispositionFormData(filename, filename);
	        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
	        return response;

	    }*/
	 
	 @RequestMapping(value = "/getDailyAuditReport", method = RequestMethod.POST)
	    public ResponseEntity<byte[]> create(HttpServletRequest request) {
	    	ReportParams reportParam = null;
		  String checkParam = null;
		  String date = null;
		  String dateString = null;
		  String contracts = null;
		  String duties = null;
		  String buses = null;
		  String routes = null;
		  String staff = null;
		  String location = null;
		  Enumeration<String> elements = request.getParameterNames();
	    	while(elements.hasMoreElements()) {
	    		String param = (String) elements.nextElement();
	    		if(param.equals("contracts")) {
	    			contracts = request.getParameter(param);
	    			System.out.println("contracts "+contracts);
	    		} else if(param.equals("date")) {
	    			dateString = request.getParameter(param);
          			date = Utilities.fromStringToTimeStamp(dateString);
          			System.out.println("date from ui is "+dateString + "and timestamp is "+date);
	    		} else if(param.equals("duties")) {
	    			duties = request.getParameter(param);
	    			System.out.println("duties are "+duties);
	    		} else if(param.equals("buses")) {
	    			buses = request.getParameter(param);
	    			System.out.println("buses are "+buses);
	    		} else if(param.equals("routes")) {
	    			routes = request.getParameter(param);
	    			System.out.println("routes are "+routes);
	    		} else if(param.equals("staff")) {
	    			staff = request.getParameter(param);
	    			System.out.println("staff are "+staff);
	    		}else if(param.equals("checkParam")) {
	    			checkParam = request.getParameter(param);
	    			System.out.println("checkparam is "+checkParam);
	    		} else if(param.equals("location")) {
	    			location = request.getParameter(param);
	    			System.out.println("location is "+location);
	    		}
	    	}
	    	HttpSession session =request.getSession();
	        String userId = (String) session.getAttribute("loginId");
	    	if(checkParam.equals("on")) {
	    		reportParam = reportParamsService.GetReportParamsByLoginId(userId);
	    		location = reportParam.getLocationParam();
	    	} 
	    	JasperReport jasperReport;
	    	JasperPrint jasperPrint;
	    	JasperDesign jasperDesign;
	    	Map jasperParameter = new HashMap();
	    	jasperParameter.put("selectedLocation", location);
	    	jasperParameter.put("selectedDate", date);
	    	List<DailyAuditReport> records = reportsService.dailyAuditReport(location,dateString);
	    	try {
	    		String jrxml = "C://supraja/Ebus/Ebus/report2.jrxml";
				jasperReport = JasperCompileManager.compileReport(jrxml);
				JRDataSource datasource = new JRBeanCollectionDataSource(records, true);
	            jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter, datasource);
	            JasperExportManager.exportReportToPdfFile(jasperPrint, "C://supraja/Ebus/Ebus/dailyAuditReport.pdf");
				
	        } catch (JRException e) {
				e.printStackTrace();
			}
	    	InputStream input;
	    	byte[] contents = null;
			try {
				input = new FileInputStream(new File("C://supraja/Ebus/Ebus/dailyAuditReport.pdf"));
			    contents = IOUtils.toByteArray(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
			    	
	    	HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/pdf"));
	        String filename = "dailyAuditReport.pdf";
	        headers.setContentDispositionFormData(filename, filename);
	        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
	        return response;
		}
	    
	    @RequestMapping(value = "/reportList", method = RequestMethod.GET)
	    public String trySample() {
	    	return "reportList";

	    }
	     
	   
	    @RequestMapping(value = "/saveReportParams", method = RequestMethod.POST)
	    public String saveReportParams(HttpServletRequest request) {
	    	String location = null;
			String date = null;
			String contracts = null;
			String duties = null;
			String routes = null;
			String staff = null;
			String buses = null;
			Enumeration<String> elements = request.getParameterNames();
		    	while(elements.hasMoreElements()) {
		    		String param = (String) elements.nextElement();
		    		if(param.equals("location")) {
		    			location = request.getParameter(param);
		    		} else if(param.equals("contracts")) {
		    			contracts = request.getParameter(param);
		    		} else if(param.equals("duties")) {
		    			duties = request.getParameter(param);
		    		} else if(param.equals("routes")) {
		    			routes = request.getParameter(param);
		    		} else if(param.equals("staff")) {
		    			staff = request.getParameter(param);
		    		} else if(param.equals("buses")) {
		    			buses = request.getParameter(param);
		    		}
		    	}
		    ReportParams reportParams = new ReportParams();
		    reportParams.setLocationParam(location);
		    reportParams.setContractsParam(contracts);
		    reportParams.setDutiesParam(duties);
		    reportParams.setRoutesParam(routes);
		    reportParams.setBusesParam(buses);
		    reportParams.setStaffParam(staff);
		    HttpSession session =request.getSession();
	        String userId = (String) session.getAttribute("loginId");
	        reportParams.setLoginId(userId);
	        ReportParams reportObj = reportParamsService.GetReportParamsByLoginId(userId);
	        if(reportObj == null) {
	        	reportParamsService.CreateReportParams(reportParams);
	        } else {
	        	reportParamsService.UpdateReportParams(reportObj.getId(),reportParams);
	        }
		    return "reportList";
	    }
	    
	    @RequestMapping(value="/dailyAuditReport", method = RequestMethod.GET)
	    public ModelAndView renderTable(HttpServletRequest request) {
	        ModelAndView mv = new ModelAndView("/dailyAuditReport"); 
	        HttpSession session =request.getSession();
	        String userId = (String) session.getAttribute("loginId");
	        ReportParams reportParam = reportParamsService.GetReportParamsByLoginId(userId);
	        List<String> objects = new ArrayList<String>();
	        if(reportParam != null){
	        if(reportParam.getContractsParam()!=""){
	        	objects.add("Contracts parameter is "+reportParam.getContractsParam());
	        } else {
	        	objects.add("Contracts parameter is not provided");
	        }
	        if(reportParam.getLocationParam() != ""){
	        	objects.add("Location parameter is "+reportParam.getLocationParam());
	        } else {
	        	objects.add("Location parameter is not provided");
	        }
	        if(reportParam.getDutiesParam() != ""){
	        	objects.add("Duties parameter is "+reportParam.getDutiesParam());
	        } else {
	        	objects.add("Duties parameter is not provided");
	        }
	        if(reportParam.getRoutesParam() != ""){
	        	objects.add("Routes parameter is "+reportParam.getRoutesParam());
	        } else {
	        	objects.add("Routes parameter is not provided");
	        }
	        if(reportParam.getBusesParam() != ""){
	        	objects.add("Buses parameter is "+reportParam.getBusesParam());
	        } else {
	        	objects.add("Buses parameter is not provided");
	        }
	        if(reportParam.getStaffParam() != ""){
	        	objects.add("Staff parameter is "+reportParam.getStaffParam());
	        } else {
	        	objects.add("Staff parameter is not provided");
	        }
	        } else {
	        	objects.add("No parameters present");
	        }
	        
	        mv.addObject("objects",objects);
	        return mv;
	    }
	    

	    @RequestMapping(value = "/reportParams", method = RequestMethod.GET)
	    public ModelAndView loginfail(Map<String, Object> model,HttpServletRequest request){
	    	ModelAndView mv = new ModelAndView("/reportParams"); 
	    	HttpSession session =request.getSession();
	        String userId = (String) session.getAttribute("loginId");
	        System.out.println("user id is +userId");
	        ReportParams reportParam = reportParamsService.GetReportParamsByLoginId(userId);
	        List<String> objects = new ArrayList<String>();
	        if(reportParam != null){
	        if(reportParam.getContractsParam()!=""){
	        	objects.add("Contracts parameter is "+reportParam.getContractsParam());
	        } else {
	        	objects.add("Contracts parameter is not provided");
	        }
	        if(reportParam.getLocationParam() != ""){
	        	objects.add("Location parameter is "+reportParam.getLocationParam());
	        } else {
	        	objects.add("Location parameter is not provided");
	        }
	        if(reportParam.getDutiesParam() != ""){
	        	objects.add("Duties parameter is "+reportParam.getDutiesParam());
	        } else {
	        	objects.add("Duties parameter is not provided");
	        }
	        if(reportParam.getRoutesParam() != ""){
	        	objects.add("Routes parameter is "+reportParam.getRoutesParam());
	        } else {
	        	objects.add("Routes parameter is not provided");
	        }
	        if(reportParam.getBusesParam() != ""){
	        	objects.add("Buses parameter is "+reportParam.getBusesParam());
	        } else {
	        	objects.add("Buses parameter is not provided");
	        }
	        if(reportParam.getStaffParam() != ""){
	        	objects.add("Staff parameter is "+reportParam.getStaffParam());
	        } else {
	        	objects.add("Staff parameter is not provided");
	        }
	        } else {
	        	objects.add("No parameters present");
	        }
	        
	        mv.addObject("objects",objects);
	        return mv;
	    }
	    
	    
}
