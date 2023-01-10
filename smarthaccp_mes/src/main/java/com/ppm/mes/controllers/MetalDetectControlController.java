package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.haccp.metal.detect.MetalDetectControlService;
import com.ppm.mes.domain.haccp.metal.detect.MetalDetectControlVO;
import com.ppm.mes.utils.SessionUtils;

@Controller
@RequestMapping(value="/api/v1/metalDetectControl")
public class MetalDetectControlController extends BaseController{
	
	@Inject private MetalDetectControlService metalDetectControlService;
	
	@RequestMapping(value="/getSpecimenTest",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<MetalDetectControlVO> getSpecimenTest(RequestParams<MetalDetectControlVO> requestParams){
		return metalDetectControlService.getSpecimenTest(requestParams);
	}
	
	@RequestMapping(value="/mergeSpecimen",method = RequestMethod.PUT, produces = APPLICATION_JSON)
	public void mergeSpecimen(RequestParams<MetalDetectControlVO> requestParams){
		String userCd = SessionUtils.getCurrentLoginUserCd();
		requestParams.put("update_user_id", userCd);
		requestParams.put("insert_user_id", userCd);
		
		metalDetectControlService.mergeSpecimen(requestParams);
		metalDetectControlService.insertStartSensingData(requestParams);
	}
	
	@RequestMapping(value="/insertStartSensingData",method = RequestMethod.PUT, produces = APPLICATION_JSON)
	public void insertStartSensingData(RequestParams<MetalDetectControlVO> requestParams){
		metalDetectControlService.insertStartSensingData(requestParams);
	}

}
