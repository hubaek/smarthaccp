package com.ppm.mes.domain.wh.wh000;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class WarehouseMasterVO  extends BaseVO {
	private String company;
	private String whCd;
	private String whNm;
	private String whType;	
	private String custCd;
	private String custNm;
	private String remark;
	private String useYn;		
	private Long sort;	
}