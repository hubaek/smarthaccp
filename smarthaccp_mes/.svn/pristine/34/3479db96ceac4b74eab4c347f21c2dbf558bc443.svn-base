package com.ppm.mes.domain.haccp.ther.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpTherMasterVO extends BaseVO{
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
	
	public static HaccpTherMasterVO of(HaccpTherMaster eo){
		return ModelMapperUtils.map(eo, HaccpTherMasterVO.class);
	}
	
	public static List<HaccpTherMasterVO> of(List<HaccpTherMaster> eoList) {
        List<HaccpTherMasterVO> vtoList = new ArrayList<>();
        for (HaccpTherMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
