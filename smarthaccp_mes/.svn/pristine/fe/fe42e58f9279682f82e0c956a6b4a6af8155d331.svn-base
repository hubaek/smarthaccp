package com.ppm.mes.domain.haccp.lamp.insect;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpLampInsectVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String mainCode;
	private String subCode;
	private String classification;
	private String checklist;
	private String manageCrieteria;
	private String flyResult;
	private String mothResult;
	private String mosResult;
	private String oneResult;
	private String roachResult;
	private String spyResult;
	private String antResult;
	private String soResult;
	private String ratResult;
	private String lamp;
	private String walk;
	private String ratTrap;
	private String remark;
	
	public static HaccpLampInsectVO of(HaccpLampInsect eo){
		return ModelMapperUtils.map(eo, HaccpLampInsectVO.class);
	}
	
	public static List<HaccpLampInsectVO> of(List<HaccpLampInsect> eoList){
		List<HaccpLampInsectVO> vtoList = new ArrayList<>();
		for(HaccpLampInsect object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
