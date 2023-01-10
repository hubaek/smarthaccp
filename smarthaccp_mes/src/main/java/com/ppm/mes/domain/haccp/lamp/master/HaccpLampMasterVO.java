package com.ppm.mes.domain.haccp.lamp.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpLampMasterVO  extends BaseVO{
	private String company;
	private String inspectionDate;
	private String status;
	private String statusNm;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	
	public static HaccpLampMasterVO of(HaccpLampMaster eo){
		return ModelMapperUtils.map(eo, HaccpLampMasterVO.class);
	}
	
	public static List<HaccpLampMasterVO> of(List<HaccpLampMaster> eoList){
		List<HaccpLampMasterVO> vtoList = new ArrayList<>();
		for(HaccpLampMaster object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
