package com.ppm.mes.domain.qc.qc200;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class QcItemTargetVO  extends BaseVO {
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
	private String remark;
	private String routCd;
	private Long qcCount;	
	private Long qcDocId;	
}