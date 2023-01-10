package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.auth.auth000.AuthGroup;
import com.ppm.mes.domain.auth.auth000.AuthGroupService;
import com.ppm.mes.domain.auth.auth000.AuthGroupVO;
import com.ppm.mes.domain.auth.auth000.AuthMenuVO;
import com.ppm.mes.domain.auth.auth010.AuthGroupUser;
import com.ppm.mes.domain.auth.auth010.AuthGroupUserService;
import com.ppm.mes.domain.user.user050.UserAuth;
import com.ppm.mes.domain.user.user050.UserAuthService;


@Controller
@RequestMapping(value = "/api/v1/authGroup")
public class AuthGroupController extends BaseController {

	@Inject private AuthGroupService authGroupService;
	@Inject private AuthGroupUserService authGroupUserService;   
	@Inject private UserAuthService userAuthService;

	@RequestMapping(value = "group", method = RequestMethod.GET, produces = APPLICATION_JSON)	
    public Responses.ListResponse getGroupList(RequestParams<AuthGroup> requestParams) {
		List<AuthGroup> list = authGroupService.getGroupList(requestParams);
        return Responses.ListResponse.of(list); 
    }
	
	@RequestMapping(value = "authGroup", method = RequestMethod.GET, produces = APPLICATION_JSON)	
    public Responses.ListResponse getAuthGroupList(RequestParams<AuthGroupVO> requestParams) {
		List<AuthGroupVO> list = authGroupService.getAuthGroupList(requestParams);
        return Responses.ListResponse.of(list); 
    }
	
    @RequestMapping(value = "group", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public AuthGroup saveGroup(@RequestBody AuthGroup m) {
    	return authGroupService.saveGroup(m);
    }

    @RequestMapping(value = "group", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteGroup(@RequestParam(value = "mainCd") String mainCd) {
    	//authGroupService.deleteByKeys(mainCd);
    	//	authGroupService.delete(mainCd);
        return ok();
    }
    
    @RequestMapping(value = "authUser", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getAuthUserList(RequestParams<AuthGroupVO> requestParams) {
		List<AuthGroupVO> list = authGroupService.getAuthUserList(requestParams);
        return Responses.ListResponse.of(list); 
    } 
    
    @RequestMapping(value = "user", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getGroupUserList(RequestParams<AuthGroupUser> requestParams) {
		List<AuthGroupUser> codes = authGroupUserService.getGroupUserList(requestParams);
        return Responses.ListResponse.of(codes); 
    } 
    
    @RequestMapping(value = "user", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveGroupUserList(@RequestBody List<AuthGroupUser> list) {
        authGroupUserService.save(list);
        return ok(); 
    }    
    
    @RequestMapping(value = "detail", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse childDelete(@RequestParam(value = "subCd") List<String> subCodes) {
    //	authGroupUserService.deleteByKeys(subCodes);
        return ok();
    }
    
    @RequestMapping(value = "userAuth", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getGroupUserAuthList(RequestParams<UserAuth> requestParams) {
		List<UserAuth> codes = userAuthService.get(requestParams);
        return Responses.ListResponse.of(codes); 
    } 

    @RequestMapping(value = "userAuthList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getUserAuthList(RequestParams<AuthGroupVO> requestParams) {
		List<AuthGroupVO> list = authGroupService.getUserAuthList(requestParams);
        return Responses.ListResponse.of(list); 
    } 

    @RequestMapping(value = "userAuth", method = {RequestMethod.POST, RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveGroupUserAuthList(@RequestBody List<UserAuth> list) {
    	userAuthService.save(list);
        return ok(); 
    }    

    @RequestMapping(value = "authMenu", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getAuthMenuList(RequestParams<AuthMenuVO> requestParams) {
		List<AuthMenuVO> list = authGroupService.getAuthMenuList(requestParams);
        return Responses.ListResponse.of(list); 
    } 
}