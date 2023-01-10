package com.ppm.mes.domain.haccp.tank.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpTankDetailMapper extends MyBatisMapper{

	List<HaccpTankDetailVO> getHaccpTankDetailList(RequestParams<HaccpTankDetailVO> requestParams);

	List<HaccpTankDetailVO> getHaccpDetailList(RequestParams<HaccpTankDetailVO> requestParams);

	List<HaccpTankDetailVO> GetCharts(RequestParams<HaccpTankDetailVO> requestParams);

}
