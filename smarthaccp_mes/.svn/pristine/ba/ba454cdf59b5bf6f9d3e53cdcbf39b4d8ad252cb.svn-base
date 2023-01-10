package com.ppm.mes.domain.haccp.ster.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpSterMasterVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String status;
	private String statusNm;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	private String time;
	private String plcIp;
	private String version;
	
	public static HaccpSterMasterVO of(HaccpSterMaster eo){
		return ModelMapperUtils.map(eo, HaccpSterMasterVO.class);
	}
	
	public static List<HaccpSterMasterVO> of(List<HaccpSterMaster> eoList){
		List<HaccpSterMasterVO> vtoList = new ArrayList<>();
		for(HaccpSterMaster object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
