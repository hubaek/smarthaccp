package com.ppm.mes.domain.haccp.tank.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpTankMasterVO extends BaseVO{
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
	
	public static HaccpTankMasterVO of(HaccpTankMaster eo){
		return ModelMapperUtils.map(eo, HaccpTankMasterVO.class);
	}
	
	public static List<HaccpTankMasterVO> of(List<HaccpTankMaster> eoList){
		List<HaccpTankMasterVO> vtoList = new ArrayList<>();
		for(HaccpTankMaster object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
