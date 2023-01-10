package com.ppm.mes.domain.haccp.ster.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpSterMasterMapper extends MyBatisMapper{

	List<HaccpSterMasterVO> getMasterList(RequestParams<HaccpSterMasterVO> vo);

}
