package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.bom.bom000.BomDetailVO;
import com.ppm.mes.domain.bom.bom000.BomItemVO;
import com.ppm.mes.domain.bom.bom000.BomMaster;
import com.ppm.mes.domain.bom.bom000.BomMasterService;
import com.ppm.mes.domain.bom.bom000.BomMasterVO;

/*
 * BOM관리
 */
@Controller
@RequestMapping(value = "/api/v1/bom")
public class BomMasterController extends BaseController {

    @Inject private BomMasterService bomMasterService;

   	@RequestMapping(value = "bomMasterList", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse bomMasterList(RequestParams<BomMasterVO> bomVo) {   		
   		List<BomMasterVO> list = bomMasterService.bomMasterList(bomVo);
   		//UserLogUtil.saveUserLog("BomMasterController","BOM Master List","GET");
   		return Responses.ListResponse.of(list);
   	}
   	
   	@RequestMapping(value = "bomListAll", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse bomListAll(RequestParams<BomMasterVO> bomVo) {   		
   		List<BomMasterVO> list = bomMasterService.bomListAll(bomVo);
   		//UserLogUtil.saveUserLog("BomMasterController","BOM List ALL","GET");
   		return Responses.ListResponse.of(list);
   	}
    
   	@RequestMapping(value = "bomDetailList", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse bomDetailList(RequestParams<BomDetailVO> bomVo) {   		
   		List<BomDetailVO> list = bomMasterService.bomDetailList(bomVo);
   		//UserLogUtil.saveUserLog("BomMasterController","BOM Detail List","GET");
   		return Responses.ListResponse.of(list);
   	}

   	@RequestMapping(value = "forwardBomList", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse forwardBomList(RequestParams<BomDetailVO> bomVo) {   		
   		List<BomDetailVO> list = bomMasterService.forwardBomList(bomVo);
   		//UserLogUtil.saveUserLog("BomMasterController","BOM Detail List All","GET");
   		return Responses.ListResponse.of(list);
   	}
   	
   	@RequestMapping(value = "forwardBomList2", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse forwardBomList2(RequestParams<BomDetailVO> bomVo) {   		
   		List<BomDetailVO> list = bomMasterService.forwardBomList2(bomVo);
   		//UserLogUtil.saveUserLog("BomMasterController","BOM Detail List All2","GET");
   		return Responses.ListResponse.of(list);
   	}

   	@RequestMapping(value = "bomRoutingDetailList", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse bomRoutingDetailList(RequestParams<BomDetailVO> bomVo) {   		
   		List<BomDetailVO> list = bomMasterService.bomRoutingDetailList(bomVo);
   		//UserLogUtil.saveUserLog("BomMasterController","BOM Routing Detail List","GET");
   		return Responses.ListResponse.of(list);
   	}

   	@RequestMapping(value = "backwardBomList", method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse backwardBomList(RequestParams<BomItemVO> bomVo) {   		
   		List<BomItemVO> list = bomMasterService.backwardBomList(bomVo);
   		return Responses.ListResponse.of(list);
   	}
   	
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public BomMaster saveBom(@RequestBody BomMaster request) {
    	//UserLogUtil.saveUserLog("BomMasterController","BOM Save","PUT");
    	return bomMasterService.saveBom(request);
    }
}