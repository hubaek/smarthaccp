package com.ppm.mes.domain.haccp.pack.detail;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpPackDetailMapper extends MyBatisMapper{

	List<HaccpPackDetailVO> getHaccpPackDetailList1(RequestParams<HaccpPackDetailVO> requestParams);
	
	List<HaccpPackDetailVO> getHaccpPackDetailList2(RequestParams<HaccpPackDetailVO> requestParams);
	
	List<HaccpPackDetailVO> getHaccpPackDetailList3(RequestParams<HaccpPackDetailVO> requestParams);

	List<HaccpPackDetailVO> getHaccpDetailList(RequestParams<HaccpPackDetailVO> requestParams);

	List<HaccpPackDetailVO> GetCharts1(RequestParams<HaccpPackDetailVO> requestParams);
	
	List<HaccpPackDetailVO> GetCharts2(RequestParams<HaccpPackDetailVO> requestParams);
	
	List<HaccpPackDetailVO> GetCharts3(RequestParams<HaccpPackDetailVO> requestParams);

}
