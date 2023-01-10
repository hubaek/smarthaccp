package com.ppm.mes.domain.haccp.code.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
public class HaccpCodeMasterVO extends BaseVO {

	private String company;
	private String templateId; 
	private String templateNm; 
	private String useYn;

    public static HaccpCodeMasterVO of(HaccpCodeMaster eo) {
        return ModelMapperUtils.map(eo, HaccpCodeMasterVO.class);
    }


    public static List<HaccpCodeMasterVO> of(List<HaccpCodeMaster> eoList) {
        List<HaccpCodeMasterVO> vtoList = new ArrayList<>();
        for (HaccpCodeMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
 
}