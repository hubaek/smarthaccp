package com.ppm.mes.domain.haccp.itemCheck;

import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;



@Data
public class ItemCheckMasterVO  extends BaseVO{
	
	private String company; 
	private String inspectionYm; 
	private String status; 
	private String writer; 
	private String approver; 
	private String remark;

	//조회조건(날짜)
	private String strMon;
	private String endMon;
	
	protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;

}
