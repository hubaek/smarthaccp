package com.ppm.mes.domain.eq.eq000;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class EquipMasterVO  extends BaseVO {
	private String company;
	private String equipCd;
	private String equipNm;
	private String routType;
	private String routCd;
	private String equipType;
	private String equipSpec;
	private String equipMaker;	
	private String modelNm;		
	private String custCd;
	private String custNm;
	private String purchaseDt;
	private BigDecimal pcAmt;
	private String remark;
	private String useYn;
	private BigDecimal option1;
	private BigDecimal option2;
	private BigDecimal option3;
	private BigDecimal option4;

	private String plcYn;		
	private String plcIp;		
	private String plcPort;		
	
    protected Instant createdAt;
    protected String createdBy;
    protected Instant updatedAt;
    protected String updatedBy;
}