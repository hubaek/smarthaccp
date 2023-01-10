package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetailService;
import com.ppm.mes.domain.cd.cd100.BasicCodeDetailVO;
import com.ppm.mes.domain.cp.cp000.CompanyManagement;
import com.ppm.mes.domain.cp.cp000.CompanyManagementService;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;


//오픈 API 
@RestController
public class OpenAPIController extends BaseController {	
	
	@Inject private CompanyManagementService companyManagementService;
	@Inject private BasicCodeDetailService basicCodeDetailService;
	
	@RequestMapping(value = "/api/v1/open/getCompany", method = RequestMethod.GET, produces = APPLICATION_JSON)	
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "useYn", value = "useYn", dataType = "String", paramType = "query", required = false)
	})
	public Responses.ListResponse getCompany(RequestParams<CompanyManagement> requestParams) {
        List<CompanyManagement> list = companyManagementService.gets(requestParams);
        return Responses.ListResponse.of(list);
    }
	

	@RequestMapping(value = "/api/v1/open/getLocale", method = RequestMethod.GET, produces = APPLICATION_JSON)	
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "mainCd", value = "mainCd", dataType = "String", paramType = "query", required = false)
	})
	public Responses.ListResponse getLocale(RequestParams<BasicCodeDetailVO> requestParams) {
        List<BasicCodeDetailVO> list = basicCodeDetailService.getBasicDetailList(requestParams);
        return Responses.ListResponse.of(list);
    }

    @RequestMapping(value = "/api/v1/open/apiCm", method = RequestMethod.GET)
    public ApiResponse ifUser(@RequestParam String ifType) throws Exception {
        return ok();
    }    
}
