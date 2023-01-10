package com.ppm.mes.domain.haccp.heat.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpHeatMasterVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String status;
	private String statusNm;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	private String time;
	private String heatClean;
	
	public static HaccpHeatMasterVO of(HaccpHeatMaster eo){
		return ModelMapperUtils.map(eo, HaccpHeatMasterVO.class);
	}
	
	public static List<HaccpHeatMasterVO> of(List<HaccpHeatMaster> eoList) {
        List<HaccpHeatMasterVO> vtoList = new ArrayList<>();
        for (HaccpHeatMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
