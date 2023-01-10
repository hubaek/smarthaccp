package com.ppm.mes.domain.haccp.pack.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpPackDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String plcIp;
	private String temp1;
	private String temp2;
	private String temp3;
	private String temp4;
	private String temp5;
	private String temp6;
	private String itemNm;
	private String dtm;
	private String result;
	private String remark;
	private String lmtMin;
	private String lmtMax;
	private String version;
	
	public static HaccpPackDetailVO of (HaccpPackDetail eo){
		HaccpPackDetailVO vo = ModelMapperUtils.map(eo, HaccpPackDetailVO.class);
		return vo;
	}
	
	public static List<HaccpPackDetailVO> of(List<HaccpPackDetail> eoList){
		List<HaccpPackDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpPackDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
