package com.ppm.mes.domain.cd.cd100;

import java.util.List;

import com.chequer.axboot.core.mybatis.MyBatisMapper;
import com.chequer.axboot.core.parameter.RequestParams;
 
 
public interface BasicCodeDetailMapper extends MyBatisMapper {
    List<BasicCodeDetailVO> getAllByCodeMap(RequestParams<BasicCodeDetailVO> vo);
    List<BasicCodeDetailVO> getBasicDetailList(RequestParams<BasicCodeDetailVO> vo);
    List<BasicCodeDetailVO> getBasicDetailLangList(RequestParams<BasicCodeDetailVO> vo);
}  