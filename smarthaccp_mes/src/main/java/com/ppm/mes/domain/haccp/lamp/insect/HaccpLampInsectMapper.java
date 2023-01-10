package com.ppm.mes.domain.haccp.lamp.insect;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.haccp.lamp.insect.HaccpLampInsectVO;

public interface HaccpLampInsectMapper extends MyBatisMapper{
	
	List<HaccpLampInsectVO> getInsectList(RequestParams<HaccpLampInsectVO> requestParams);

	List<HaccpLampInsectVO> getHaccpInsectList(RequestParams<HaccpLampInsectVO> requestParams);

}
