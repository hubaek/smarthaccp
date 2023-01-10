package com.ppm.mes.domain.st.st400;

import java.math.BigDecimal;
import java.time.Instant;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class MoveInoutVO  extends BaseVO {

	private String company;
	private String slipCd;
	private String slipDt;
	private String refWhCd;
	private String whCd;
	private String userCd;
	private String userNm;
	private BigDecimal sumItemQty;
	private String remark;  
	
	private Long slipSeq;
	private String stockCd;
	private String refStockCd;	
	private String itemCd;
	private String itemNm;
	private String partNo;
	private String lotNo;
	private String barcode;
	private String wlotNo;
	private String spec;
	private String unit;
	private BigDecimal preItemQty;
	private BigDecimal itemQty;
    protected Instant updatedAt;
    protected String updatedBy;
}