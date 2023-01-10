package com.ppm.mes.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ppm.mes.report.ReportService;
import com.ppm.mes.utils.JsonUtil;
import com.ppm.mes.utils.ParamSet;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/*
 * report 관리
 */
@Controller
public class ReportController
{
    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    ReportService reportService;
  
    @RequestMapping(value="report/view_report")
	public void viewReport(HttpServletRequest  request, HttpServletResponse response, Locale locale, ParamSet pset) throws Exception {
		List paraList =(List)pset.getParamMap().get("paramList");
		byte[] report=null;
		if (paraList==null){
			report = reportService.viewReport(pset);
		}else{
			report = reportService.viewMultiReport(paraList);
		}
		
		String attachstr="attachment;";
		
		OutputStream out =response.getOutputStream();
		ByteArrayInputStream fis =null;
		try{
			if (report !=null){
				response.setContentType("application/pdf");
		        response.setContentLength(report.length);
		        //response.setHeader("Content-Disposition", attachstr+" filename=\""+ java.net.URLEncoder.encode("report.pdf","UTF-8") + "\";");
				response.setHeader("Expires", "0"); 
				response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0"); 
				response.setHeader("Pragma", "public");
		        
		        fis = new ByteArrayInputStream(report);
		      
		        FileCopyUtils.copy(fis, out);
			}else{
				String errmsg ="<script>alert('오류발생')</script>";
				out.write(errmsg.getBytes());
			}
		}catch(Exception ex){
			try{
				String errmsg ="<script>alert('오류발생')</script>";
				out.write(errmsg.getBytes());
			}catch(Exception ee){}
		}finally{
			try{
				if (fis !=null) fis.close();
			}catch(Exception ee){}
			try{
				if (out !=null) {
					out.flush();
					out.close();
				}
			}catch(Exception ee){}
		}
		
	}
    
    // report 다운로드
    @RequestMapping(value = "/report_down/{sqlid}/action.do", method = RequestMethod.POST)
    public ModelAndView downloadReport (@PathVariable("sqlid") String sqlid, HttpServletRequest request, HttpServletResponse response, Locale locale, Model model)
    {
        logger.info("downloadReport Process");
        logger.info("SQL ID = [" + sqlid + "]");

        response.setCharacterEncoding("UTF-8");

        PrintWriter out = null;

        Map<String, Object> param = JsonUtil.JsonToMap(request.getParameter("param"));

        ModelAndView mav = null;
        
        try
        {
            Map<String,Object> parameterMap = new HashMap<String,Object>();

            String reportGubun = String.valueOf(param.get("reportGubun"));
            String regId       = String.valueOf(param.get("regId"));
            
            Properties prop = new Properties();
            InputStream is = getClass().getResourceAsStream("/report.properties");
            prop.load(is);
            
            String reportFileName = prop.get("report.jrxml.path")+reportGubun+".jasper";
            String destFileNamePdf = prop.get("report.down.path")+reportGubun+"_"+regId+".pdf";
            String imgPath	= String.valueOf(prop.get("report.stamp.path"));
            param.put("imgPath", imgPath);
            
            // Report 데이터 조회
            List<Object> list = reportService.getReportData(sqlid, param);
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(reportFileName, new HashMap(), new JRBeanCollectionDataSource(list));

            //Creation PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf);
            
            Map<String, Object> fileParam = new HashMap<String,Object>();
            if(param.get("preFix") != null && !param.get("preFix").equals("")){
                fileParam.put("fileName", param.get("preFix")+"_"+regId+".pdf");                
            }else{
                fileParam.put("fileName", reportGubun+"_"+regId+".pdf");
            }
            fileParam.put("fileLocation", destFileNamePdf);
            
            //mav = fileUploadService.fileDownload("sqlId", fileParam);

            if(mav == null || mav.isEmpty())
            {
                out = response.getWriter();
                out.write("<script>alert('File Download Failed.');history.go(-1);</script>");
            }
 
        }
        catch (Exception ex)
        {
            logger.error(ex.toString());
            ex.printStackTrace();
        }
        return mav;
    }
    
