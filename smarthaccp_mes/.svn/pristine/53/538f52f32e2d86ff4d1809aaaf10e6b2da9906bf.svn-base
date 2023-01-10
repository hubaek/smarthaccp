package com.ppm.mes.domain.selfHygine.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class SelfHygineDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String mainCode;
	private String subCode;
	private String classification;
	private String period;
	private String checklist;
	private String manageCrieteria;
	private String checkResult;
	private String remark;
	
	public static SelfHygineDetailVO of (SelfHygineDetail eo){
		SelfHygineDetailVO vo = ModelMapperUtils.map(eo, SelfHygineDetailVO.class);
		return vo;
	}
	
	public static List<SelfHygineDetailVO> of(List<SelfHygineDetail> eoList){
		List<SelfHygineDetailVO> vtoList = new ArrayList<>();
		
		for(SelfHygineDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
