package com.ppm.mes.component;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
 

@Data
@NoArgsConstructor
public class MakingBodyVO extends BaseVO {
	private String cellValue;
	private String cellStyle;
	

	
	public static MakingBodyVO of(String cellValue,String cellStyle) {
		MakingBodyVO body = new MakingBodyVO();
		body.setCellValue(cellValue);
		body.setCellStyle(cellStyle);
        return body;
    }
	
}