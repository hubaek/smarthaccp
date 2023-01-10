package com.ppm.mes.domain.prd.pop;

import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class RoutStockListVO  extends BaseVO {
	private String company;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String whCd;
	private String unit;
	private String wlotNo;
	private String lotNo;
	private String barcode;
	private Long inQty;
	private Long stockQty;
	private String orderDt;
	private String orderNo;
	private Long orderSeq;
	private Long workSeq;
	private Long routSeq;
	private String orderSt;
	private String routCd;
	private String routNm;
	private String equipCd;
	
	private Long orderQty;
	private Long prodQty;
	private Long badQty;
	private Long goodQty;
	
    protected Instant updatedAt;
    protected String updatedBy;
}