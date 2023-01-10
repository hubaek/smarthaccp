package com.ppm.mes.domain.haccp.temp.master;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpTempMasterMapper extends MyBatisMapper{
	
	List<HaccpTempMasterVO> getMasterList(RequestParams<HaccpTempMasterVO> vo);	

	// 20.09.11 kjm
		String getTempCheck(Map<String, String> humMap);
		void putMasterTemp(Map<String, String> map);

}
