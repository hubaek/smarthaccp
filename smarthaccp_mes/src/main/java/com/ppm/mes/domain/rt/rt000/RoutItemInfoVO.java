package com.ppm.mes.domain.rt.rt000;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class RoutItemInfoVO  extends BaseVO {
	private String company; 
	private String itemCd;
	private String itemNm;
	private String itemType;
	private String itemMainNm;
	private String itemSubNm;
	private String spec;
	private String unit;
	private String partNo;
	private String routingCd;
	private String routingNm;
	private Long routSeq;	
	private String equipCd;
	private String routType;
	private String routCd;
	private Long cycleTime;
	private Long cavity;	
	private BigDecimal routUnitAmt;
	private String remark;
	private String useYn;	
	
	private BigDecimal stVal;
	private BigDecimal inCnt;
	private BigDecimal woHr;
	private BigDecimal opRate;
	private BigDecimal capaVal;
	
}