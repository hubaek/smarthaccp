package com.ppm.mes.domain.haccp.hgPrc.master;

import java.util.ArrayList;
import java.util.List;

import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HgPrcMasterVO extends BaseVO{
	private String company;
	private String inspectionDate;
	private String mainCode;
	private String status;
	private String writer;
	private String approver;
	private String remark1;
	private String remark2;
	private String statusNm;
	
	public static HgPrcMasterVO of(HgPrcMaster eo) {
        return ModelMapperUtils.map(eo, HgPrcMasterVO.class);
    }
	
	public static List<HgPrcMasterVO> of(List<HgPrcMaster> eoList) {
        List<HgPrcMasterVO> vtoList = new ArrayList<>();
        for (HgPrcMaster object : eoList) {
            vtoList.add(of(object));
        }
        return vtoList;
    }
}
