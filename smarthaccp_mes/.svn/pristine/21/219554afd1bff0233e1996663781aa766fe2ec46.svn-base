package com.ppm.mes.domain.haccp.car.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.haccp.car.detail.HaccpCarDetailVO;

public interface HaccpCarDetailMapper extends MyBatisMapper{
	//저장된 세부항목 가져오기
	List<HaccpCarDetailVO> getHaccpCarDetailList(RequestParams<HaccpCarDetailVO> vo);
	
	void deleteDetail(HaccpCarDetail list);
}
