package com.ppm.mes.report;


import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ppm.mes.utils.ParamSet;
import com.ppm.mes.utils.ReportUtil;

@Service
public class ReportService
{
    @Autowired
    private ReportDao reportDao;
    
    @Value("${axboot.dataSource.driverClassName}")
    private String dataSourceDriverClassName;
    
    @Value("${axboot.dataSource.url}")
    private String dataSourceUrl;
    
    @Value("${axboot.dataSource.username}")
    private String dataSourceUsername;
    
    @Value("${axboot.dataSource.password}")
    private String dataSourcePassword;


    public void setReportDao(ReportDao reportDao)
    {
        this.reportDao = reportDao;
    }


    /**
    */
    public List<Object> getReportData(String sqlid, Map<String, Object> param) throws Exception
    {
        return reportDao.getReportData(sqlid, param);
    }
    
    public Properties getReportProperties() throws Exception{
    	Properties prop = new Properties();
        //InputStream is = getClass().getResourceAsStream("/conf/properties/report.properties");
		InputStream is = getClass().getResourceAsStream("/report.properties");
        prop.load(is);
        is.close();
        
        return prop;
    }
    
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	public byte[] viewReport(ParamSet pset) throws Exception{
		// TODO Auto-generated method stub
		Map param =pset.getParamMap();
		Properties prop = new Properties();
        InputStream is = getClass().getResourceAsStream("/conf/properties/report.properties");
        prop.load(is);
        is.close();
        String filePath  = String.valueOf(prop.get("report.jrxml.path"));
        Object reportfile =pset.getParamMap().get("reportFile");
        String jrfile =null;
        byte[] report =null;
        ReportUtil rutil =new ReportUtil();
        //rutil.setDBConnection(commonDAO.getSqlSession().getConnection());
        param.put("ImagePath", filePath+File.separator+"image"+File.separator);
        param.put("ReportPath",filePath+File.separator);
        
        if(reportfile instanceof String){
        	jrfile =filePath + reportfile;
        	report =rutil.toPdf(jrfile, param);
        }else if(reportfile instanceof List){
        	//여러 종류 서류를 함께 출력
        	List rlist =(List)reportfile;
        	String[] rfiles =new String[rlist.size()];
        	for(int i =0;i<rlist.size();i++){
        		rfiles[i] =filePath + rlist.get(i);
        	}
        	report =rutil.toPdf(rfiles, param);
        }
        
     
        
		return report;
	}

	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	public byte[] viewMultiReport(List paraList) throws Exception{
		// TODO Auto-generated method stub
		Properties prop = new Properties();
        InputStream is = getClass().getResourceAsStream("/report.properties");
        prop.load(is);
        is.close();
        ReportUtil rutil =new ReportUtil();
        String filePath  = String.valueOf(prop.get("report.jrxml.path"));
        //rutil.setDBConnection(commonDAO.getSqlSession().getConnection());
		for(int i=0;i<paraList.size();i++){
			Map param =(Map)paraList.get(i);
	        
	        param.put("ImagePath", filePath+File.separator+"image"+File.separator);
	        param.put("ReportPath",filePath+File.separator);
		}
		byte[] report =rutil.toPdf( paraList);
		return report;
	}
}
