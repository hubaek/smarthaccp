package com.ppm.mes.domain.qc.qc400;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class QcResultBadVO  extends BaseVO {
	private String company;	
	private String slipCd;
	private Long badSeq;
	private String badCd;
	private String qcDt;	
	private String qcType;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String stockCd;
	private String whCd;
	private String lotNo;
	private String barcode;
	private BigDecimal badQty;
	private BigDecimal itemQty;
	private BigDecimal remainQty;
	private String remark;	
	private String endFlag;		
	private Long badItemSeq;
	private String regDt;	//처리일자
	private String badItemPrc; //처리구분
	private String userCd;	
	private String userNm;	
	private BigDecimal prcQty; //처리수량
}