package com.ppm.mes.domain.haccp.manufacturing.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class ManuFacturingDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String mainCode;
	private String subCode;
	private String classification;
	private String checklist;
	private String manageCrieteria;
	private String checkResult;
	private String remark;
	
	public static ManuFacturingDetailVO of (ManuFacturingDetail eo){
		ManuFacturingDetailVO vo = ModelMapperUtils.map(eo, ManuFacturingDetailVO.class);
		return vo;
	}
	
	public static List<ManuFacturingDetailVO> of(List<ManuFacturingDetail> eoList){
		List<ManuFacturingDetailVO> vtoList = new ArrayList<>();
		
		for(ManuFacturingDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
