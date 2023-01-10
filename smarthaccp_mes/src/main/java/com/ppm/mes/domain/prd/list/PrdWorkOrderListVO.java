package com.ppm.mes.domain.prd.list;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PrdWorkOrderListVO  extends BaseVO {

	private String company;
	private String orderDt;
	private String orderNo;
	private Long  orderSeq;
	private Long  workSeq;
	private String routingCd;
	private String routingNm;
	private String routType;
	private String  routCd;
	private String  outscFlag;
	private String  equipCd;
	private String refEquipCd;
	private Long  routSeq;
	private String  orderSt;
	private BigDecimal orderQty;
	private BigDecimal  prodQty;
	private BigDecimal  goodQty;
	private BigDecimal  badQty;
	private BigDecimal  barcodeQty;
	private BigDecimal  barcodeCount;
	private BigDecimal  badPer;
	private BigDecimal  orderPer;
	private String wlotNo;
	private String  itemCd;
	private String  itemNm;
	private String partNo;
	private String spec;
	private String  unit;
	private Instant  createdTime;

	private String stockCd;	
	private String  lotNo;
	private String  barcode;	

	private String  whCd;
	private String  whNm;

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
    
    private String nwrkDt;
    private String nwrkTm;
    private Instant nwrkDtm;

	private String nwrkCd;
	private String nwrkNm;

	private String outYn;
	private String routQcYn;
	private String lastFlag;
	private String parentWlotNo;
	private int endOrderCount;
	private String scheduleDt;
	private String planDt;
	private String planItemCd;
}