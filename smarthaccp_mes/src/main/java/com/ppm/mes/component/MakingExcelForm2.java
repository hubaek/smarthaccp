package com.ppm.mes.component;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class MakingExcelForm2 extends AbstractExcelView {
	  
    @Override
	@SuppressWarnings("unchecked")
    protected void buildExcelDocument(Map<String, Object> model,
        HSSFWorkbook workbook,
        HttpServletRequest request,
        HttpServletResponse response) {
     
        String sheetName = (String)model.get("sheetname");

        List<String> titles = (List<String>)model.get("titles");
        List<MakingBandVO> bandList = (List<MakingBandVO>)model.get("bandList");
        List<String> headers = (List<String>)model.get("headers");
        List<List<MakingBodyVO>> bodyList = (List<List<MakingBodyVO>>)model.get("body");

        HSSFSheet sheet = workbook.createSheet(sheetName); // create sheet
        sheet.setDefaultColumnWidth((short) 12);
        
        HSSFFont defaultFont = workbook.createFont();        
        defaultFont.setFontHeightInPoints((short) 11); 
        defaultFont.setFontName("맑은 고딕");
        
        int currentRow = 0;
        int currentColumn = 0;
        
        HSSFCellStyle titleStyle = workbook.createCellStyle(); //title style
        HSSFFont titleFont = workbook.createFont();
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        titleStyle.setFont(titleFont); 
        
        HSSFCellStyle headerStyle = workbook.createCellStyle(); //header style
        headerStyle.setAlignment(CellStyle.ALIGN_CENTER); 
        headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); 
        headerStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index); 
        headerStyle.setBorderBottom(CellStyle.BORDER_THIN); 
        headerStyle.setBorderLeft(CellStyle.BORDER_THIN); 
        headerStyle.setBorderRight(CellStyle.BORDER_THIN); 
        headerStyle.setBorderTop(CellStyle.BORDER_THIN); 
        headerStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); 
        headerStyle.setWrapText(true);
        headerStyle.setFont(defaultFont);
        
        //본문 스타일 
        HSSFCellStyle BodyStyle = workbook.createCellStyle(); 
        BodyStyle.setAlignment(CellStyle.ALIGN_LEFT); 
        BodyStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); 
        BodyStyle.setBorderBottom(CellStyle.BORDER_THIN); 
        BodyStyle.setBorderLeft(CellStyle.BORDER_THIN); 
        BodyStyle.setBorderRight(CellStyle.BORDER_THIN); 
        BodyStyle.setBorderTop(CellStyle.BORDER_THIN); 
        BodyStyle.setFont(defaultFont);   

        HSSFCellStyle BodyNoStyle = workbook.createCellStyle(); 
        BodyNoStyle.setAlignment(CellStyle.ALIGN_LEFT); 
        BodyNoStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); 
        BodyNoStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index); 
        BodyNoStyle.setBorderBottom(CellStyle.BORDER_THIN); 
        BodyNoStyle.setBorderLeft(CellStyle.BORDER_THIN); 
        BodyNoStyle.setBorderRight(CellStyle.BORDER_THIN); 
        BodyNoStyle.setBorderTop(CellStyle.BORDER_THIN); 
        BodyNoStyle.setFillPattern(CellStyle.SOLID_FOREGROUND); 
        BodyNoStyle.setFont(defaultFont);

        HSSFRow titleRow = sheet.createRow(currentRow); // create title row
        for(String title: titles){
            HSSFRichTextString text = new HSSFRichTextString(title);
            HSSFCell cell = titleRow.createCell(currentColumn); 
            cell.setCellStyle(headerStyle);
            cell.setCellValue(text);            
            currentColumn++;
        }
        
        currentRow++;
        HSSFRow headerRow = sheet.createRow(currentRow); // create header row
        currentColumn = 0;
        for(String header: headers){
            HSSFRichTextString text = new HSSFRichTextString(header);
            HSSFCell cell = headerRow.createCell(currentColumn); 
            cell.setCellStyle(headerStyle);
            cell.setCellValue(text);            
            currentColumn++;
        }
       
        currentRow++;
        for(List<MakingBodyVO> body: bodyList){
            currentColumn = 0;
            HSSFRow row = sheet.createRow(currentRow); // create body row
            for(MakingBodyVO value : body){
            	
            	
            	if(null == value.getCellValue()){
            		value.setCellValue("");
            	}else if(value.getCellValue().equals("null")){
            		value.setCellValue("");
            	}

            	if(null == value.getCellStyle()){
            		value.setCellStyle("N");
            	}else if(value.getCellStyle().equals("null")){
            		value.setCellStyle("N");
            	}
            	
                HSSFCell cell = row.createCell(currentColumn);
                
                if(value.getCellStyle().equals("N")){
                	cell.setCellStyle(BodyNoStyle);
                }else if(value.getCellStyle().equals("Y")){
                	cell.setCellStyle(BodyStyle);
                }
                
		        HSSFRichTextString text = new HSSFRichTextString(value.getCellValue());                
		        cell.setCellValue(text);
                currentColumn++;
            }
            currentRow++;
        }

		 if (null!=bandList) {  		
		    for (MakingBandVO band : bandList) {    
		        sheet.addMergedRegion(new CellRangeAddress(band.getStartRow(),band.getEndRow(),band.getStartCell(),band.getEndCell()));
		    }
		 }
    }
}