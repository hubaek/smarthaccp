package com.ppm.mes.domain.health.health000;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface HealthMapper extends MyBatisMapper {

	List<HealthVO> getHealthList(RequestParams<HealthVO> vo);

	List<HealthVO> getAlarmList(RequestParams<Health> params);

}  