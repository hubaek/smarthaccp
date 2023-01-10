package com.ppm.mes.domain.haccp.all.raw;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpAllRawMapper extends MyBatisMapper{

	List<HaccpAllRawVO> getRawList(RequestParams<HaccpAllRawVO> requestParams);

}
