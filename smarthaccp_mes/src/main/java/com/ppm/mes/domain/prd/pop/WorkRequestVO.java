package com.ppm.mes.domain.prd.pop;

import java.math.BigDecimal;
import java.util.List;

import com.chequer.axboot.core.vo.BaseVO;
import com.ppm.mes.domain.wo.wo100.WorkOrderMaster;
import com.ppm.mes.domain.wo.wo110.WorkManManage;
import com.ppm.mes.domain.wo.wo120.WorkOrderBad;
import com.ppm.mes.domain.wo.wo130.WorkNwrkManage;
import com.ppm.mes.domain.wo.wo150.WorkOrderOutgoingItem;

import lombok.Data;  

@Data
public class WorkRequestVO  extends BaseVO {
	private WorkOrderMaster workMaster;
	private BigDecimal prodQty;
	private List<WorkManManage> workMan;
	private WorkOrderOutgoingItem workOutgoingItem;  
	private WorkNwrkManage workNwrk;
	private WorkOrderBad workBad;
}  