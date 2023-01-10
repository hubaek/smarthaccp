package com.ppm.mes.domain.prd.list;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PrdOrderOutgoingListVO  extends BaseVO {
	private String company;
	private String orderDt;
	private String orderNo;
	private Long orderSeq;
	private Long workSeq;
	private Long routSeq;
	private String orderSt;
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
	private String unit;
	private String stockCd;
	private String lotNo;
	private String barcode;
	private String wlotNo;
	private String whCd;
	private String toWarehouse;
	private String outscFlag;

	private BigDecimal orderQty;
	private BigDecimal prodQty;
	private BigDecimal badQty;
	private BigDecimal goodQty;
	
	private BigDecimal itemQty;
	private BigDecimal remainQty;
	private BigDecimal consumQty;

	private BigDecimal transItemQty;
	private BigDecimal transConsumQty;
	private BigDecimal transRemainQty;
	private BigDecimal transPreItemQty;
	
	private String discardYn;
	private String discardType;
	
	private Long woSeq;
	private BigDecimal bomItemQty;
	private BigDecimal bomTrans;
	private String bomUnit;
	
    protected Instant updatedAt;
    protected String updatedBy;
}