package com.ppm.mes.domain.health.health000;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
public class HealthVO extends BaseVO {

	private String userCd; 
	private Long healthCardSeq; 	
	private String healthCardNo; 
	private String healthCardStartDt;
    private String healthCardEndDt;
	private String remark;
	private String userNm; 
	private String userKey;
	private String remainDt;
	private String useyn;

}