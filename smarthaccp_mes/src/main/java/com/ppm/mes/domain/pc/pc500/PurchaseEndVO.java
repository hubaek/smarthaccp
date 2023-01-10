package com.ppm.mes.domain.pc.pc500;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PurchaseEndVO  extends BaseVO {

	private String company;
	private String slipType;
	private String slipCd;
	private String custCd;
	private String custNm;
	private String slipDt;
	private String pcDt;
	private String userCd;
	private String userNm;
	private String surtaxYn;

	private BigDecimal sumItemQty;
	private BigDecimal sumUnitPrice;
	private BigDecimal sumSupplyPrice;
	private BigDecimal sumSurtax;
	private BigDecimal sumTotalPrice;	
	private BigDecimal totalAmt;	
	private String remark;  
	
	private Long slipSeq;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String whCd;
	private String lotNo;
	private String barcode;
	private String spec;
	private String unit;

	private BigDecimal itemQty;
	private BigDecimal unitAmt;
	private BigDecimal supplyAmt;
	private BigDecimal surtaxAmt;
	private BigDecimal totalItemPrice;
	
	private String refSlipCd;
	private Long refSlipSeq;
	
    protected String useYn;
	private String itemRemark;	
	
    protected Instant updatedAt;
    protected String updatedBy;
}