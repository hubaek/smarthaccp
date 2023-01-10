package com.ppm.mes.domain.qc.qc200;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface QcItemMapper extends MyBatisMapper {
    List<QcItemVO> getQcItem(RequestParams<QcItemVO> vo);
    List<QcItemVO> getQcGroupItem(RequestParams<QcItemVO> vo);
    
    List<QcItemTargetVO> getQcItemTargetList(RequestParams<QcItemTargetVO> vo);
    List<QcItemTargetVO> getQcRoutItemTargetList(RequestParams<QcItemTargetVO> vo);

    List<QcItemVO> getQcRoutItemSetupList(RequestParams<QcItemVO> vo);
}