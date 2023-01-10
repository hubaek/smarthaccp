package com.ppm.mes.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.controllers.BaseController;
import com.ppm.mes.domain.monit.prdSite.temp.TempService;
import com.ppm.mes.domain.monit.prdSite.temp.TempVO;


@Controller
@RequestMapping(value="/api/v1/productionSiteMonit")
public class ProductionSiteMonitController extends BaseController{
	
	@Inject private TempService tempService;
	
	@RequestMapping(value="getTempList", method = {RequestMethod.GET}, produces = APPLICATION_JSON)
	public List<TempVO> getTempList(){
		return tempService.getTempList();
	}
	
	@RequestMapping(value="getMetalDetect", method=RequestMethod.GET, produces = APPLICATION_JSON)
	public List<TempVO> getMetalDetect(){
		return tempService.getMetalDetect();
	}
	
	@RequestMapping(value ="MonitoringData", method = {RequestMethod.POST}, produces = APPLICATION_JSON)
    public Map<String, Object> MonitoringData(@RequestBody Map<String, Object> paramMap) {
   		
		Map<String, Object> resultMap = tempService.MonitoringData(paramMap);
		return resultMap;
    }
}
