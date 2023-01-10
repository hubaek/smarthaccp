package com.ppm.mes.domain.material.Detail;

import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class MaterialsDetailVO  extends BaseVO{
	
	private String company; 
	private String inDate;
	private String inSeq;
	private String itemType;
	private String prdcName; 
	private String rcvnQntt;
	private String pckStt;
	private String dspItm;
	private String spcfStt;
	private String vhcHyg; 
	private String pstInfStt;
	private String pltStt; 
	private String rprStt; 
	private String mnfcDt;
	private String lot;
	private String jdgmPr; 
	private String checked;
	private String remark;
	
	private String checkedY;
	private String checkedN;   
	private String pstInfSttY; 
	private String pstInfSttN;
	private String jdgmPrY; 
	private String jdgmPrN;
	
	
	protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;
}
