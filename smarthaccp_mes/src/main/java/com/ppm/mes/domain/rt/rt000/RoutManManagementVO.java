package com.ppm.mes.domain.rt.rt000;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class RoutManManagementVO  extends BaseVO {	
	private String company; 
	private String equipUseYn;
	private String qcYn;
	private String whCd;
	private String routType;
	private String routCd;
	private String userCd;
	private String userNm;
	private String useYn;		
}