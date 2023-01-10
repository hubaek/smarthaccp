package com.ppm.mes.domain.haccp.temp.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpTempDetailVO  extends BaseVO{	
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String plcIp;
	private String temp;
	private String door;
	private String jesang;
	private String itemNm;
	private String measurementTime;
	private String result;
	private String remark;
	private String em;
	private String lmtMin;
	private String lmtMax;
	private String version;
	
	public static HaccpTempDetailVO of (HaccpTempDetail eo){
		HaccpTempDetailVO vo = ModelMapperUtils.map(eo, HaccpTempDetailVO.class);
		return vo;
	}
	
	public static List<HaccpTempDetailVO> of(List<HaccpTempDetail> eoList){
		List<HaccpTempDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpTempDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
