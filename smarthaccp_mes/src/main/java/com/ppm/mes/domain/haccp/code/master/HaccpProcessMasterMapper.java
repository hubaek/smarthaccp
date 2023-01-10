package com.ppm.mes.domain.haccp.code.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;


public interface HaccpProcessMasterMapper extends MyBatisMapper {
	
	List<HaccpProcessMasterVO> getList(RequestParams<HaccpProcessMasterVO> vo);
}
