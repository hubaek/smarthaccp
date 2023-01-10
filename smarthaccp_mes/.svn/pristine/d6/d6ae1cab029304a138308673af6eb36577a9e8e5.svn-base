package com.ppm.mes.utils;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.code.AXBootTypes;
import com.chequer.axboot.core.context.AppContextManager;
import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.JsonUtils;
import com.ppm.mes.domain.cp.cp000.CompanyManagement;
import com.ppm.mes.domain.cp.cp000.CompanyManagementService;
import com.ppm.mes.domain.user.user100.UserCompanyService;
import com.ppm.mes.domain.user.user100.UserCompanyVO;

public class CompanyCodeUtils {

	public static List<CompanyManagement> get(String company) {		 
        RequestParams<CompanyManagement> requestParams = new RequestParams<>(CompanyManagement.class);
        requestParams.put("company", company);
        requestParams.put("useYn", "Y");
        return getCompanyManagementService().gets(requestParams);        
    }

	public static List<UserCompanyVO> getUserCompany(String company, String userCd) {
       RequestParams<UserCompanyVO> requestParams = new RequestParams<>(UserCompanyVO.class);
       requestParams.put("company", company);  
       requestParams.put("userCd", userCd);
       return getUserCompanyService().getUserCompanyList(requestParams);
	}

	public static String getAllByJson() {
        return JsonUtils.toJson(getAllByMap());
    }
	 
	public static Map<String, List<CompanyManagement>> getAllByMap() {
        RequestParams<CompanyManagement> requestParams = new RequestParams<>(CompanyManagement.class);
        requestParams.put("useYn", AXBootTypes.Used.YES.getLabel());
	    List<CompanyManagement> companyCodes = getCompanyManagementService().getAllByMap(requestParams);
  
	    Map<String, List<CompanyManagement>> companyCodeMap = companyCodes.stream().collect(groupingBy(CompanyManagement::getCompany));	    
	    companyCodeMap.put("COMPANY", companyCodes);
	    return companyCodeMap;
	}

    public static CompanyManagementService getCompanyManagementService() {
        return AppContextManager.getBean(CompanyManagementService.class);
    }

    public static UserCompanyService getUserCompanyService() {
        return AppContextManager.getBean(UserCompanyService.class);
    }
}
