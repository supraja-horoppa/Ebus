package com.ebus.view;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ebus.entity.DailyAuditReport;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
 
public class PdfGen {
	
	public static Connection establishConnection()
	{
	Connection connection = null;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String oracleURL = "jdbc:sqlserver://localhost;databaseName=Merit_Atamelang;instaneName=NOVUM-SUPRAJA-P";
	connection = DriverManager.getConnection(oracleURL,"ebus","supraja");
	connection.setAutoCommit(false);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch(SQLException exception)
	{
	exception.printStackTrace();
	}
	return connection;
	}
 
    public static void main(String[] args) {
 
    	/* JasperReport is the object
    	that holds our compiled jrxml file */
    	JasperReport jasperReport;
    	/* JasperPrint is the object contains
    	7.
    	report after result filling process */
    	JasperPrint jasperPrint;
    	JasperDesign jasperDesign;
    	// connection is the data source we used to fetch the data from
    	Connection connection = establishConnection(); 
    	// jasperParameter is a Hashmap contains the parameters
    	// passed from application to the jrxml layout
    	HashMap jasperParameter = new HashMap();
    	List<DailyAuditReport> records = (List<DailyAuditReport>) DailyAuditReport.getStudentList();

    	// jrxml compiling process
    	try {
    		String jrxml = "c://supraja/report4.jrxml";
			//InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(jrxml);
			//jasperDesign = JRXmlLoader.load(input);		
			jasperReport = JasperCompileManager.compileReport(jrxml);
		// filling report with data from data source
			JRDataSource datasource = new JRBeanCollectionDataSource(records, true);
            //jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
       	jasperPrint = JasperFillManager.fillReport(jasperReport,jasperParameter, datasource);
		 
    	// exporting process
    	// 1- export to PDF
    	JasperExportManager.exportReportToPdfFile(jasperPrint, "C://supraja/sample_report.pdf");

    	// 2- export to HTML
    	JasperExportManager.exportReportToHtmlFile(jasperPrint, "C://supraja/sample_report.html" ); 

    	/*// 3- export to Excel sheet
    	JRXlsExporter exporter = new JRXlsExporter();
    	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    	exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "C://simple_report.xls" );

    	exporter.exportReport();*/
    	} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}