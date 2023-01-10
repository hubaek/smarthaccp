package com.ppm.mes.domain.haccp.pack.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpPackMasterVO extends BaseVO{
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
	
	public static HaccpPackMasterVO of(HaccpPackMaster eo){
		return ModelMapperUtils.map(eo, HaccpPackMasterVO.class);
	}
	
	public static List<HaccpPackMasterVO> of(List<HaccpPackMaster> eoList){
		List<HaccpPackMasterVO> vtoList = new ArrayList<>();
		for(HaccpPackMaster object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
