package com.ppm.mes.domain.haccp.filter.master;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpFilterMasterVO extends BaseVO {
	private String company;
	private String inspectionDate;
	private String status;
	private String statusNm;
	private String writer;
	private String approver;
	private String solver;
	private String remark1;
	private String remark2;
	
}
