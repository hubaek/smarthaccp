package com.ppm.mes.domain.haccp.hgPrc.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HgPrcDetailMapper extends MyBatisMapper{
	
		//HACCP 세부항목에서 가져오기 2020-11-24
		List<HgPrcDetailVO> getHaccpDetailList(RequestParams<HgPrcDetailVO> vo);
		
		//저장된 세부항목 가져오기 2020-11-24 cju
		List<HgPrcDetailVO> getHgPrcDetailList(RequestParams<HgPrcDetailVO> vo);
}
