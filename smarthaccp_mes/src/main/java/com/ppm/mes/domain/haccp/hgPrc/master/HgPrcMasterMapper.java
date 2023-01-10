package com.ppm.mes.domain.haccp.hgPrc.master;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HgPrcMasterMapper extends MyBatisMapper{
	List<HgPrcMasterVO> getMasterList(RequestParams<HgPrcMasterVO> vo);
	List<HgPrcMasterVO> deleteAll(RequestParams<HgPrcMasterVO> vo);
}
