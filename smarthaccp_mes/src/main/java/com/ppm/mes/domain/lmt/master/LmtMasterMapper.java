package com.ppm.mes.domain.lmt.master;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface LmtMasterMapper extends MyBatisMapper{
	List<LmtMasterVO> getLimitList(RequestParams<LmtMasterVO> requestParams);

	List<LmtMasterVO> getLmtList(Map<String, String> paramMap);
}
