package com.ppm.mes.domain.haccp.code.detail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;

@Data
public class HaccpProcessCodeDetailVO extends BaseVO {
	
	private String company;	
	private String mainCode;	 
	private String subCode; 
	private String checkItem; 
	private String subNameEn;
	private String subNameZh;
	private String lang; 
	private BigDecimal sort; 
	private String process; 
	private String checkStd; 
	private String cycle; 
	private BigDecimal data4; 
	private BigDecimal data5; 
	private String remark;	
	private String useYn;
	private String delYn;		
 
	public static HaccpProcessCodeDetailVO of(HaccpProcessCodeDetail eo) {
		HaccpProcessCodeDetailVO vo = ModelMapperUtils.map(eo, HaccpProcessCodeDetailVO.class);
        return vo;
    }

    public static List<HaccpProcessCodeDetailVO> of(List<HaccpProcessCodeDetail> eoList) {
        List<HaccpProcessCodeDetailVO> vtoList = new ArrayList<>();

        for (HaccpProcessCodeDetail object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
