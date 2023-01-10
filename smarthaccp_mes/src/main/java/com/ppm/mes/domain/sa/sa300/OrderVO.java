package com.ppm.mes.domain.sa.sa300;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class OrderVO  extends BaseVO {

	private String company;
	private String saOrderType;	
	private String slipType;
	private String slipCd;
	private String custCd;
	private String custNm;
	private String slipDt;
	private String saOrderDt;
	private String saDeliveryDt;	
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
	private String spec;
	private String unit;
	
	private String diffDt;
	private BigDecimal itemQty;
	private BigDecimal unitAmt;
	private BigDecimal supplyAmt;
	private BigDecimal surtaxAmt;
	private BigDecimal totalItemPrice;
	
	private String refSlipCd;
	private Long refSlipSeq;
	
	private String activeFlag;
	private String useYn;
	private String endYn;
	private String itemRemark;	
	private String endRemark;	

	private String remainYn;
	private BigDecimal useQty;
	private BigDecimal remainQty;

	private String remainYn2;
	private BigDecimal useQty2;
	private BigDecimal remainQty2;
	private BigDecimal endQty;

	private String orderNo;
	
    protected Instant updatedAt;
    protected String updatedBy;
    
    private String addressee;
    private String contactAddress1;
    private String contactAddress2;
    private String postcode;
    private String address;
    private String msg;
    private String shippingCharge;
    
    private String companyNm;
    private String companyTel;
    private String companyAddress;
    private String custTel;
    private String custAddress;
}