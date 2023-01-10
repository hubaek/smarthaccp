package com.ppm.mes.domain.selfHygine.code;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface SelfHygineMasterMapper extends MyBatisMapper{
	List<SelfHygineMasterVO> getMasterList(RequestParams<SelfHygineMasterVO> vo);
	List<SelfHygineMasterVO> deleteAll(RequestParams<SelfHygineMasterVO> vo);
}
