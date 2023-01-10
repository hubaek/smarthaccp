package com.ppm.mes.domain.calendar;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {
	
	@Autowired 
	private CalendarMapper calendarmapper;
	
	public List<Map<String, Object>> selectcalendarlist(Map<String, Object> param){
    	return calendarmapper.selectcalendarlist(param);
    } 
}
