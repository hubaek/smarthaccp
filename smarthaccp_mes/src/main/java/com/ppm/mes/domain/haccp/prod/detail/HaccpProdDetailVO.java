package com.ppm.mes.domain.haccp.prod.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpProdDetailVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String inspectionSeq;
	private String cnt;
	private String prdStat;
	private String itemNm;
	private String dtm;
	private String result;
	private String remark;
	
	public static HaccpProdDetailVO of (HaccpProdDetail eo){
		HaccpProdDetailVO vo = ModelMapperUtils.map(eo, HaccpProdDetailVO.class);
		return vo;
	}
	
	public static List<HaccpProdDetailVO> of(List<HaccpProdDetail> eoList){
		List<HaccpProdDetailVO> vtoList = new ArrayList<>();
		
		for(HaccpProdDetail object : eoList){
			vtoList.add(of(object));
		}
		return vtoList;
	}
}
