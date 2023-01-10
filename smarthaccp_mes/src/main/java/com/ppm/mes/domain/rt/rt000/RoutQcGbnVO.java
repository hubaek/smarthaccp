package com.ppm.mes.domain.rt.rt000;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class RoutQcGbnVO  extends BaseVO {
	private String company; 
	private String routCd;
	private String qcGbn;
	private String qcGbnNm;
	private String remark;
	private String useYn;		
}