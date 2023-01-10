package com.ppm.mes.domain.haccp.in.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpInDetailMapper extends MyBatisMapper{

	void deDel(HaccpInDetail t);

	List<HaccpInDetail> detailDel(RequestParams<HaccpInDetailVO> vo);

}
