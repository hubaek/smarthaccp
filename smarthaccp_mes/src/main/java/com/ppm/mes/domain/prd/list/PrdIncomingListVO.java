package com.ppm.mes.domain.prd.list;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PrdIncomingListVO  extends BaseVO {
	private String company;
	private String wlotNo;
	private String orderNo;
	private String orderDt;
	private Long orderSeq;
	private String routingCd;
	private String routingNm;
	private String routType;
	private String routCd;
	private String equipCd;
	private String refEquipCd;
	private String orderSt;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String spec;
	private String unit;
	private String whCd;
	private String stockCd;
	private String lotNo;
	private String barcode;
	private Long woSeq;
	private BigDecimal itemQty;
    protected Instant updatedAt;
    protected String updatedBy;
}