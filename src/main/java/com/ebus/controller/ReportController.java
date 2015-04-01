package com.ebus.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebus.entity.DailyAuditReport;
import com.ebus.entity.LoginForm;
import com.ebus.service.ReportsService;
import com.ebus.util.Utilities;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
public class ReportController {
	
	@Autowired
	ReportsService reportsService;
	
	 @RequestMapping(value = "/reports", method = RequestMethod.GET)
	    public String home() {
	    	return "reports";

	    }
	 
	 @RequestMapping(value = "/dailyAuditReport", method = RequestMethod.POST)
	    public String create(HttpServletRequest request) {
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

	    	// jrxml compiling process
	    	try {
	    		String jrxml = "c://supraja/report2.jrxml";
				//InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(jrxml);
				//jasperDesign = JRXmlLoader.load(input);		
				jasperReport = JasperCompileManager.compileReport(jrxml);
				// filling report with data from data source
				JRDataSource datasource = new JRBeanCollectionDataSource(records, true);
	            jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter, datasource);
	            //jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter);
				JasperExportManager.exportReportToPdfFile(jasperPrint, "C://supraja/sample_report.pdf");
				
	        } catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return "loginsuccess";
			

	    }

}
