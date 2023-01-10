package com.ppm.mes.domain.prd.pop;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class DiscardTypeListVO  extends BaseVO {

	private String company;
	private String discardType;
	private String discardTypeNm;
	
}