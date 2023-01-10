package com.ppm.mes.domain.rt.rt100;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class RoutingMasterVO  extends BaseVO {
	private String company;
	private String routingCd;
	private String routingNm;
	private String useYn;	
}