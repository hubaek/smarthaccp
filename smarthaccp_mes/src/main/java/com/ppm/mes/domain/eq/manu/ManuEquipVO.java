package com.ppm.mes.domain.eq.manu;

import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class ManuEquipVO  extends BaseVO {
	
	//마스터
	private String company;
	private String equipCode;
	private String manageNo;
	private String equipName;
	private String modelName; 
	private String buyTo; 
	private String buyDt; 
	private String instDt;
	private String stnd; 
	private String operVolt;
	private String purPose;
	private String managerM;
	private String managerD; 
	private String peodInItem; 
	private String cleanDisin;

	//조회조건(날짜)
	private String strDt;
	private String endDt;
	
    protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;
}