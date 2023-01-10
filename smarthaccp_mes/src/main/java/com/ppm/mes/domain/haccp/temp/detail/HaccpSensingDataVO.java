package com.ppm.mes.domain.haccp.temp.detail;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpSensingDataVO  extends BaseVO{	
	private String auto_collect_id;
	private String measure_dtm;
	private String attribute_1_value;
	private String attribute_2_value;
	private String attribute_3_value;
	private String attribute_4_value;
	private String attribute_5_value;
	
	public static HaccpSensingDataVO of (HaccpTempDetail eo){
		HaccpSensingDataVO vo = ModelMapperUtils.map(eo, HaccpSensingDataVO.class);
		return vo;
	}
	
}
