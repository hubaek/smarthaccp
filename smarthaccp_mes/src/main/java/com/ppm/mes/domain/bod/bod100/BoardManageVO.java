package com.ppm.mes.domain.bod.bod100;

import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
 
@Data
public class BoardManageVO extends BaseVO {
	private String company;
	private String boardType;
    private String boardCd;   
	private String boardTitle;
    private String boardText;
	private String regDt;
	private String userCd;
	private String userNm;
	private String mailYn;	
	private String tempFileCd;		
	private Long viewCnt;		
	private String useYn;		
    protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;
}