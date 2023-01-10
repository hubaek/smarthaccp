package com.ppm.mes.domain.prd.list;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PrdEquipMonitListVO  extends BaseVO {

	private String company;
	private String orderDt;
	private String orderNo;
	
	private String routType;
	private String routCd;
	
	private String equipCd;
	private String equipNm;
	
	private String startDtm;
	private String itemCd;
	private String itemNm;
	private String partNo;

	private BigDecimal orderQty;
	private BigDecimal prodQty;
	private BigDecimal badQty;
	private BigDecimal goodQty;
	private BigDecimal prodPer;
	
	private String orderSt;
	private String orderStatusNm;

	private int startIdx;
	
}