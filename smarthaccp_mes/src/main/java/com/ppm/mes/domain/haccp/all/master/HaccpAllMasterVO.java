package com.ppm.mes.domain.haccp.all.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpAllMasterVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String status;
	private String statusNm;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	private String mainCode;
	private String mainName;
	
	public static HaccpAllMasterVO of(HaccpAllMaster eo){
		return ModelMapperUtils.map(eo, HaccpAllMasterVO.class);
	}
	
	public static List<HaccpAllMasterVO> of(List<HaccpAllMaster> eoList){
		List<HaccpAllMasterVO> vtoList = new ArrayList<>();
		for(HaccpAllMaster object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
