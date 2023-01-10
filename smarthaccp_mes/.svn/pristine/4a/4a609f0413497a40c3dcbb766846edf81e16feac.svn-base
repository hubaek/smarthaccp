package com.ppm.mes.domain.file;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
public class UploadParameters {
    private File file;

    private MultipartFile multipartFile;

    private String targetType;

    private String targetId;

    private String targetId2;

    private String targetId3;
    
    private String tempYn;
    
    private int sort;

    private String desc;

    private boolean deleteIfExist;

    private boolean thumbnail = true;

	private int thumbnailWidth = 640;

    private int thumbnailHeight = 640;

	public void setTargetId(String targetId) {
		this.targetId = setdatetostr(targetId);
	}

    //yyyy-mm-dd format -> yyyymmdd format
    private String setdatetostr(String targetId){
    	//데이터가 날짜 형식인지 체크
    	if(isDate(targetId)){
    		targetId = targetId.replaceAll("-", "");
    	}
    	return targetId;
    }
    
    //yyyy-mm-dd 패턴인지 체크
    public static boolean isDate(String date){
    	String pattern = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
    	return date.matches(pattern);
    }
}