    //report 생성
    @RequestMapping(value = "/report/{sqlid}/action.do", method = RequestMethod.POST)
    public void createReport (@PathVariable("sqlid") String sqlid, HttpServletRequest request, HttpServletResponse response, Locale locale, Model model)
    {
        logger.info("createReport Process");
        logger.info("SQL ID = [" + sqlid + "]");

        response.setCharacterEncoding("UTF-8");

        PrintWriter out = null;

        Map<String, Object> param = JsonUtil.JsonToMap(request.getParameter("param"));

        try
        {
            Map<String,Object> parameterMap = new HashMap<String,Object>();

            String reportGubun = String.valueOf(param.get("reportGubun"));
            String sn = String.valueOf(param.get("sn"));
            
            String regId       = String.valueOf(param.get("regId"));
            
            Properties prop = new Properties();
            InputStream is = getClass().getResourceAsStream("/conf/properties/report.properties");
            prop.load(is);
            
            String reportFileName = prop.get("report.jrxml.path")+reportGubun+".jasper";
            String destFileNamePdf = prop.get("report.down.path")+reportGubun+"_"+regId+".pdf";
            String imgPath	= String.valueOf(prop.get("report.stamp.path"));
            param.put("imgPath", imgPath);
            
            //Resouce Path
            String logo_path = request.getSession().getServletContext().getRealPath("/resources")+"\\images\\common\\";
            logger.info("LOGO PATH = [" + logo_path + "]");
            param.put("companyLogo", logo_path);
            
            // Report 데이터 조회
            List<Object> list = reportService.getReportData(sqlid, param);
            
            JasperPrint jasperPrint=JasperFillManager.fillReport(reportFileName, new HashMap(), new JRBeanCollectionDataSource(list));

            //Creation PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf); 

            
            ServletOutputStream servletOutputStream = response.getOutputStream();
            File reportFile = new File(reportFileName);
            
            byte[] bytes = null;
            
             try
             {
               bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), new HashMap(), new JRBeanCollectionDataSource(list));
               
               response.setContentType("application/pdf");
               response.setContentLength(bytes.length);
          
               servletOutputStream.write(bytes, 0, bytes.length);
               servletOutputStream.flush();
               servletOutputStream.close();
             }
             catch (JRException e)
             {
               // display stack trace in the browser
               StringWriter stringWriter = new StringWriter();
               PrintWriter printWriter = new PrintWriter(stringWriter);
               e.printStackTrace(printWriter);
               response.setContentType("text/plain");
               response.getOutputStream().print(stringWriter.toString());
             } catch(Exception e)
             {
                 e.printStackTrace();
             }
            
        }
        catch (Exception ex)
        {
            logger.error(ex.toString());
        }
    }

    //Web에서 report 보기
    public void viewReportWeb(List list, String reportGubun, String regId, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        
        Properties prop = new Properties();
        InputStream is = getClass().getResourceAsStream("/conf/properties/report.properties");
        prop.load(is);
        
        String reportFileName = prop.get("report.jrxml.path")+reportGubun+".jasper";
        String destFileNamePdf = prop.get("report.down.path")+reportGubun+"_"+regId+".pdf";
        
        JasperPrint jasperPrint=JasperFillManager.fillReport(reportFileName, new HashMap(), new JRBeanCollectionDataSource(list));

        //Creation PDF file
        JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf); 

        
        ServletOutputStream servletOutputStream = response.getOutputStream();
        File reportFile = new File(reportFileName);
        
        byte[] bytes = null;
        
         try
         {
           bytes = JasperRunManager.runReportToPdf(reportFileName, new HashMap(), new JRBeanCollectionDataSource(list));
      
           response.setContentType("application/pdf");
           response.setContentLength(bytes.length);
      
           servletOutputStream.write(bytes, 0, bytes.length);
           servletOutputStream.flush();
           servletOutputStream.close();
         }
         catch (JRException e)
         {
           // display stack trace in the browser
           StringWriter stringWriter = new StringWriter();
           PrintWriter printWriter = new PrintWriter(stringWriter);
           e.printStackTrace(printWriter);
           response.setContentType("text/plain");
           response.getOutputStream().print(stringWriter.toString());
         } catch(Exception e)
         {
             throw e;
         }
    }
   
    
    //report 생성
    @RequestMapping(value = "/report/action.do", method = RequestMethod.POST)
    public void createReport (HttpServletRequest request, HttpServletResponse response, Locale locale, Model model)
    {
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> param = JsonUtil.JsonToMap(request.getParameter("param"));

        try
        {
            String reportGubun = String.valueOf(param.get("reportGubun"));
            String SN		   = String.valueOf(param.get("SN"));
            String regId       = String.valueOf(param.get("regId"));
            
            System.out.println("#####sn##########"+SN);
            System.out.println("#####param##########"+param);
            
            Properties prop = new Properties();
            InputStream is  = getClass().getResourceAsStream("/conf/properties/report.properties"); // report.properties
            Properties dbprop = new Properties(); 
            InputStream dbis = getClass().getResourceAsStream("/conf/properties/db.properties");
            prop.load(is);
            dbprop.load(dbis);
            
            String reportFileName  = prop.get("reportEdi.jrxml.path") + reportGubun + ".jasper";
            String destFileNamePdf = prop.get("reportEdi.down.path")  + reportGubun + "_" + regId + ".pdf";
            //String destFileNamePdf = prop.get("report.down.path")  + reportGubun +  ".pdf";
            String imgPath         = String.valueOf(prop.get("reportEdi.stamp.path"));
            
            param.put("imgPath", imgPath);
            param.put("SN", SN);
            Class.forName((String) dbprop.get("jdbc.driver"));  
            Connection con = DriverManager.getConnection((String) dbprop.get("jdbc.url"),(String) dbprop.get("jdbc.username"),(String) dbprop.get("jdbc.password"));
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName, param,con);
           
            // Creation PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf);  
            
            ServletOutputStream servletOutputStream = response.getOutputStream();
            
            File reportFile = new File(reportFileName);
            
            byte[] bytes = null;
            
            try
            {
                bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), param, con);
               
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
          
                servletOutputStream.write(bytes, 0, bytes.length);
                servletOutputStream.flush();
                servletOutputStream.close();
            }
            catch (JRException e)
            {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception ex)
        {
            logger.error(ex.toString());
        }
    }
    
    /**
     * 환급 신청서 발급을 출력한다.
     * @param RefundAppIssueVO - 조회할 정보가 담긴 VO
     * @exception Exception
     */
  @RequestMapping(value = "/report/action2.do", method = RequestMethod.POST)
  public void createReport2 (HttpServletRequest request, HttpServletResponse response, Locale locale, Model model)
  {
	  response.setCharacterEncoding("UTF-8");
      Map<String, Object> param = JsonUtil.JsonToMap(request.getParameter("param"));	  
      System.out.println("#####param##########"+param);

      try
      {
      String reportGubun = String.valueOf(param.get("reportGubun"));
      String SN		   = String.valueOf(param.get("SN"));
      String regId       = String.valueOf(param.get("regId"));
      
      System.out.println("#####reportGubun##########"+reportGubun);
      System.out.println("#####sn##########"+SN);
      System.out.println("#####param##########"+param);
      
      Properties prop = new Properties();
      InputStream is  = getClass().getResourceAsStream("/conf/properties/report.properties"); // report.properties
      Properties dbprop = new Properties(); 
      InputStream dbis = getClass().getResourceAsStream("/conf/properties/db.properties");
      prop.load(is);
      dbprop.load(dbis);
      
      String destFileNamePdf = prop.get("reportEdi.down.path")  + reportGubun + "_" + regId + ".pdf";

      System.out.println("#####destFileNamePdf##########"+destFileNamePdf);
      String imgPath         = String.valueOf(prop.get("reportEdi.stamp.path"));
      
      param.put("imgPath", imgPath);
      param.put("SN", SN);
      Class.forName((String) dbprop.get("jdbc.driver"));  
      Connection con = DriverManager.getConnection((String) dbprop.get("jdbc.url"),(String) dbprop.get("jdbc.username"),(String) dbprop.get("jdbc.password"));
      
      
      response.setCharacterEncoding("UTF-8");

      String reportFileName="";
      String reportFileName2="";
      	if(reportGubun.equals("EXPREQ")){
      		reportFileName = prop.get("reportEdi.jrxml.path") +"EXPREQ_830.jasper";
            reportFileName2 = prop.get("reportEdi.jrxml.path") +"EXPREQ_830_E.jasper";
      	}else if(reportGubun.equals("IMPREQ")){
            reportFileName = prop.get("reportEdi.jrxml.path") +"IMPREQ.jasper";
            reportFileName2 = prop.get("reportEdi.jrxml.path") +"IMPREQ_E.jasper";      		
      	}else if(reportGubun.equals("EXPRES_961")){
            reportFileName = prop.get("reportEdi.jrxml.path") +"EXPRES_961.jasper";
            reportFileName2 = prop.get("reportEdi.jrxml.path") +"EXPRES_961_E.jasper";      		
      	}else if(reportGubun.equals("IMPRES")){
            reportFileName = prop.get("reportEdi.jrxml.path") +"IMPRES.jasper";
            reportFileName2 = prop.get("reportEdi.jrxml.path") +"IMPRES_E.jasper";      		
      	}
      	
	      //  Report용 데이터 가져오기(갑지,을지)
	      JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName, param,con);
	      JasperPrint jasperPrint_E = JasperFillManager.fillReport(reportFileName2, param,con);
          

          List pages0 = jasperPrint_E.getPages();
          for (int j = 0; j < pages0.size(); j++) {
                JRPrintPage object = (JRPrintPage) pages0.get(j);
                  jasperPrint.addPage(object);
          }
          
	      JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf);  

          File uFile = new File(destFileNamePdf);
  		int fSize = (int) uFile.length();
   
  		if (fSize > 0) {
              //PDF파일을 보여준다.
              response.setContentType("application/pdf");
              //response.setHeader("Content-Disposition","attachment;filename="+pdfFileName);   
              BufferedInputStream bis = null;
              BufferedOutputStream bos = null;
              try{   
                   byte buffer[]     = new byte[256];
                   bis = new BufferedInputStream(new FileInputStream(uFile));
                   bos = new BufferedOutputStream(response.getOutputStream());
                   while(bis.read(buffer) != -1) {
                  	 bos.write(buffer);
                   }
                
              }catch (Exception e){                   
              }finally{
                 try{
                   if(bis != null) bis.close();
                   if(bos != null) bos.close();
                   uFile = null;
                 }
                 catch(Exception e1){
                   e1.printStackTrace();
                 }
              }                 
  		} else {
  			//setContentType을 프로젝트 환경에 맞추어 변경
  			response.setContentType("application/x-msdownload");
  			PrintWriter printwriter = response.getWriter();
  			printwriter.println("<html>");
  			printwriter.println("<br><br><br><h2>Could not get file name:<br>"
  					+ destFileNamePdf + "</h2>");
  			printwriter
  					.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
  			printwriter.println("<br><br><br>&copy; webAccess");
  			printwriter.println("</html>");
  			printwriter.flush();
  			printwriter.close();
  		}	      
                   
      }
      catch (Exception ex)
      {
          logger.error(ex.toString());
      }

  }
  
  
  //멀티로 출력진행 가능토록 추가함
  @RequestMapping(value = "/report/action3.do", method = RequestMethod.POST)
  public void createReport3 (HttpServletRequest request, HttpServletResponse response, Locale locale, Model model)
  {
      response.setCharacterEncoding("UTF-8");
      Map<String, Object> param = JsonUtil.JsonToMap(request.getParameter("param"));

      try
      {
          String reportGubun = String.valueOf(param.get("reportGubun"));
          String regId       = String.valueOf(param.get("regId"));
          
          Properties prop = new Properties();
          InputStream is  = getClass().getResourceAsStream("/conf/properties/report.properties"); // report.properties
          Properties dbprop = new Properties(); 
          InputStream dbis = getClass().getResourceAsStream("/conf/properties/db.properties");
          prop.load(is);
          dbprop.load(dbis);
          
          String reportFileName  = prop.get("reportEdi.jrxml.path") + reportGubun + ".jasper";
          String destFileNamePdf = prop.get("reportEdi.down.path")  + reportGubun + "_" + regId + ".pdf";
          String imgPath         = String.valueOf(prop.get("reportEdi.stamp.path"));          
          Class.forName((String) dbprop.get("jdbc.driver"));  
          Connection con = DriverManager.getConnection((String) dbprop.get("jdbc.url"),(String) dbprop.get("jdbc.username"),(String) dbprop.get("jdbc.password"));
          
          	
              Map<String, Object> param2 = JsonUtil.JsonToMap(param.get("SN").toString());
              JasperPrint jasperPrint = JasperFillManager.fillReport(reportFileName, new HashMap());
              // Parameter 값 체크 확인
              for (int i=0; i < param2.size(); i++){
            	  
                  String SN = param2.get(i+"").toString();
                  
                  
                  param.put("imgPath", imgPath);
                  param.put("SN", SN);
                  
                  
                  JasperPrint jasperPrint2 = JasperFillManager.fillReport(reportFileName, param,con);
                  
                  List pages0 = jasperPrint2.getPages();
                  for (int j = 0; j < pages0.size(); j++) {
                        JRPrintPage object = (JRPrintPage) pages0.get(j);
                        jasperPrint.addPage(object);
                  }
            	  
              }
         
          // Creation PDF file
          JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf);  
          
          File uFile = new File(destFileNamePdf);
    		int fSize = (int) uFile.length();
     
    		if (fSize > 0) {
                //PDF파일을 보여준다.
                response.setContentType("application/pdf");
                //response.setHeader("Content-Disposition","attachment;filename="+pdfFileName);   
                BufferedInputStream bis = null;
                BufferedOutputStream bos = null;
                try{   
                     byte buffer[]     = new byte[256];
                     bis = new BufferedInputStream(new FileInputStream(uFile));
                     bos = new BufferedOutputStream(response.getOutputStream());
                     while(bis.read(buffer) != -1) {
                    	 bos.write(buffer);
                     }
                  
                }catch (Exception e){                   
                }finally{
                   try{
                     if(bis != null) bis.close();
                     if(bos != null) bos.close();
                     uFile = null;
                   }
                   catch(Exception e1){
                     e1.printStackTrace();
                   }
                }                 
    		} else {
    			//setContentType을 프로젝트 환경에 맞추어 변경
    			response.setContentType("application/x-msdownload");
    			PrintWriter printwriter = response.getWriter();
    			printwriter.println("<html>");
    			printwriter.println("<br><br><br><h2>Could not get file name:<br>"
    					+ destFileNamePdf + "</h2>");
    			printwriter
    					.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
    			printwriter.println("<br><br><br>&copy; webAccess");
    			printwriter.println("</html>");
    			printwriter.flush();
    			printwriter.close();
    		}	    
    		
      }
      catch (Exception ex)
      {
          logger.error(ex.toString());
      }
  }  

    

}
