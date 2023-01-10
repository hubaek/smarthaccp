package com.ppm.mes.domain.scheduler;


import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.ppm.mes.domain.lmt.master.LmtMasterVO;
import com.ppm.mes.domain.user.user000.UserVO;

public interface SchedulerMapper extends MyBatisMapper{

	String temp(Map<String, String> paramMap);

	String maxTemp(Map<String, String> paramMap2);
	String minTemp(Map<String, String> paramMap2);

	List<UserVO> getUserPhoneList();
	
	void metalSms();

	void tempSms(Map<String, String> paramMap);

	String metal(Map<String, String> paramMap);

	String TempNm(Map<String, String> paramMap2);
	
	//init lmtchk
	Map<String, String> getlastsensingdata(Map<String, String> paramMap);
	void updatetime(Map<String, String> saveMap);
	void cleartime(Map<String, String> saveMap);
}
