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
import com.ppm.mes.domain.user.user000.PopAuthUserVO;
import com.ppm.mes.domain.user.user000.User;
import com.ppm.mes.domain.user.user000.UserService;
import com.ppm.mes.domain.user.user000.UserVO;

/*
 * 사용자관리
 */
@Controller
@RequestMapping(value = "/api/v1/users")
public class UserController extends BaseController {

    @Inject private UserService userService;

    @RequestMapping(value ="user", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse list(RequestParams<User> requestParams) {
        List<User> users = userService.get(requestParams);
        //UserLogUtil.saveUserLog("UserController","User","GET");
        return Responses.ListResponse.of(users);
    }

    @RequestMapping(value ="userList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getUserList(RequestParams<UserVO> requestParams) { 		 
        List<UserVO> users = userService.getUserList(requestParams);
        //UserLogUtil.saveUserLog("UserController","User List","GET");
        return Responses.ListResponse.of(users);
    }


    @RequestMapping(value ="getPopAuthUserList", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getPopAuthUserList(RequestParams<PopAuthUserVO> requestParams) { 		 
        List<PopAuthUserVO> users = userService.getPopAuthUserList(requestParams);
        return Responses.ListResponse.of(users);
    }

    @RequestMapping(value="changePw",method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public ApiResponse changePw(@RequestBody User users) throws Exception {
    	//UserLogUtil.saveUserLog("UserController","Change PW","PUT");
        userService.changePw(users);
        return ok();
    }  

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON, params = "userCd")
    public User get(RequestParams requestParams) {
        return userService.getUser(requestParams);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = APPLICATION_JSON)
    public ApiResponse save(@Valid @RequestBody User users) throws Exception {
    	//UserLogUtil.saveUserLog("UserController","User","PUT");
        userService.saveUser(users);
        return ok();
    }  
}
