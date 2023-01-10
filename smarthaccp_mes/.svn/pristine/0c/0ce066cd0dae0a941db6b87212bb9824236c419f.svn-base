package com.ppm.mes.domain.cd.cd100;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
 
@Data
public class BasicCodeDetailVO extends BaseVO {

	private String mainCd;	 
	private String subCd; 
	private String subNm; 
	private String subNmEn;
	private String subNmZh;
	private String lang; 
	private BigDecimal sort; 
	private String data1; 
	private String data2; 
	private String data3; 
	private BigDecimal data4; 
	private BigDecimal data5; 
	private String remark;	
	private String useYn;
	private String delYn;		
 
	public static BasicCodeDetailVO of(BasicCodeDetail eo) {
		BasicCodeDetailVO vo = ModelMapperUtils.map(eo, BasicCodeDetailVO.class);
        return vo;
    }

    public static List<BasicCodeDetailVO> of(List<BasicCodeDetail> eoList) {
        List<BasicCodeDetailVO> vtoList = new ArrayList<>();

        for (BasicCodeDetail object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}