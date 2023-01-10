package com.ppm.mes.domain.calendar;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;

public interface CalendarMapper  extends MyBatisMapper{
	List<Map<String, Object>> selectcalendarlist(Map<String, Object> param);
}
