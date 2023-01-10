package com.ppm.mes.domain.prd.pop;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class NwrkTypeListVO  extends BaseVO {
	private String company;
	private String qcType;
	private String routType;
	private String routCd;
	private String nwrkCd;
	private String nwrkNm;
}