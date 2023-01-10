package com.ppm.mes.domain.prd.pop;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class WorkOutgoingListVO  extends BaseVO {

	private String company;
	private String orderNo;
	private Long  orderSeq;
	private Long  workSeq;
	private Long  routSeq;
	private Long  woSeq;

	private String  stockCd;
	private String  itemCd;
	private String  itemNm;
	private String partNo;
	private String  itemType;
	private String  spec;
	private String  unit;
	private String  bomUnit;
	private BigDecimal bomTrans;
	private String  lotNo;
	private String  barcode;

	private BigDecimal bomItemQty;
	private BigDecimal itemQty;
	private BigDecimal remainQty;
	private BigDecimal consumQty;
	private BigDecimal preItemQty;
	private BigDecimal compareQty;	

	private BigDecimal transItemQty;
	private BigDecimal transConsumQty;
	private BigDecimal transRemainQty;
	private BigDecimal transPreItemQty;
	
	private String discardYn;
	private String discardType;
	
	private String  whCd;
	private String  toWarehouse;
	private String  wlotNo;

	private String outCheck;
	private String  outCheckRemark;

    protected Instant updatedAt;
    protected String updatedBy;
}