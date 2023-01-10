package com.ppm.mes.domain.pr.pr100;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PcPriceVO   extends BaseVO {
	private String company;
	private String itemType;
	private String itemMasterGroup;
	private String itemGroup;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String custCd;
	private String custNm;
	private String regDt;
	private BigDecimal pcPrice;
	private BigDecimal unitPrice;
	private String useYn;
 
}