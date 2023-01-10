package com.ppm.mes.domain.haccp.waste.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpWasteMasterMapper extends MyBatisMapper {
	List<HaccpWasteMasterVO> getMasterList(RequestParams<HaccpWasteMasterVO> vo);
}
