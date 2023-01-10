package com.ppm.mes.domain.wo.wo120;

import java.util.List;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class WorkOrderBadRequestVO  extends BaseVO {
	private String wlotNo;
	private String lastFlag;
	private List<WorkOrderBad> bads;
}