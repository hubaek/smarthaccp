package com.ppm.mes.domain.haccp.filter.master;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpFilterMasterMapper extends MyBatisMapper{

	List<HaccpFilterMasterVO> getMasterList(RequestParams<HaccpFilterMasterVO> vo);

	String getFilterCheck(Map<String, String> paramMap);


}
