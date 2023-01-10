package com.ppm.mes.domain.prd.list;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PrdMoveListVO  extends BaseVO {

	private String stockCd;
	private String refStockCd;
	
	private String company;
	private String moveDt;
	private Long moveSeq;
	
	private String orderDt;
	private String orderNo;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String spec;
	private String unit;
	
	private String refWlotNo;
	private String refRoutCd;
	private String refWhCd;
	private String refLotNo;
	private String refBarcode;

	private String wlotNo;
	private String routCd;
	private String whCd;
	private String lotNo;
	private String barcode;
	
	private BigDecimal itemQty;
    protected Instant updatedAt;
    protected String updatedBy;
}