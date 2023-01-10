package com.ppm.mes.domain.rt.rt000;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;


//공정별 품목 상세
@Data
public class RoutingItemDetailVO  extends BaseVO {	
	private String company; 
	private String whCd;
	private String routingCd;
	private String routingNm;
	private String routType;	
	private String itemCd;
	private String routCd;
	private String equipCd;	
	private Long regSeq;		
	private Long routSeq;	
	private String lastFlag;
	private String remark;
	private String useYn;		
	private String equipUseYn;
	private String qcYn;
	private String outscFlag;	
}