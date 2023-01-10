package com.ppm.mes.domain.haccp.tank.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpTankDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String plcIp;
	private String temp;
	private String door;
	private String jesang;
	private String itemNm;
	private String dtm;
	private String result;
	private String remark;
	
	public static HaccpTankDetailVO of (HaccpTankDetail eo){
		HaccpTankDetailVO vo = ModelMapperUtils.map(eo, HaccpTankDetailVO.class);
		return vo;
	}
	
	public static List<HaccpTankDetailVO> of(List<HaccpTankDetail> eoList){
		List<HaccpTankDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpTankDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
