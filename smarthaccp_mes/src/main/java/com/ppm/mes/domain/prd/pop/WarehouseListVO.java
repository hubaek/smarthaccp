package com.ppm.mes.domain.prd.pop;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class WarehouseListVO  extends BaseVO {

	private String  company;
	private String whCd;
	private String whNm;
	private String whType;
	private String routCd;
	private String routNm;
	
}