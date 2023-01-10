package com.ppm.mes.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.st.st400.MoveInout;
import com.ppm.mes.domain.st.st400.MoveInoutService;
import com.ppm.mes.domain.st.st400.MoveInoutVO;
/*
 * 이동관리
 */
@Controller
@RequestMapping(value = "/api/v1/moveInout")	//이동
public class MoveInoutController extends BaseController {

    @Inject
    private MoveInoutService moveInoutService;
    
   	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
   	public Responses.ListResponse header(RequestParams<MoveInoutVO> estimate) {
   		List<MoveInoutVO> list = moveInoutService.header(estimate);
   		return Responses.ListResponse.of(list);

   	}

	@RequestMapping(value = "itemList", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Responses.ListResponse itemList(RequestParams<MoveInoutVO> estimate) {
		List<MoveInoutVO> list = moveInoutService.itemDetail(estimate);
		return Responses.ListResponse.of(list);
	}
	
    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public MoveInout save(@RequestBody MoveInout m) {
    	return moveInoutService.saveMoveInout(m);
    }
}