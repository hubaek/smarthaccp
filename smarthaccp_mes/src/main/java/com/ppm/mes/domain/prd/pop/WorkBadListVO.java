package com.ppm.mes.domain.prd.pop;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class WorkBadListVO  extends BaseVO {

	private String company;
	private String badDt;
	private Long badSeq;
	private String orderNo;
	private Long  orderSeq;
	private Long  workSeq;
	private Long  routSeq;
	private String unit;
	private String wlotNo;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String itemType;
	private String badCd;
	private String badNm;
	private BigDecimal badQty;
	private String badDtm;
	
}