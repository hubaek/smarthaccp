package com.ppm.mes.domain.bom.bom000;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class BomMasterVO  extends BaseVO {
	
	private String company;
	private String itemCd;
	private String itemNm;
	private Long revisionNo;
	private String lastYn;
	private String partNo;
	private String itemType;
	
	private String itemMainCd;
	private String itemMainNm;
	private String itemSubCd;
	private String itemSubNm;
	
	private String supportType;
	private String spec;

	private String unit;
	private String bomUnit;	
	private BigDecimal bomTrans;
	private String yieldUnit;	
	private BigDecimal yieldTrans;
	private String pdUnit;
	private BigDecimal pdTrans;
	private String slUnit;
	private BigDecimal slTrans;
	
	private BigDecimal saAmt;
	private BigDecimal pcAmt;
	private BigDecimal stdCost;
	private BigDecimal realCost;
	private String barcode;
	private String qcWay;
	private BigDecimal safetyQty;
	private BigDecimal lowPurchaseQty;
	private String custCd;	
	private String custNm;	
	private String lotYn;
	private BigDecimal lotQty;
	private BigDecimal barcodeQty;
	private String whCd;
	private Long leadTime;	
	private String setYn;	
	private Long thickness;	
	private Long horizontal;	
	private Long vertical;		
	private Long loss;		
	private String useYn;	
	private String remark;	
	private String stockYn;
	private String routingCd;
	private String routingNm;
	private String routCd;
	private String routNm;

	private BigDecimal stockQty;

	private String routType;
	private String equipUseYn;
	private String qcYn;
	private String lastFlag;
	private Long routSeq;	

	private String qcGroupCd;
	private Long bomCnt;	
	
	private String parentItemCd;
	private String parentItemNm;
	private String parentSpec;
	private String parentUnitNm;
	private String unitNm;
	private String bomQty;
	
}