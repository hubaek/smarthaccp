package com.ppm.mes.domain.haccp.car.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class HaccpCarMasterVO extends BaseVO{
	private String company;
	private String inspectionYm;
	private String status;
	private String manager;
	private String writer;
	private String reviewer;
	private String approver;
	private String remark;
	
	public static HaccpCarMasterVO of(HaccpCarMaster eo){
		return ModelMapperUtils.map(eo,  HaccpCarMasterVO.class);
	}
	
	public static List<HaccpCarMasterVO> of(List<HaccpCarMaster> eoList){
		List<HaccpCarMasterVO> vtoList = new ArrayList<>();
		for(HaccpCarMaster object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
