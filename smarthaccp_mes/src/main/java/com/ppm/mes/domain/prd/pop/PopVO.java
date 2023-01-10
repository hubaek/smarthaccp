package com.ppm.mes.domain.prd.pop;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class PopVO  extends BaseVO {
	private String barcode;
	private int cnt;	
}