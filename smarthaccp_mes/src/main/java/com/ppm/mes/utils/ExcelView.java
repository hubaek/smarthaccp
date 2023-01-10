package com.ppm.mes.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView {

    
	private static final String sample = "/template/SA050.xlsx"; // 클래스패스에 있는 Resource 경로 
	
    @Override
	@SuppressWarnings("unchecked")
    protected void buildExcelDocument(Map<String, Object> model,
        HSSFWorkbook workbook,
        HttpServletRequest request,
        HttpServletResponse response) {
		
		OutputStream os = null;
		InputStream is = null;
		
		try {
			
			is = new ClassPathResource(sample).getInputStream();		
	        String savePath = model.get("savePath").toString();
	        String fileNm = model.get("fileNm").toString();
	        
	        File xlsxFile = new File(savePath);       
			os = new FileOutputStream(xlsxFile);

			StringBuffer contentDisposition = new StringBuffer();
			contentDisposition.append("attachment;fileNm=\"");
			contentDisposition.append(java.net.URLEncoder.encode(fileNm + ".xlsx","UTF-8"));
			contentDisposition.append("\";");
			response.setHeader("Content-Disposition", contentDisposition.toString());
			response.setContentType("application/x-msexcel");
			os = response.getOutputStream();

			Context context = PoiTransformer.createInitialContext();
			
			//데이터부.
			context.putVar("DATA_HEADER", model.get("DATA_HEADER"));
			context.putVar("DATA_DETAIL", model.get("DATA_DETAIL"));
			
			JxlsHelper.getInstance().setUseFastFormulaProcessor(false).processTemplate(is, os, context);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    /*
     * ///*		String[] array= new String[datalist.size()];
//		InputStream imageInputStream;
//		byte[] imageBytes;
//		InputStream imageInputStreamChief;
//		byte[] imageBytesChief;
//
//		//팀장사인 이미지
//		imageInputStreamChief = new FileInputStream(datalist.get(0).get("FILEPATHNAME").toString());
//		imageBytesChief = Util.toByteArray(imageInputStreamChief);
//
//		for(int i=0; i<datalist.size(); i++) {
//			array[i] = (String) datalist.get(i).get("MEMBERNAME").toString();
//			//담당 서명 이미지 셋팅
//			imageInputStream = new FileInputStream(datalist.get(i).get("FILEPATHNAME").toString());
//			imageBytes = Util.toByteArray(imageInputStream);
//	        datalist.get(i).setMap("image", imageBytes);
//	        //팀장 서명 이미지 셋팅
//	        datalist.get(i).setMap("imageChief", imageBytesChief);
//		}*/
     
    
}


