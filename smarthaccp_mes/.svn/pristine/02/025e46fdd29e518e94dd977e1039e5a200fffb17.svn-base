package com.ppm.mes.domain.haccp.ther.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpTherDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String plcIp;
	private String temp;
	private String hum;
	private String itemNm;
	private String dtm;
	private String result;
	private String remark;
	private String em;
	private String lmtMin;
	private String lmtMax;
	
	public static HaccpTherDetailVO of (HaccpTherDetail eo){
		HaccpTherDetailVO vo = ModelMapperUtils.map(eo, HaccpTherDetailVO.class);
		return vo;
	}
	
	public static List<HaccpTherDetailVO> of(List<HaccpTherDetail> eoList){
		List<HaccpTherDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpTherDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
