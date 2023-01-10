package com.ppm.mes.domain.haccp.metal.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpMetalDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String plcIp;
	private String status;
	private String itemNm;
	private String result;
	private String remark;
	private String dtm;
	
	public static HaccpMetalDetailVO of (HaccpMetalDetail eo){
		HaccpMetalDetailVO vo = ModelMapperUtils.map(eo, HaccpMetalDetailVO.class);
		return vo;
	}
	
	public static List<HaccpMetalDetailVO> of(List<HaccpMetalDetail> eoList){
		List<HaccpMetalDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpMetalDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
