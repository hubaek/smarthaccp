package com.ppm.mes.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.sa.sa300.Order;
import com.ppm.mes.domain.sa.sa300.OrderService;
import com.ppm.mes.domain.sa.sa300.OrderVO;
import com.ppm.mes.domain.sa.sa310.OrderDetail;
import com.ppm.mes.domain.sa.sa310.OrderDetailService;
import com.ppm.mes.report.ReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/*
 * 수주관리
 */
@Controller
@RequestMapping(value = "/api/v1/order")	//수주
public class SalesOrderController extends BaseController {

    @Inject private OrderService orderService;
    @Inject private OrderDetailService orderDetailService;
    @Inject private ReportService reportService;
    
    @Value("${axboot.dataSource.driverClassName}")
    private String dataSourceDriverClassName;
    
    @Value("${axboot.dataSource.url}")
    private String dataSourceUrl;
    
    @Value("${axboot.dataSource.username}")
    private String dataSourceUsername;
    
    @Value("${axboot.dataSource.password}")
    private String dataSourcePassword;
    
   	@RequestMapping(value = "header", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse vo(RequestParams<OrderVO> vo) {   		
   		List<OrderVO> list = orderService.header(vo);
   		//UserLogUtil.saveUserLog("SalesOrderController","Sales Order","GET");
   		return Responses.ListResponse.of(list);
   	}
   	
	// 품목별 견적현황
	@RequestMapping(value = "itemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemList(RequestParams<OrderVO> vo) {
		List<OrderVO> list = orderService.itemDetail(vo);
		return Responses.ListResponse.of(list);
	}
		
    //임시저장,확정
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public Order save(@RequestBody Order request) {
    	//UserLogUtil.saveUserLog("SalesOrderController","Sales Order","PUT");
    	return orderService.saveForm(request);
    }

    //삭제
    @RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody Order t) {    			
    	//UserLogUtil.saveUserLog("SalesOrderController","Sales Order","DELETE");
    	orderDetailService.deleteAll(t);
    	return ok();
    }    

    //마감 or 마감취소
    @RequestMapping(value="saveDetail", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveDetail(@RequestBody List<OrderDetail> list) {
    	orderDetailService.save(list);
    	return ok();
    } 
    
    @RequestMapping(value = "excelDataDownLoad", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse excelDataDownLoad(RequestParams<OrderVO> vo) {   		
   		List<OrderVO> list = orderService.excelDataDownLoad(vo);
   		//UserLogUtil.saveUserLog("SalesOrderController","Excel Data DownLoad","GET");
   		return Responses.ListResponse.of(list);
   	}
    
    @RequestMapping(value = "transactionDownLoad", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public void transactionDownLoad(RequestParams<OrderVO> vo, HttpServletRequest request, HttpServletResponse response) throws Exception {   		
    	//List<OrderVO> list = orderService.excelDataDownLoad(vo);
   		Connection conn = null;
   		Properties prop = reportService.getReportProperties();

   	    String filePath  = String.valueOf(prop.get("report.jrxml.path"));
        String pdfFilePath  = String.valueOf(prop.get("report.pdf.path"));
        
   		try {
   			Class.forName(dataSourceDriverClassName);
			conn = DriverManager.getConnection(dataSourceUrl,dataSourceUsername,dataSourcePassword);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
   		System.out.println("filePath : "+filePath);

        String outfilename = pdfFilePath;
        JasperReport jasperReport;
		try {
			jasperReport = JasperCompileManager.compileReport(filePath);
		
        HashMap<String, Object> parameterts = new HashMap<String, Object>();
        parameterts.put("slipcd", vo.getString("slipCd"));
        parameterts.put("report_path", String.valueOf(prop.get("report.jrxml.path")));

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameterts, conn);
        // PDF 출력<font></font>
        /*
        //Deprecated : jasper : <version>5.1.0</version>
        JRExporter ex = new JRPdfExporter();
        ex.setParameter(JRPdfExporterParameter.IS_COMPRESSED, true);
        ex.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outfilename);
        ex.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        ex.exportReport();
        */
        
        
        //jasper : <version>6.17.0</version>
        JRPdfExporter ex = new JRPdfExporter();
        ex.setExporterInput(new SimpleExporterInput(jasperPrint));
        ex.setExporterOutput(new SimpleOutputStreamExporterOutput(outfilename));
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCompressed(true);
        ex.setConfiguration(configuration);
        ex.exportReport();
        
        
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File reportFile = new File(outfilename);
		String attachstr="attachment;";
		String fileName = vo.getString("custNm")+".pdf";
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(reportFile));

			
			response.setHeader("Content-Disposition", attachstr+" filename=\""+ java.net.URLEncoder.encode(fileName,"UTF-8") + "\";");
			response.setContentType("application/pdf");
			response.setContentLength((int)reportFile.length());
			
			FileCopyUtils.copy(bis, response.getOutputStream());
			bis.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			//e.printStackTrace();
		}
   	}
}