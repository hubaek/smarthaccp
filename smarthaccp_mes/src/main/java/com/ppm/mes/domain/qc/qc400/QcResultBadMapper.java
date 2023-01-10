package com.ppm.mes.domain.qc.qc400;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface QcResultBadMapper extends MyBatisMapper {
    List<QcResultBadVO> getQcBadList(RequestParams<QcResultBadVO> vo);    
    List<QcResultBadVO> getQcBadDetailList(RequestParams<QcResultBadVO> vo);
}