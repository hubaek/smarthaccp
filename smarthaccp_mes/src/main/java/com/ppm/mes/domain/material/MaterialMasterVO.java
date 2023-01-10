package com.ppm.mes.domain.material;

import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class MaterialMasterVO  extends BaseVO{
	
	private String company;
	private String inDate;
	private String itemType;
	private String nncDtl;
	private String impMsr;
	private String wrtId;
	private String revId;
	private String aprId;
	private String status;
	private String userNm;
	
	//조회조건(날짜)
	private String strDt;
	private String endDt;
	
	protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;
}
