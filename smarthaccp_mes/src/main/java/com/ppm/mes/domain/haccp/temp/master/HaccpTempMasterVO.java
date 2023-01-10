package com.ppm.mes.domain.haccp.temp.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpTempMasterVO extends BaseVO{
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
	private String upper;
	private String version;
	
	public static HaccpTempMasterVO of(HaccpTempMaster eo){
		return ModelMapperUtils.map(eo, HaccpTempMasterVO.class);
	}
	
	public static List<HaccpTempMasterVO> of(List<HaccpTempMaster> eoList) {
        List<HaccpTempMasterVO> vtoList = new ArrayList<>();
        for (HaccpTempMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
