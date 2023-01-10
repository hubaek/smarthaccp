package com.ppm.mes.domain.haccp.all.work;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpAllWorkVO extends BaseVO{
	
	private String inspectionDate;
	private String classification;
	private String checklist;
	private String manageCrieteria;
	private String result;
	private String resultTime;
	private String remark;
	private String mainCode;
	private String subCode;
	
	public static HaccpAllWorkVO of(HaccpAllWork eo){
		return ModelMapperUtils.map(eo, HaccpAllWorkVO.class);
	}
	
	public static List<HaccpAllWorkVO> of(List<HaccpAllWork> eoList){
		List<HaccpAllWorkVO> vtoList = new ArrayList<>();
		for(HaccpAllWork object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
