package com.ppm.mes.domain.rt.rt000;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class RoutManagementVO  extends BaseVO {
	
	private String company;
	private String routType;		
	private String routCd;		
	private String routNm;	
	private String outscFlag;	
	private String custCd;		
	private String custNm;		
	private String useYn;	
	private String remark;
	private String whCd;
	private String equipUseYn;
	private String qcYn;
	private Long sort;		

	private Long routManCnt;		
	private Long routEqCnt;		
	private Long routNwrkCnt;		
	private Long routBadCnt;		
	
	private String includeValue;
	private String exceptValue;	
}