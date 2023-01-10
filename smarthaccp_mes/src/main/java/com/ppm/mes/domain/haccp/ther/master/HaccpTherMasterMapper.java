package com.ppm.mes.domain.haccp.ther.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpTherMasterMapper extends MyBatisMapper{

	List<HaccpTherMasterVO> getMasterList(RequestParams<HaccpTherMasterVO> vo);

}
