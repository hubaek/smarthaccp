package com.ppm.mes.utils;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReportUtil {

	List beanDataList =null;
	Connection dbcon =null;
	
	public  void setBeanDataList(List dlist){
		beanDataList =dlist;
	}
	
	public void setDBConnection (Connection c){
		this.dbcon =c;
	}
	public  byte[] toPdf(String jrxmlfile, Map para) throws Exception{
		JasperDesign jasperDesign =JRXmlLoader.load(jrxmlfile);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint =null;
        if (this.dbcon !=null)
        	jasperPrint = JasperFillManager.fillReport(jasperReport,para,this.dbcon);
        else 
        	jasperPrint = JasperFillManager.fillReport(jasperReport,para,new JRBeanCollectionDataSource(this.beanDataList));
        
        byte[] report =JasperExportManager.exportReportToPdf(jasperPrint);
        return report;
	}
	public  byte[] toPdf(JasperPrint jasperPrint) throws Exception{
		
        byte[] report =JasperExportManager.exportReportToPdf(jasperPrint);
        return report;
	}
	public  byte[] toPdf(JasperPrint jasperPrint1,JasperPrint jasperPrint2) throws Exception{
		List al =jasperPrint2.getPages();
    	for(int i=0;i<al.size();i++){
    		jasperPrint1.addPage((JRPrintPage)al.get(i));
    	}
        byte[] report =JasperExportManager.exportReportToPdf(jasperPrint1);
        return report;
	}
	public  byte[] toPdf(String[] jrxmlfiles, Map para) throws Exception{
		//System.out.println("jrxml file :"+jrxmlfiles[0]);
		JasperPrint jasperPrint =getJasperPrint(jrxmlfiles[0],para);
		for(int i =1;i<jrxmlfiles.length;i++){
			//System.out.println("jrxml file :"+jrxmlfiles[i]);
			JasperPrint jasperPrint2 =getJasperPrint(jrxmlfiles[i],para);
			List al =jasperPrint2.getPages();
	    	for(int j=0;j<al.size();j++){
	    		jasperPrint.addPage((JRPrintPage)al.get(j));
	    	}
		}
		
        byte[] report =JasperExportManager.exportReportToPdf(jasperPrint);
        return report;
	}
	public  void toHtmlFile(String jrxmlfile, Map para,String destfile) throws Exception{
		JasperDesign jasperDesign =JRXmlLoader.load(jrxmlfile);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint =null;
        if (this.dbcon !=null)
        	jasperPrint = JasperFillManager.fillReport(jasperReport,para,this.dbcon);
        else 
        	jasperPrint = JasperFillManager.fillReport(jasperReport,para,new JRBeanCollectionDataSource(this.beanDataList));
        JasperExportManager.exportReportToHtmlFile(jasperPrint, destfile);
        
	}
	
	public  JasperPrint getJasperPrint(String jrxmlfile, Map para) throws Exception{
		JasperDesign jasperDesign =JRXmlLoader.load(jrxmlfile);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint =null;
        if (this.dbcon !=null)
        	jasperPrint = JasperFillManager.fillReport(jasperReport,para,this.dbcon);
        else 
        	jasperPrint = JasperFillManager.fillReport(jasperReport,para,new JRBeanCollectionDataSource(this.beanDataList));
        return jasperPrint;
        
	}

	public byte[] toPdf(List paraList) throws Exception{
		// TODO Auto-generated method stub
		JasperPrint jasperPrint =null;
		for(int i =0;i<paraList.size();i++){
			Map para =(Map)paraList.get(i);
			String reportfile =(String)para.get("ReportPath")+(String)para.get("reportFile");
			if (i==0) jasperPrint =getJasperPrint(reportfile,para);
			else {
				JasperPrint jasperPrint2 =getJasperPrint(reportfile,para);
				List al =jasperPrint2.getPages();
		    	for(int j=0;j<al.size();j++){
		    		jasperPrint.addPage((JRPrintPage)al.get(j));
		    	}
			}
		}
		
        byte[] report =JasperExportManager.exportReportToPdf(jasperPrint);
		return report;
	}
	
	
}
