package com.ppm.mes.domain.qc.qc300;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface QcResultMasterMapper extends MyBatisMapper {
    List<QcResultMasterVO> getQcMasterList(RequestParams<QcResultMasterVO> vo);  
    List<QcResultDetailVO> getQcResultDetail(RequestParams<QcResultDetailVO> vo);    

    //공정검사대상마스터
    List<QcResultMasterVO> getRoutQcMaster(RequestParams<QcResultMasterVO> vo);    
    
}