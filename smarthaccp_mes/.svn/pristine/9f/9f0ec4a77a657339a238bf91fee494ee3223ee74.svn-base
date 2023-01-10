package com.ppm.mes.domain.haccp.clean.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpCleanDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String plcIp;
	private String itemNm;
	private String result;
	private String remark;
	private String em;
	private String w1;
	private String dtm;
	private String stat;
	
	public static HaccpCleanDetailVO of (HaccpCleanDetail eo){
		HaccpCleanDetailVO vo = ModelMapperUtils.map(eo, HaccpCleanDetailVO.class);
		return vo;
	}
	
	public static List<HaccpCleanDetailVO> of(List<HaccpCleanDetail> eoList){
		List<HaccpCleanDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpCleanDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
