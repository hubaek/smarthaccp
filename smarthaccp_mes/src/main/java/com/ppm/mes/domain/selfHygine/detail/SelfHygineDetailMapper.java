package com.ppm.mes.domain.selfHygine.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.selfHygine.detail.SelfHygineDetailVO;

public interface SelfHygineDetailMapper extends MyBatisMapper{
	//HACCP 세부항목에서 가져오기 2020-07-01
	List<SelfHygineDetailVO> getHaccpDetailList(RequestParams<SelfHygineDetailVO> vo);
	
	//저장된 세부항목 가져오기 2020-07-01
	List<SelfHygineDetailVO> getSelfHygineDetailList(RequestParams<SelfHygineDetailVO> vo);

}
