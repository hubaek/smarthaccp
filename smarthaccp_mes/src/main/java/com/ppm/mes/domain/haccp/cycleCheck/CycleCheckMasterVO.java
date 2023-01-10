package com.ppm.mes.domain.haccp.cycleCheck;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CycleCheckMasterVO extends BaseVO{
	private String ccpCd;
	private String ccpNm;
	private String ccpCycle;
	private String comment;
	private String ccpDate;
	private String ccpHistoryDate;
	private String popAlarm;
	private String popDate;
	private String menuCd;
	private String progPh;
	private String date;
	private String ccpLastUpdate;
	public static CycleCheckMasterVO of(CycleCheckMaster eo){
		return ModelMapperUtils.map(eo,  CycleCheckMasterVO.class);
	}
	
	public static List<CycleCheckMasterVO> of (List<CycleCheckMaster> eoList){
		List<CycleCheckMasterVO> vtoList = new ArrayList<>();
		for(CycleCheckMaster object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
