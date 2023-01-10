package com.ppm.mes.domain.haccp.prod.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpProdMasterMapper extends MyBatisMapper{

	List<HaccpProdMasterVO> getMasterList(RequestParams<HaccpProdMasterVO> vo);

}
