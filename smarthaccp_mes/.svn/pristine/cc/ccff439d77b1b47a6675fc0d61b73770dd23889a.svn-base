package com.ppm.mes.domain.haccp.manufacturing.code;

import  java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ManuFacturingMasterVO extends BaseVO {
	private String company;
	private String inspectionDate;
	private String mainCode;
	private String status;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	
	public static ManuFacturingMasterVO of(ManuFacturingMaster eo) {
        return ModelMapperUtils.map(eo, ManuFacturingMasterVO.class);
    }
	
	public static List<ManuFacturingMasterVO> of(List<ManuFacturingMaster> eoList) {
        List<ManuFacturingMasterVO> vtoList = new ArrayList<>();
        for (ManuFacturingMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
