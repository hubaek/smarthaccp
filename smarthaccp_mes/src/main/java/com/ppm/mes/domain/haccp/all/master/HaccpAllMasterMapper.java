package com.ppm.mes.domain.haccp.all.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpAllMasterMapper extends MyBatisMapper{

	List<HaccpAllMaster> getList(RequestParams<HaccpAllMasterVO> requestParams);
	
}
