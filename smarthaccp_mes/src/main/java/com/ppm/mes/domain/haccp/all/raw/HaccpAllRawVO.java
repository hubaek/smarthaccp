package com.ppm.mes.domain.haccp.all.raw;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpAllRawVO extends BaseVO{
	private String inspectionDate;
	private String seq;
	private String inspectionTime;
	private String itemNm;
	private String itemNo;
	private String coreTemp;
	private String inspectionResult;
	private String carClean;
	private String expriationDt;
	private String remark;
	
	public static HaccpAllRawVO of(HaccpAllRaw eo){
		return ModelMapperUtils.map(eo, HaccpAllRawVO.class);
	}
	
	public static List<HaccpAllRawVO> of(List<HaccpAllRaw> eoList){
		List<HaccpAllRawVO> vtoList = new ArrayList<>();
		for(HaccpAllRaw object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
	
}
