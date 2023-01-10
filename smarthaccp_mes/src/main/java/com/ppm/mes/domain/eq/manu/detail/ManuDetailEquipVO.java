package com.ppm.mes.domain.eq.manu.detail;

import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class ManuDetailEquipVO  extends BaseVO {
	
	//디테일
	private String company;
	private String equipCode;
	private String manageNo;
	private String inspectionDate;
	private String breakDown;
	private String firstAid;
	private String repairHistory;
	private String confirmY;
	private String confirmN;
	private String seq;
	private String confirm;
    protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;
}