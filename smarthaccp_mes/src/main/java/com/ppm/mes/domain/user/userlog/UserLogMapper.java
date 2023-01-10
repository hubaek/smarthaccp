package com.ppm.mes.domain.user.userlog;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;

public interface UserLogMapper extends MyBatisMapper {
	List<Map<String,Object>> getSendLogData();
	void saveResult(Map<String,Object> param);
	List<Map<String, Object>> getSendLogHis();
	
	void execQuery(Map<String,Object> param);
}  
