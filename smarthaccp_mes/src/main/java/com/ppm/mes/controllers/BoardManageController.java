package com.ppm.mes.controllers;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.ppm.mes.domain.bod.bod100.BoardManage;
import com.ppm.mes.domain.bod.bod100.BoardManageService;
import com.ppm.mes.domain.bod.bod100.BoardManageVO;

@Controller
@RequestMapping(value = "/api/v1/board")
public class BoardManageController extends BaseController {
    @Inject private BoardManageService boardManageService;

   	// 조회
   	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getList(RequestParams<BoardManageVO> requestParams) {   
        List<BoardManageVO> list = boardManageService.getBoardList(requestParams);
        return Responses.ListResponse.of(list);
   	}

   	//저장
   	@RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse saveBoard(@RequestBody BoardManage m) {    	
    	boardManageService.saveBoard(m);
    	return ok();
    }
   	
   	//삭제
   	@RequestMapping(method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteBoard(@RequestBody BoardManage m) {    	
    	boardManageService.delete(m);
    	return ok();
    }

   	// 조회
   	@RequestMapping(value="view" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public Responses.ListResponse getView(RequestParams<BoardManageVO> requestParams) {    
        List<BoardManageVO> list = boardManageService.getBoardView(requestParams);
        return Responses.ListResponse.of(list);
   	}
   	
   	/*
   	 * 추가된 게시판 Service
   	 * 1. 자료실(제품)
   	 * 2. 자료실(회사)
   	 */
   	
   	// 조회(자료실(제품))
   	@RequestMapping(value="selectBoardTypeItem" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<Map<String, Object>> selectBoardTypeItem(@RequestParam Map<String, Object> requestParams) {
        List<Map<String, Object>> list = boardManageService.selectBoardTypeItem(requestParams);
        return list;
   	}
   	
   	// 조회(자료실(회사))
   	@RequestMapping(value="selectBoardTypeComp" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<Map<String, Object>> selectBoardTypeComp(@RequestParam Map<String, Object> requestParams) {
        List<Map<String, Object>> list = boardManageService.selectBoardTypeComp(requestParams);
        return list;
   	}
   	
   	// 조회(지원사업)
   	@RequestMapping(value="selectBoardTypeBusi" , method = RequestMethod.GET, produces = APPLICATION_JSON)
    public List<Map<String, Object>> selectBoardTypeBusi(@RequestParam Map<String, Object> requestParams) {
        List<Map<String, Object>> list = boardManageService.selectBoardTypeComp(requestParams);
        return list;
   	}
   	
   	//저장(공통)
   	@RequestMapping(value="saveBoardType", method = {RequestMethod.POST}, produces = APPLICATION_JSON)
    public ApiResponse saveBoardType(@RequestBody Map<String, Object> saveMap) {    	
   		boardManageService.saveBoardType(saveMap);
    	return ok();
    }
   	
    //삭제(자료실(제품))
   	@RequestMapping(value="deleteBoardTypeItem", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteBoardTypeItem(@RequestBody Map<String, Object> deleteMap) {    	
   		boardManageService.deleteBoardTypeItem(deleteMap);
    	return ok();
    }
   	
   	//삭제(자료실(회사))
   	@RequestMapping(value="deleteBoardTypeComp", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteBoardTypeComp(@RequestBody Map<String, Object> deleteMap) {    	
   		boardManageService.deleteBoardTypeComp(deleteMap);
    	return ok();
    }
   	//삭제(자료실(회사))
   	@RequestMapping(value="deleteBoardTypeBusi", method = {RequestMethod.DELETE}, produces = APPLICATION_JSON)
    public ApiResponse deleteBoardTypeBusi(@RequestBody Map<String, Object> deleteMap) {    	
   		boardManageService.deleteBoardTypeComp(deleteMap);
    	return ok();
    }
}