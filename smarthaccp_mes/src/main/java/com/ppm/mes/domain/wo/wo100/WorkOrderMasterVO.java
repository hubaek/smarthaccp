package com.ppm.mes.domain.wo.wo100;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class WorkOrderMasterVO  extends BaseVO {
	private String company; 
	private String orderNo;
	private Long orderSeq;
	private Long routSeq;	
	private Long workSeq;
	private String routingCd;
	private String routingNm;
	private String whCd;
	private String equipCd;
	private String equipNm;
	private String refEquipCd;
	private String refEquipNm;
	private String routType;
	private String equipUseYn;
	private String qcYn;
	private String routCd;
	private String outscFlag;	
	private String orderSt;
	private String orderDt;	
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String unit;
	private String spec;
	private BigDecimal orderQty;
	private BigDecimal prodQty;
	private BigDecimal badQty;
	private BigDecimal goodQty;
	private String wlotNo;	
	private String stockCd;	
	private String lotNo;	
	private String barcode;	
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
	private String parentWlotNo;	
	private BigDecimal liquidA;
	private BigDecimal liquidB;
	private String lastFlag;	
	private String tempOrderNo;
	private BigDecimal sort;
	private String scheduleDt;
	private String planDt;
	private String planItemCd;
}