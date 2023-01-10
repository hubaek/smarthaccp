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
import com.ppm.mes.domain.haccp.temp.detail.HaccpSensingDataVO;
import com.ppm.mes.domain.haccp.temp.detail.HaccpTempDetail;
import com.ppm.mes.domain.haccp.temp.detail.HaccpTempDetailService;
import com.ppm.mes.domain.haccp.temp.detail.HaccpTempDetailVO;
import com.ppm.mes.domain.haccp.temp.master.HaccpTempMaster;
import com.ppm.mes.domain.haccp.temp.master.HaccpTempMasterService;
import com.ppm.mes.domain.haccp.temp.master.HaccpTempMasterVO;

/*온도,습도 점검*/
@Controller
@RequestMapping(value="/api/v1/haccpTemp")
public class HaccpTempController extends BaseController {
	
	@Inject
	private HaccpTempMasterService tempMasterService;
	@Inject
	private HaccpTempDetailService tempDetailService;
	
	@RequestMapping(value="/master",method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<HaccpTempMasterVO> getMasterList(RequestParams<HaccpTempMasterVO> requestParams){
		return tempMasterService.getMasterList(requestParams);
	}
	
	@RequestMapping(value="/master",method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
	public ApiResponse saveMaster(@RequestBody List<HaccpTempMasterVO> list) {
		List<HaccpTempMaster> masterList = ModelMapperUtils.mapList(list, HaccpTempMaster.class);
		tempMasterService.save(masterList);
		return ok();
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList1(RequestParams<HaccpSensingDataVO> requestParams) {
		List<HaccpSensingDataVO> codes = tempDetailService.getHaccpSensingData(requestParams);

        return Responses.ListResponse.of(codes); 
    }

	@RequestMapping(value = "/metalDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse metalDetail(RequestParams<HaccpSensingDataVO> requestParams) {
		List<HaccpSensingDataVO> codes = tempDetailService.getHaccpReportData(requestParams);

        return Responses.ListResponse.of(codes); 
    }

	@RequestMapping(value = "/detail2", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getDetailList2(RequestParams<HaccpTempDetailVO> requestParams) {

		List<HaccpTempDetailVO> codes = tempDetailService.getHaccpTempDetailList2(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpTempController","HaccpTemp Detail2","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	// 201211 kjm 차트 생성시
	@RequestMapping(value = "/GetCharts1", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse GetCharts1(RequestParams<HaccpTempDetailVO> requestParams) {
		List<HaccpTempDetailVO> codes = tempDetailService.GetCharts1(requestParams);		
		//UserLogUtil.saveUserLog("HaccpTempController","GetCharts1","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	// 201211 kjm 차트 생성시
		@RequestMapping(value = "/GetCharts2", method = RequestMethod.GET, produces = APPLICATION_JSON)
	    public Responses.ListResponse GetCharts2(RequestParams<HaccpTempDetailVO> requestParams) {
			List<HaccpTempDetailVO> codes = tempDetailService.GetCharts2(requestParams);		
			//UserLogUtil.saveUserLog("HaccpTempController","GetCharts2","GET");
	        return Responses.ListResponse.of(codes); 
	    }
	
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getHaccpDetailList(RequestParams<HaccpTempDetailVO> requestParams) {

		List<HaccpTempDetailVO> codes = tempDetailService.getHaccpDetailList(requestParams);
		
		//UserLogUtil.saveUserLog("HaccpTempController","Temp Detail","GET");
        return Responses.ListResponse.of(codes); 
    }
	
	//상세저장
	@RequestMapping(value = "/detail", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse childSave(@RequestBody List<HaccpTempDetail> list) {
    	//UserLogUtil.saveUserLog("HaccpTempController","HaccpTemp Detail","PUT");
    	tempDetailService.saveHaccpTempDetailList(list);
        return ok(); 
    }
	
	//삭제 
	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteAll(@RequestBody List<HaccpTempMaster> list) {    	
    	//UserLogUtil.saveUserLog("HaccpTempController","HaccpTemp","DELETE");
    	tempDetailService.deleteAll(list);
    	return ok();
    } 
}