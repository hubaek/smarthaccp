package com.ppm.mes.domain.haccp.waste.master;

import  java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class HaccpWasteMasterVO extends BaseVO {
	private String company;
	private String inspectionDate;
	private int wasteAmt;
	private String wastePickDt;
	private String pickCompany;
	private String wasteType;
	
	private String status;
	private String writer;
	private String approver;
	private String remark1;
	private String seq;
	private String maxSeq;
	private String fileYn;
	private String targetType;
	
	
	public static HaccpWasteMasterVO of(HaccpWasteMaster eo) {
        return ModelMapperUtils.map(eo, HaccpWasteMasterVO.class);
    }
	
	public static List<HaccpWasteMasterVO> of(List<HaccpWasteMaster> eoList) {
        List<HaccpWasteMasterVO> vtoList = new ArrayList<>();
        for (HaccpWasteMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
