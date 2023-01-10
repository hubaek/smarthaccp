package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.cp.cp000.CompanyManagement;
import com.ppm.mes.domain.cp.cp000.CompanyManagementService;
import com.ppm.mes.domain.cp.cp100.TbCmmsCp100;
import com.ppm.mes.domain.cp.cp100.TbCmmsCp100Service;

/*
 * 회사/사업장관리
 */
@Controller
@RequestMapping(value = "/api/v1/company")
public class CompanyController extends BaseController {

	@Inject private CompanyManagementService companyManagementService;
	@Inject private TbCmmsCp100Service tbCmmsCp100Service;
	
	@RequestMapping(value = "company", method = RequestMethod.GET, produces = APPLICATION_JSON)	
	public Responses.ListResponse getCompany(RequestParams<CompanyManagement> requestParams) {
        List<CompanyManagement> list = companyManagementService.gets(requestParams);
        return Responses.ListResponse.of(list);
    }	

	@RequestMapping(value = "company", method = RequestMethod.PUT, produces = APPLICATION_JSON)	
    public ApiResponse saveCompany(@Valid @RequestBody CompanyManagement request) {
        companyManagementService.save(request);
        return ok();
    }
	
	@RequestMapping(value = "cp100", method = RequestMethod.GET, produces = APPLICATION_JSON)	
	public Responses.ListResponse getCp100List(RequestParams<TbCmmsCp100> requestParams) {
        List<TbCmmsCp100> list = tbCmmsCp100Service.getCp100List(requestParams);
        return Responses.ListResponse.of(list);
    }	

	@RequestMapping(value = "cp100", method = RequestMethod.PUT, produces = APPLICATION_JSON)	
    public ApiResponse saveCp100List(@RequestBody List<TbCmmsCp100> list) {
		tbCmmsCp100Service.save(list);
        return ok();
    }
}
