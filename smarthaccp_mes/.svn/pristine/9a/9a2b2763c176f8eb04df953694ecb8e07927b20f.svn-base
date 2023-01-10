package com.ppm.mes.domain.haccp.heat.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpHeatDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String plcIp;
	private String temp;
	private String itemNm;
	private String dtm;
	private String heatStat;
	private String result;
	private String remark;
	private String heatClean;
	
	public static HaccpHeatDetailVO of (HaccpHeatDetail eo){
		HaccpHeatDetailVO vo = ModelMapperUtils.map(eo, HaccpHeatDetailVO.class);
		return vo;
	}
	
	public static List<HaccpHeatDetailVO> of(List<HaccpHeatDetail> eoList){
		List<HaccpHeatDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpHeatDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
