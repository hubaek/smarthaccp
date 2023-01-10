package com.ppm.mes.domain.haccp.check;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
 
@Data
public class HaccpCheckVO extends BaseVO {

	private String company;	
	private String mainCode;	 
	private String subCode; 
	private String subName; 
	private String checkType; 
	private String inspectionDate; 
	private String inspectionResult;
	private String remark1;
	private String remark2; 
	private BigDecimal drafter; 
	private String approver; 
	private String status; 
 
}