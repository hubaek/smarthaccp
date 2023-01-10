package com.ppm.mes.domain.haccp.filter.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpFilterDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String itemNm;
	private String inspectionType;
	private String inspectionTime;
	private String result1;
	private String result2;
	private String result3;
	private String remark;
	
	public static HaccpFilterDetailVO of (HaccpFilterDetail eo){
		HaccpFilterDetailVO vo = ModelMapperUtils.map(eo, HaccpFilterDetailVO.class);
		return vo;
	}
	
	public static List<HaccpFilterDetailVO> of(List<HaccpFilterDetail> eoList){
		List<HaccpFilterDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpFilterDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
