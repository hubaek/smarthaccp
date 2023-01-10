package com.ppm.mes.domain.haccp.hgPrc.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;
import lombok.Data;

@Data
public class HgPrcDetailVO extends BaseVO{
	
	private String company;
	private String inspectionDate;
	private String mainCode;
	private String subCode;
	private String classification;
	private String checklist;
	private String manageCrieteria;
	private String checkResult;
	private String remark;
	
	public static HgPrcDetailVO of (HgPrcDetail eo){
		HgPrcDetailVO vo = ModelMapperUtils.map(eo, HgPrcDetailVO.class);
		return vo;
	}
	
	public static List<HgPrcDetailVO> of(List<HgPrcDetail> eoList){
		List<HgPrcDetailVO> vtoList = new ArrayList<>();
		
		for(HgPrcDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
