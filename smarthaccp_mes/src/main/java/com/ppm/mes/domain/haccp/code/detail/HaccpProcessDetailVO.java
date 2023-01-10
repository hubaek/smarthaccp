package com.ppm.mes.domain.haccp.code.detail;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.haccp.code.detail.HaccpProcessDetail;
import com.ppm.mes.domain.haccp.code.detail.HaccpProcessDetailVO;

import lombok.Data;

@Data
public class HaccpProcessDetailVO {
	
	private String company;	
	private String inspectionDate;	 
	private String mainCode; 
	private String subCode; 
	private String process;
	private String checkItem;
	private String checkStd;
	private String cycle;
	private String result1;
	private String result2;
	private String remark;
		
 
	public static HaccpProcessDetailVO of(HaccpProcessDetail eo) {
		HaccpProcessDetailVO vo = ModelMapperUtils.map(eo, HaccpProcessDetailVO.class);
        return vo;
    }

    public static List<HaccpProcessDetailVO> of(List<HaccpProcessDetail> eoList) {
        List<HaccpProcessDetailVO> vtoList = new ArrayList<>();

        for (HaccpProcessDetail object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }

}
