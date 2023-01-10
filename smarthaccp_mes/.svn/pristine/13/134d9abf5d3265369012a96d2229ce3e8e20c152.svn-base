package com.ppm.mes.domain.haccp.temp.detail;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;

public interface HaccpTempDetailMapper extends MyBatisMapper{
	List<HaccpSensingDataVO> getHaccpSensingData(RequestParams<HaccpSensingDataVO> vo);
	
	List<HaccpSensingDataVO> getHaccpReportData(RequestParams<HaccpSensingDataVO> vo);

	List<HaccpTempDetailVO> getHaccpTempDetailList1(RequestParams<HaccpTempDetailVO> vo);
	
	List<HaccpTempDetailVO> getHaccpTempDetailList2(RequestParams<HaccpTempDetailVO> vo);	

	List<HaccpTempDetailVO> getHaccpDetailList(RequestParams<HaccpTempDetailVO> requestParams);

	List<HaccpTempDetailVO> getTemp(Map<String, String> paramMap);

	void putCheckTemp(Map<String, String> map);

	List<HaccpTempDetailVO> GetCharts1(RequestParams<HaccpTempDetailVO> requestParams);
	
	List<HaccpTempDetailVO> GetCharts2(RequestParams<HaccpTempDetailVO> requestParams);
}
