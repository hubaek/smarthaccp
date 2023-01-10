package com.ppm.mes.domain.user.user100;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
public interface UserCompanyMapper extends MyBatisMapper {
	List<UserCompanyVO> getUserCompanyList(RequestParams<UserCompanyVO> requestParams);
}  