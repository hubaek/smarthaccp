package com.ppm.mes.domain.haccp.ster.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpSterDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String plcIp;
	private String temp1;
	private String temp2;
	private String temp3;
	private String stat;
	private String itemNm;
	private String dtm;
	private String result;
	private String remark;
	private String lmtMin;
	private String lmtMax;
	private String version;
	private String wonmul;
	
	public static HaccpSterDetailVO of (HaccpSterDetail eo){
		HaccpSterDetailVO vo = ModelMapperUtils.map(eo, HaccpSterDetailVO.class);
		return vo;
	}
	
	public static List<HaccpSterDetailVO> of(List<HaccpSterDetail> eoList){
		List<HaccpSterDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpSterDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
