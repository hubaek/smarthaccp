package com.ppm.mes.domain.haccp.clean.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpCleanMasterMapper extends MyBatisMapper{

	List<HaccpCleanMasterVO> getMasterList(RequestParams<HaccpCleanMasterVO> requestParams);

}
