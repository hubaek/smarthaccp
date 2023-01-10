package com.ppm.mes.domain.bod.bod100;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.chequer.axboot.core.parameter.RequestParams;
import com.chequer.axboot.core.utils.CookieUtils;
import com.ppm.mes.domain.BaseService;
import com.ppm.mes.domain.key.work.WorkKeyManagementService;
import com.ppm.mes.utils.SessionUtils;
 
@Service
public class BoardManageService extends BaseService <BoardManage,BoardManage.BoardManageId>{
    private BoardManageRepository repository;
    
    @Inject private BoardManageMapper boardManageMapper;
    @Inject private WorkKeyManagementService workKeyManagementService;
    
    @Inject
    public BoardManageService(BoardManageRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<BoardManageVO> getBoardList(RequestParams<BoardManageVO> vo) {  
    	return boardManageMapper.getBoardList(vo);
    }
    

    @Transactional
    public List<BoardManageVO> getBoardView(RequestParams<BoardManageVO> vo) {  
		String boardCd = vo.getString("boardCd", "");
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String cookieBoardCode = CookieUtils.getCookieValue(request, boardCd);
          
		if(isEmpty(cookieBoardCode)){
		   HttpServletResponse  response = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
		      CookieUtils.addCookie(response, boardCd, boardCd);
		
		   update(qBoardManage)
		     .set(qBoardManage.viewCnt , qBoardManage.viewCnt.add(new Long(1)))
		       .where(qBoardManage.boardCd.eq(boardCd)).execute();      
		}	
		
    	return boardManageMapper.getBoardList(vo);
    }
    

    @Transactional
    public void saveBoard(BoardManage m) {
    	if (null!=m) {  
    		String boardCd = "";
			if(isEmpty(m.getBoardCd())){
				boardCd = workKeyManagementService.getYymmCode("BOARD_CD", "BD", 3);   
				
				m.setBoardCd(boardCd);		
				m.setUserCd(SessionUtils.getCurrentLoginUserCd());
				m.setViewCnt(new Long(0));
				
		        update(qCommonFile)
		        .set(qCommonFile.targetId , m.getBoardCd())
	        		.where(qCommonFile.targetId.eq(m.getTempFileCd())
		        			.and(qCommonFile.targetType.eq("BOARD_CD"))
		        			.and(qCommonFile.tempYn.eq("Y"))).execute();		
			}			
			save(m);  
		}
    }

    /*
   	 * 추가된 게시판 Service
   	 * 1. 자료실(제품)
   	 * 2. 자료실(회사)
   	 * 3. 지원사업
   	 */
    public List<Map<String, Object>> selectBoardTypeItem(Map<String, Object> paramMap) {  
    	return boardManageMapper.selectBoardTypeItem(paramMap);
    }
    
    public List<Map<String, Object>> selectBoardTypeComp(Map<String, Object> paramMap) {  
    	return boardManageMapper.selectBoardTypeComp(paramMap);
    }
    
    public List<Map<String, Object>> selectBoardTypeBusi(Map<String, Object> paramMap) {  
    	return boardManageMapper.selectBoardTypeBusi(paramMap);
    }
    
    @Transactional
    public void saveBoardType(Map<String, Object> saveMap) {
    	String boardtype = String.valueOf(saveMap.get("boardtype"));
    	String mode = String.valueOf(saveMap.get("mode"));
    	
    	saveMap.put("userCd", SessionUtils.getCurrentLoginUserCd());
    	if(boardtype.equals("NOTICE_ITEM")){//자료실(제품)
    		if(mode.equals("add")){
    			boardManageMapper.insertBoardNoticeItem(saveMap);
    		}else{
    			boardManageMapper.updateBoardNoticeItem(saveMap);
    		}
    	}else if(boardtype.equals("NOTICE_Comp")){//자료실(회사)
    		if(mode.equals("add")){
    			boardManageMapper.insertBoardNoticeComp(saveMap);
    		}else{
    			boardManageMapper.updateBoardNoticeComp(saveMap);
    		}
    	}else{//지원사업
    		if(mode.equals("add")){
    			boardManageMapper.insertBoardNoticeBusi(saveMap);
    		}else{
    			boardManageMapper.updateBoardNoticeBusi(saveMap);
    		}
    	}
    }
    
    @Transactional
    public void deleteBoardTypeItem(Map<String, Object> deleteMap) {
    	boardManageMapper.deleteBoardNoticeItem(deleteMap);
    	boardManageMapper.deleteBoardNoticeFileInfo(deleteMap);
    }
    
    @Transactional
    public void deleteBoardTypeComp(Map<String, Object> deleteMap) {
    	boardManageMapper.deleteBoardNoticeComp(deleteMap);
    	boardManageMapper.deleteBoardNoticeFileInfo(deleteMap);
    }
    
    @Transactional
    public void deleteBoardTypeBusi(Map<String, Object> deleteMap) {
    	boardManageMapper.deleteBoardNoticeBusi(deleteMap);
    	boardManageMapper.deleteBoardNoticeFileInfo(deleteMap);
    }
}