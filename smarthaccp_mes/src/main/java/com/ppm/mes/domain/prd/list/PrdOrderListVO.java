package com.ppm.mes.domain.prd.list;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PrdOrderListVO  extends BaseVO {

	private String company;
	private String orderDt;
	private String orderNo;
	private Long orderSeq;
	private Long workSeq;
	private Long routSeq;
	private String whCd;
	private String routingCd;
	private String routingNm;
	private String routType;
	private String routCd;
	private String equipCd;
	private String refEquipCd;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String spec;

	private BigDecimal itemQty;
	private BigDecimal orderQty;
	private BigDecimal prodQty;
	private BigDecimal badQty;
	private BigDecimal goodQty;
	private BigDecimal  badPer;
	private BigDecimal  orderPer;

	private BigDecimal prodPrice;
	private BigDecimal goodPrice;
	private BigDecimal badPrice;

	private String wlotNo;
	private String stockCd;	
	private String lotNo;
	private String barcode;
	private String orderSt;
    
	private Long cycleTime;
	private Long cavity;
	private Long routUnitAmt;

	private Long jobTm;
	private Long stdTm;
	private Long nwrkTm;
	private Long planNwrkTm;
	private Long uph;
	
	private BigDecimal ggPercent;
	private BigDecimal ppPercent;
	private BigDecimal yyPercent;
	private BigDecimal ttPercent;

	private String startDt;
	private String startHour;
	private String startMinute;
	private String startSecond;
	private Instant startDtm;
	private String endDt;
	private String endHour;
	private String endMinute;
	private String endSecond;
	private Instant endDtm;

	private String outYn;
	private String routQcYn;
	private BigDecimal hourQty;
	
}