package com.ppm.mes.domain.item.item100;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
 
@Data
public class ItemGroupMainVO extends BaseVO {
	private String company;
	private String itemMainCd;
	private String itemMainNm;
	private String itemSubCd;
	private String itemSubNm;
	private Long sort;
	private String remark;
	private String useYn;
}