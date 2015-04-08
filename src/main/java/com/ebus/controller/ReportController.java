package com.ebus.controller;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebus.entity.DailyAuditReport;
import com.ebus.entity.LoginForm;
import com.ebus.service.ReportsService;
import com.ebus.util.Utilities;


@Controller
public class ReportController {
	
	@Autowired
	ReportsService reportsService;
	
	 @RequestMapping(value = "/dailyAuditReport", method = RequestMethod.GET)
	    public String home() {
	    	return "dailyAuditReport";

	    }
	 
	 @RequestMapping(value = "/dailyAuditReport", method = RequestMethod.POST)
	    public ResponseEntity<byte[]> create(HttpServletRequest request) {
	    	
		  String location = null;
		  Timestamp date = null;
		  String dateString = null;
		  Enumeration<String> elements = request.getParameterNames();
	    	while(elements.hasMoreElements()) {
	    		String param = (String) elements.nextElement();
	    		if(param.equals("location")) {
	    			location = request.getParameter(param);
	    		} else if(param.equals("date")) {
	    			dateString = request.getParameter(param);
          			date = Utilities.fromStringToTimeStamp(request.getParameter(param));
	    		} 
	    	}
	    	JasperReport jasperReport;
	    	JasperPrint jasperPrint;
	    	JasperDesign jasperDesign;
	    	Map jasperParameter = new HashMap();
	    	jasperParameter.put("selectedLocation", location);
	    	jasperParameter.put("selectedDate", dateString);
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
		}
	    
	    @RequestMapping(value = "/reportList", method = RequestMethod.GET)
	    public String trySample() {
	    	return "reportList";

	    }
	    
	    
}
