package com.ppm.mes.domain.selfHygine.code;

import  java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class SelfHygineMasterVO extends BaseVO {
	private String company;
	private String inspectionDate;
	private String mainCode;
	private String status;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	
	public static SelfHygineMasterVO of(SelfHygineMaster eo) {
        return ModelMapperUtils.map(eo, SelfHygineMasterVO.class);
    }
	
	public static List<SelfHygineMasterVO> of(List<SelfHygineMaster> eoList) {
        List<SelfHygineMasterVO> vtoList = new ArrayList<>();
        for (SelfHygineMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
