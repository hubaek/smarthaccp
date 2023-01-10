package com.ppm.mes.domain.pc.pc300;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PurchaseVO  extends BaseVO {

	private String company;
	private String slipType;
	private String slipCd;
	private String custCd;
	private String custNm;
	private String slipDt;
	private String userCd;
	private String userNm;
	private String whCd;
	private String surtaxYn;

	private BigDecimal sumItemQty;
	private BigDecimal sumUnitPrice;
	private BigDecimal sumSupplyPrice;
	private BigDecimal sumSurtax;
	private BigDecimal sumTotalPrice;	
	private BigDecimal totalAmt;	
	
	private String remark;  	
	
	private Long slipSeq;
	private String stockCd;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String lotNo;
	private String barcode;
	private String spec;
	private String unit;
	private String pdUnit;
	private BigDecimal pdTrans;
	private BigDecimal itemQty;
	private BigDecimal unitAmt;
	private BigDecimal supplyAmt;
	private BigDecimal surtaxAmt;
	private BigDecimal totalItemPrice;
	private String qcWay;
	private BigDecimal barcodeQty;
	private BigDecimal stockQty;
	
	private String refSlipCd;
	private Long refSlipSeq;	
	private String useYn;
	private String itemRemark;	
	
	private String remainYn;
	private BigDecimal useQty;
	private BigDecimal cancelQty;
	private BigDecimal remainQty;
	private String diffDt;
	
    protected Instant updatedAt;
    protected String updatedBy;
}