package com.ppm.mes.domain.wo.wo160;

import java.math.BigDecimal;
import java.math.BigInteger;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkOrderIncomingVO  extends BaseVO {
	private String company;
	private String wlotNo;
	private BigInteger woSeq;
	//createdat
	//createdby
	//updatedat
	//updatedby
	private String itemCd;
	private BigDecimal itemQty;
	private String stockCd;
	private String prdInType;
	private String barcode;
}