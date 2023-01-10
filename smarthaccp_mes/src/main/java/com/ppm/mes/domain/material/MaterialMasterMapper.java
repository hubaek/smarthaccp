package com.ppm.mes.domain.material;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface MaterialMasterMapper extends MyBatisMapper{
	List<MaterialMasterVO> getMaterialList(RequestParams<MaterialMasterVO> requestParams);
	
	List<MaterialMasterVO> getMaterialCheckInDate(RequestParams<MaterialMasterVO> requestParams);
	
}
