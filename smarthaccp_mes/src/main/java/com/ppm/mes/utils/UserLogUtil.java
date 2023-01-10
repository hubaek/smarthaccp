package com.ppm.mes.utils;

import com.chequer.axboot.core.context.AppContextManager;
import com.ppm.mes.domain.user.userlog.UserLogService;

public class UserLogUtil {
	
	public static void saveUserLog(String programCode,String programNm, String programAction) {
		getService().saveUserLog(programCode,programNm,programAction);
    }
	
	public static void saveUserLog(String userCd, String programCode,String programNm, String programAction) {
		getService().saveUserLog(userCd,programCode,programNm,programAction);
    }
    
    public static UserLogService getService() {
        return AppContextManager.getBean(UserLogService.class);
    }  
}
