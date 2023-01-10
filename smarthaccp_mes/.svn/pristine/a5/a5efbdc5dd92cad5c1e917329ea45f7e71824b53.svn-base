package com.ppm.mes.domain.haccp.prod.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HaccpProdMasterVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String status;
	private String statusNm;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	private String time;
	
	public static HaccpProdMasterVO of(HaccpProdMaster eo){
		return ModelMapperUtils.map(eo, HaccpProdMasterVO.class);
	}
	
	public static List<HaccpProdMasterVO> of(List<HaccpProdMaster> eoList) {
        List<HaccpProdMasterVO> vtoList = new ArrayList<>();
        for (HaccpProdMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
