package com.ppm.mes.domain.wo.wo100;

import java.math.BigDecimal;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;  

@Data
public class WorkOrderMasterRequestVO  extends BaseVO {
	private WorkOrderMaster workMaster;
	private BigDecimal itemQty;
}  