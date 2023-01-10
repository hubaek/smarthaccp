package com.ppm.mes.domain.monit.prdSite.temp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class TempService {
	@Inject
	private TempMapper tempMapper;
	
	public List<TempVO> getTempList(){
		return tempMapper.getTempList();
	}
	
	public List<TempVO> getMetalDetect(){
		return tempMapper.getMetalDetect();
	}
	
	public Map<String, Object> MonitoringData(Map<String, Object> paramMap){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<String> MonitoringType = tempMapper.MonitoringType(paramMap);
		List<Map<String, Object>> xyLine = tempMapper.MonitoringXYLine(paramMap);	
		
		resultMap.put("TYPE", MonitoringType);
		resultMap.put("XYLine", xyLine);

		return resultMap;
	}
}
