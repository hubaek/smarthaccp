package com.ppm.mes.domain.haccp.heat.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpHeatMasterMapper extends MyBatisMapper{

	List<HaccpHeatMasterVO> getMasterList(RequestParams<HaccpHeatMasterVO> vo);

}
