package com.ppm.mes.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.user.user000.User;
import com.ppm.mes.domain.user.userlog.UserLog;
import com.ppm.mes.domain.user.userlog.UserLogService;
import com.ppm.mes.utils.UserLogUtil;

@Controller
@RequestMapping(value = "/api/v1/userLogs")
public class UserLogViewController extends BaseController {

    @Inject private UserLogService userLogService;

    
   /* @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.PageResponse list(Pageable pageable, @RequestParam(required = false) String searchParams) {
        Page<UserLog> errorLogPage = userLogService.findAll(pageable, searchParams);
        return Responses.PageResponse.of(errorLogPage);
    }*/
    
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse list(RequestParams<User> searchParams) {
		List<UserLog> userLogs = userLogService.getUserLogList(searchParams);
        return Responses.ListResponse.of(userLogs); 
    } 

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = APPLICATION_JSON)
    public ApiResponse delete(@PathVariable(value = "id") Long id) {
    	userLogService.delete(id);
        return ok();
    }

    @RequestMapping(value = "/events/all", method = RequestMethod.DELETE, produces = APPLICATION_JSON)
    public ApiResponse deleteAll() {
    	userLogService.deleteAllLogs();
        return ok();
    }
    
   	@RequestMapping(value ="/saveLog", method = {RequestMethod.POST}, produces = APPLICATION_JSON)
    public void save(@RequestBody Map<String, Object> paramMap) {
   		//System.out.println("paramMap : " + paramMap);

   		String ModuleName = String.valueOf(paramMap.get("MODULE"));
   		String PgmName = String.valueOf(paramMap.get("PGM"));
   		String CRUDtype = String.valueOf(paramMap.get("CRUDType"));
   		String ActionType = String.valueOf(paramMap.get("ActionType"));

   		if(CRUDtype.equals("S")){//조회
   			UserLogUtil.saveUserLog(ModuleName, PgmName, "SEARCH(Action : " + ActionType + ")");
   		}else if(CRUDtype.equals("C")){//저장
   			UserLogUtil.saveUserLog(ModuleName, PgmName, "INSERT(Action : " + ActionType + ")");
   		}else if(CRUDtype.equals("U")){//수정
   			UserLogUtil.saveUserLog(ModuleName, PgmName, "UPDATE(Action : " + ActionType + ")");
   		}else if(CRUDtype.equals("D")){//삭제
   			UserLogUtil.saveUserLog(ModuleName, PgmName, "DELETE(Action : " + ActionType + ")");
   		}
    }
  //조회
    @RequestMapping(value ="/getSendLogHis", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<Map<String, Object>> getSendLogHis() {
		List<Map<String, Object>> list = userLogService.getSendLogHis();
        return list; 
    }
}
