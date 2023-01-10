package com.ppm.mes.domain.pc.pc200;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PurchaseOrderVO  extends BaseVO {
	private String company;
	private String slipType;
	private String slipCd;
	private String custCd;
	private String custNm;
	private String slipDt;
	private String userCd;
	private String userNm;
	private String requestDt;
	private String dueDt;
	private String surtaxYn;
	private String whCd;
	private String remark;  

	private BigDecimal sumItemQty;
	private BigDecimal sumUnitPrice;
	private BigDecimal sumSupplyPrice;
	private BigDecimal sumSurtax;
	private BigDecimal sumTotalPrice;	
	private BigDecimal totalAmt;	
	
	private Long slipSeq;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String spec;
	private String unit;
	private String pdUnit;
	private BigDecimal pdTrans;
	private BigDecimal itemQty;
	private BigDecimal unitAmt;
	private BigDecimal supplyAmt;
	private BigDecimal surtaxAmt;
	private BigDecimal totalItemPrice;
	private String itemRemark;  
	
	private String refSlipCd;
	private Long refSlipSeq;

	private String remainYn;
	private BigDecimal useQty;
	private BigDecimal remainQty;
	private String diffDt;
	
	private String useYn;
	
	private BigDecimal endQty;
	
    protected Instant updatedAt;
    protected String updatedBy;

}