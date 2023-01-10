package com.ppm.mes.domain.prd.list;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PrdOrderBadVO  extends BaseVO {

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
	private String unit;	
	private Long orderQty;
	private Long prodQty;
	private Long badQty;
	private Long goodQty;
	private String wlotNo;
	private String orderSt;

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
	
	private String badDt;
	private String badHour;
	private String badMinute;
	private String badSecond;
	private Instant badDtm;
	
	private String badSeq;
	private String badCd;
	private String badNm;
	private BigDecimal badItemQty;
	private String stockDt;
	private String lotNo;
	private String barcode;
	private String outscFlag;
}