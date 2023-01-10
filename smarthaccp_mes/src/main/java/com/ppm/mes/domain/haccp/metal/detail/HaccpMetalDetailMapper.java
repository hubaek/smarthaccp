package com.ppm.mes.domain.haccp.metal.detail;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpMetalDetailMapper extends MyBatisMapper{

	List<HaccpMetalDetailVO> getHaccpMetalDetailList(RequestParams<HaccpMetalDetailVO> requestParams);

	List<HaccpMetalDetailVO> getMetal(Map<String, String> paramMap);

	void putCheckMetal(Map<String, String> map);

	List<HaccpMetalDetailVO> getMetalDetailList(RequestParams<HaccpMetalDetailVO> requestParams);




}
