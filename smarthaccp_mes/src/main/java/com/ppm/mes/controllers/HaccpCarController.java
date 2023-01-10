package com.ppm.mes.controllers;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.ModelMapperUtils;
import com.ppm.mes.domain.haccp.car.detail.HaccpCarDetail;
import com.ppm.mes.domain.haccp.car.detail.HaccpCarDetailService;
import com.ppm.mes.domain.haccp.car.detail.HaccpCarDetailVO;
import com.ppm.mes.domain.haccp.car.master.HaccpCarMaster;
import com.ppm.mes.domain.haccp.car.master.HaccpCarMasterService;
import com.ppm.mes.domain.haccp.car.master.HaccpCarMasterVO;

@Controller
@RequestMapping(value="/api/v1/car")
public class HaccpCarController extends BaseController{
	@Inject
	private HaccpCarMasterService masterService;
	@Inject
	private HaccpCarDetailService detailService;
	
	@RequestMapping(value ="/master", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse getMasterList(RequestParams<HaccpCarMaster> requestParams) {
		List<HaccpCarMaster> list = masterService.getList(requestParams);
		//UserLogUtil.saveUserLog("HaccpCarController","HaccpCar Master","GET");
		return Responses.ListResponse.of(list);	
	}
	
	@RequestMapping(value = "/master", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpCarMasterVO> list){
		List<HaccpCarMaster> masterList = ModelMapperUtils.mapList(list,  HaccpCarMaster.class);
		masterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
	public ApiResponse deleteAll(@RequestBody List<HaccpCarMaster> list) {
		//UserLogUtil.saveUserLog("HaccpCarController","HaccpCar","DELETE");
		detailService.deleteAll(list);
		return ok();	
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse getDetailList(RequestParams<HaccpCarDetailVO> requestParams){
		List<HaccpCarDetailVO> codes = detailService.getHaccpCarDetailList(requestParams);
		//UserLogUtil.saveUserLog("HaccpCarController","HaccpCar Detail","GET");
		return Responses.ListResponse.of(codes);
	}
	
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse childSave(@RequestBody List<HaccpCarDetail> list){
		//UserLogUtil.saveUserLog("HaccpCarController","HaccpCar Detail","PUT");
		detailService.saveCarDetail(list);
		return ok();
	}
	@RequestMapping(value = "detailDel", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
	public ApiResponse deleteDetail(@RequestBody HaccpCarDetail list){
		detailService.deleteDetail(list);
		return ok();
	}
	
}
