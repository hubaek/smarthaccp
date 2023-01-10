package com.ppm.mes.domain.haccp.prod.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpProdDetailMapper extends MyBatisMapper{

	List<HaccpProdDetailVO> getHaccpProdDetailList(RequestParams<HaccpProdDetailVO> requestParams);

	List<HaccpProdDetailVO> getHaccpDetailList(RequestParams<HaccpProdDetailVO> requestParams);

}
