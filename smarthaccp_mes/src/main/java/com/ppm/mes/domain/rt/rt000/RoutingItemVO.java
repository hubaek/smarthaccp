package com.ppm.mes.domain.rt.rt000;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

//공정별 품목
@Data
public class RoutingItemVO  extends BaseVO {
	private String company;
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String itemType;
	
	private String itemMainCd;
	private String itemMainNm;
	private String itemSubCd;
	private String itemSubNm;
	
	private String spec;
	private String unit;
	private String useYn;
	private String routingCd;
}