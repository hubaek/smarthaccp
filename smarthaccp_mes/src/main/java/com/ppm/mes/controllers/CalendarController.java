package com.ppm.mes.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chequer.axboot.core.controllers.BaseController;
import com.ppm.mes.domain.calendar.CalendarService;

@Controller
@RequestMapping(value = "/api/v1/calendar", method = RequestMethod.GET)
public class CalendarController extends BaseController{
	
	@Autowired
	private CalendarService calendarservice;
	
	//조회
    @RequestMapping(value ="/selectcalendarlist", method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<Map<String, Object>> selectcalendarlist(@RequestParam Map<String, Object> param) {
		List<Map<String, Object>> list = calendarservice.selectcalendarlist(param);
        return list; 
    }
}
