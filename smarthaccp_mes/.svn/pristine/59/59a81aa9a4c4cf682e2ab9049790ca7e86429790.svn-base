package com.ppm.mes.domain.haccp.clean.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpCleanMasterVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String status;
	private String statusNm;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	private String time;
	private String plcIp;
	private String em;
	
	public static HaccpCleanMasterVO of(HaccpCleanMaster eo){
		return ModelMapperUtils.map(eo, HaccpCleanMasterVO.class);
	}
	
	public static List<HaccpCleanMasterVO> of(List<HaccpCleanMaster> eoList) {
        List<HaccpCleanMasterVO> vtoList = new ArrayList<>();
        for (HaccpCleanMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
