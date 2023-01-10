package com.ppm.mes.domain.bod.bod100;

import java.util.List;
import java.util.Map;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface BoardManageMapper extends MyBatisMapper {
    List<BoardManageVO> getBoardList(RequestParams<BoardManageVO> vo);
    
  //조회
    public List<Map<String, Object>> selectBoardTypeItem(Map<String, Object> paramMap);
    public List<Map<String, Object>> selectBoardTypeComp(Map<String, Object> paramMap);
    public List<Map<String, Object>> selectBoardTypeBusi(Map<String, Object> paramMap);
    
    //저장, 수정
    public void insertBoardNoticeItem(Map<String, Object> saveMap);
    public void updateBoardNoticeItem(Map<String, Object> saveMap);
    public void insertBoardNoticeComp(Map<String, Object> saveMap);
    public void updateBoardNoticeComp(Map<String, Object> saveMap);
    public void insertBoardNoticeBusi(Map<String, Object> saveMap);
    public void updateBoardNoticeBusi(Map<String, Object> saveMap);
    
    //삭제
    public void deleteBoardNoticeItem(Map<String, Object> deleteMap);
    public void deleteBoardNoticeComp(Map<String, Object> deleteMap);
    public void deleteBoardNoticeBusi(Map<String, Object> deleteMap);
    public void deleteBoardNoticeFileInfo(Map<String, Object> deleteMap);
}  